package com.christhetree.parallelism_tsp;

import android.os.Process;
import android.util.Pair;
import android.widget.EditText;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/**
* Created by christhetree on 01/09/14.
*/
public class ParallelCallable implements Callable<Object> {
    private long mStart;
    private long mEnd;
    private ParallelTask mParallelTask;
    private EditText mEditText;
    private volatile Object[] mTaskParams;
    private volatile Object[] mResults;
    private boolean mCustomCancel = false;

    public ParallelCallable(final long start, final long end, final ParallelTask parallelTask, final EditText editText, final Object... taskParams) {
        mStart = start;
        mEnd = end;
        mParallelTask = parallelTask;
        mEditText = editText;
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

    // TODO: use generics?, make abstract and use default parallel callable class for primitive operations
    @Override
    public Pair<Object[], Long> call() throws Exception {
        android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_DEFAULT); // TODO: change?

        long onePercent = (long) ((mEnd - mStart) / 100d);
        long percentCounter = 0;
        int progressPercentage = 0;
        Object[] contents = new Object[2];
        contents[0] = mEditText;

        long current = 0;
        for(current = mStart; current <= mEnd; ++current) {
            mParallelTask.execute(current, mResults, mTaskParams); // TODO: change from object array?
            if(mCustomCancel) {
                break;
            }
            ++percentCounter;
            if(percentCounter == onePercent) {
                ++progressPercentage;
                contents[1] = progressPercentage;
                ThreadPoolManager.SendMessage(ThreadPoolManager.MessageType.UPDATE_UI, contents);
                percentCounter = 0;
            }
        }
        return new Pair<Object[], Long>(mResults, current);
    }
}
