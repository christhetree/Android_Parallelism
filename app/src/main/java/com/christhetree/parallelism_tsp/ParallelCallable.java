package com.christhetree.parallelism_tsp;

import android.util.Pair;

import java.util.concurrent.Callable;

/**
* Created by christhetree on 01/09/14.
*/
public class ParallelCallable implements Callable<Object> {
    private long mStart;
    private long mEnd;
    private ParallelTask mParallelTask;
    private volatile Object[] mTaskParams;
    private volatile Object[] mResults;
    private boolean mCustomCancel = false;

    public ParallelCallable(final long start, final long end, final ParallelTask parallelTask, final Object... taskParams) {
        mStart = start;
        mEnd = end;
        mParallelTask = parallelTask;
        mTaskParams = taskParams;
        if(mParallelTask != null) {
            mResults = new Object[mParallelTask.numberOfResults()];
        } else {
            mResults = new Object[1];
        }
    }

    public void CustomCancel() {
        mCustomCancel = true;
    }

    // TODO: use generics?
    @Override
    public Pair<Object[],Long> call() throws Exception {
        // TODO: android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_DEFAULT);
        long current;
        for(current = mStart; current <= mEnd; ++current) {
            mParallelTask.execute(current, mResults, mTaskParams);
            if(mCustomCancel) {
                break;
            }
        }
        return new Pair<Object[],Long>(mResults, current);
    }
}
