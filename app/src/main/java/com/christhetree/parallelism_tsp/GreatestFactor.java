package com.christhetree.parallelism_tsp;

import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;

/**
 * Created by christhetree on 18/08/14.
 */
public class GreatestFactor extends ParallelTask {

    public GreatestFactor(int node, long start, long end, View view) {
        super(node, start, end, view);
    }

    @Override
    protected void Iteration() {

    }

//    @Override
//    public Object executeCommand(final Object... params) {
//        long number = (Long) params[0];
//        long greatestFactor = 0;
//        int percentage = 0;
//        for(long i = 2; i < number; ++i) {
//            if(number % i == 0) {
//                greatestFactor = i;
//            }
//            percentage = (int)((((double) i) / ((double) number)) * 100.0);
//            if(i % (number / 100) == 0) {
//                publishProgress(percentage);
//            }
//        }
//        return greatestFactor;
//    }
//
//    @Override
//    protected Object doInBackground(Object[] objects) {
//        return super.doInBackground(objects);
//        return null;
//    }
}
