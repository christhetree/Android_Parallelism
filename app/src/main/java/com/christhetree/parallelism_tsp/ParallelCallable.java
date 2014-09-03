package com.christhetree.parallelism_tsp;

import android.os.*;
import android.os.Process;

import java.util.concurrent.Callable;

/**
 * Created by christhetree on 01/09/14.
 */
public class ParallelCallable implements Callable<Object> {
    private Object[] mParams;

    public ParallelCallable(final Object... params) {
        mParams = params;
    }

    @Override
    public Object call() throws Exception {
//        android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_DEFAULT);
        return DifferentTasks.GreatestFactor2(mParams);
    }
}
