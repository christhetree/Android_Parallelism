package com.christhetree.parallelism_tsp;

import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;

/**
 * Created by christhetree on 30/08/14.
 */
public abstract class ParallelTask extends AsyncTask<Object, Integer, Object> {
    private int mNode;
    private long mStart;
    private long mEnd;
    private View mView;

    public ParallelTask(final int node, final long start, final long end, final View view) {
        mNode = node;
        mStart = start;
        mEnd = end;
        mView = view;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(final Object... params) {
        Iteration();
        return null;
    }

    @Override
    protected void onProgressUpdate(final Integer... progress) {
        super.onProgressUpdate(progress);
    }

    @Override
    protected void onPostExecute(final Object result) {
        super.onPostExecute(result);
    }

    protected abstract void Iteration();
}
