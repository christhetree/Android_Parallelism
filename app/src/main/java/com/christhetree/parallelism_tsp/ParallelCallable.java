package com.christhetree.parallelism_tsp;

import java.util.concurrent.Callable;

/**
* Created by christhetree on 01/09/14.
*/
public class ParallelCallable implements Callable<Object> {
    private Object[] mParams;
    private long greatestFactor2;

    public ParallelCallable(final Object... params) {
        mParams = params;
    }

    @Override
    public Object call() throws Exception {
//        android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_DEFAULT);

        long number = (Long) mParams[0];
        long start = (Long) mParams[1];
        long end = (Long) mParams[2];
//        long greatestFactor = 0;
        for(long i = start; i < end; ++i) {
            if(number % i == 0) {
                greatestFactor2 = i;
            }
//            percentage = (int)((((double) i) / ((double) number)) * 100.0);
//            if(i % (number / 100) == 0) {
//                publishProgress(percentage);
//            }
        }
        return greatestFactor2;



//        return ParallelTaskLibrary.GreatestFactor2(mParams);
    }

    public long getStuff() {
        return greatestFactor2;
    }
}
