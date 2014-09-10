package com.christhetree.parallelism_tsp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.widget.EditText;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static final long KEEP_ALIVE_TIME = 0;
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    private Handler mHandler;
    private ThreadPoolExecutor mTPE;

    public static class MessageType {
        public static final int UPDATE_UI = 0;
        public static final int ERROR = 1;
    }

    private static ThreadPoolManager sInstance = new ThreadPoolManager();

    private ThreadPoolManager() { // TODO: error checking!
        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(final Message inputMessage) {
                switch (inputMessage.what) {
                    case MessageType.UPDATE_UI:
                        Object[] content = (Object[]) inputMessage.obj;
                        if(content != null) {
                            EditText editText = (EditText) content[0];
                            editText.setText(Integer.toString((Integer) content[1]));
                        }
                        break;
                    case MessageType.ERROR:
                        break;
                    default:
                        super.handleMessage(inputMessage);
                }
            }
        };
        BlockingQueue<Runnable> executionQueue = new LinkedBlockingQueue<Runnable>();
        mTPE = new ThreadPoolExecutor(NUMBER_OF_CORES, NUMBER_OF_CORES, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, executionQueue);
    }

    public static int getNumberOfCores() {
        return NUMBER_OF_CORES;
    }

    public static void execute(final Runnable runnable) {
        sInstance.mTPE.execute(runnable);
    }

    public static Future submit(final Callable callable) {
        return sInstance.mTPE.submit(callable);
    }

    public static void SendMessage(final int messageType, final Object[] contents) {
        Message message = sInstance.mHandler.obtainMessage(messageType, contents);
        message.sendToTarget();
    }

    //TODO: shutdown?
}
