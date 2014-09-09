package com.christhetree.parallelism_tsp;

import android.util.Log;
import android.util.Pair;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/**
* Created by christhetree on 01/09/14.
*/
public class ParallelCallable implements Callable<Object> {
    private long mStart;
    private long mEnd;
    private volatile Object[] mTaskParams;
    private volatile Object[] mResults;
    private boolean mCustomCancel = false;

    public ParallelCallable(final long start, final long end, final Object... taskParams) {
        mStart = start;
        mEnd = end;
        mTaskParams = taskParams;
        mResults = new Object[1];
    }

    public void CustomCancel() {
        mCustomCancel = true;
    }

    // TODO: use generics?
    @Override
    public Pair<Object[],Long> call() throws Exception {
//        android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_DEFAULT);
        long current;
        for(current = mStart; current <= mEnd; ++current) {
            ParallelTaskLibrary.GreatestFactor(current, mResults, mTaskParams);
            if(mCustomCancel) {
                break;
            }
        }
        return new Pair<Object[],Long>(mResults, current);
    }
}
