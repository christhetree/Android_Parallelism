package com.christhetree.parallelism_tsp;

import android.util.Log;

import java.util.concurrent.Callable;

/**
 * Created by christhetree on 06/09/14.
 */
public class ParallelCallable2 implements Callable {
    boolean cancel = false;

    @Override
    public Object call() throws Exception {
        while (true) {
            Log.d("This is a tag", "This is the message");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (cancel) {
                Log.d("This is a tag", "cancel is true bro!");
                return null;
            }
        }
    }
}
