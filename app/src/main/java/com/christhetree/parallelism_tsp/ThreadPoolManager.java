package com.christhetree.parallelism_tsp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by christhetree on 01/09/14.
 */
public class ThreadPoolManager {
//    public static ThreadPoolManager sInstance = new ThreadPoolManager(); // keep private?
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    // Sets the amount of time an idle thread waits before terminating
    private static final long KEEP_ALIVE_TIME = 2;
    // Sets the Time Unit to seconds
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private Handler mHandler;
    public ThreadPoolExecutor mTPE; // make private!

    private final BlockingQueue<Runnable> mDecodeWorkQueue;

    public ThreadPoolManager() {
        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(final Message inputMessage) {
            }
        };

        // Instantiates the queue of Runnables as a LinkedBlockingQueue
        mDecodeWorkQueue = new LinkedBlockingQueue<Runnable>();

        // Creates a thread pool manager
        mTPE = new ThreadPoolExecutor(4, 4, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, mDecodeWorkQueue);
//        mTPE = new ThreadPoolExecutor(
//                NUMBER_OF_CORES,       // Initial pool size
//                NUMBER_OF_CORES,       // Max pool size
//                KEEP_ALIVE_TIME,
//                KEEP_ALIVE_TIME_UNIT,
//                mDecodeWorkQueue);
    }
}
