package com.christhetree.parallelism_tsp;

import android.util.Log;

/**
 * Created by christhetree on 06/09/14.
 */
public class ParallelRunnable implements Runnable {
    public boolean cancel = false;

    @Override
    public void run() {
        while(true) {
            Log.d("This is a tag", "This is the message");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(cancel){
                Log.d("This is a tag", "cancel is true bro!");
            }
        }
    }
}
