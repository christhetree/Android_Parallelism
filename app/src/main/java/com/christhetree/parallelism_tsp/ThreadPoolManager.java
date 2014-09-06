package com.christhetree.parallelism_tsp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
    //    private Handler mHandler;
    private final BlockingQueue<Runnable> mExecutionQueue;
    private ThreadPoolExecutor mTPE;

    private static ThreadPoolManager sInstance = new ThreadPoolManager();

    private ThreadPoolManager() {
//        mHandler = new Handler(Looper.getMainLooper()) {
//            @Override
//            public void handleMessage(final Message inputMessage) {
//            }
//        };
        mExecutionQueue = new LinkedBlockingQueue<Runnable>();
        mTPE = new ThreadPoolExecutor(NUMBER_OF_CORES, NUMBER_OF_CORES, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, mExecutionQueue);
    }

    public static void execute(final Runnable runnable) {
        sInstance.mTPE.execute(runnable);
    }

    public static Future submit(final Callable callable) {
        return sInstance.mTPE.submit(callable);
    }

    //TODO: shutdown?
}
