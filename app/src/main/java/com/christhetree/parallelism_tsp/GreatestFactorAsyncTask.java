package com.christhetree.parallelism_tsp;

import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;

public class GreatestFactorAsyncTask extends AsyncTask<Long, Integer, Long> {
    private EditText editText;

    public GreatestFactorAsyncTask(final View view) {
        editText = (EditText) view;
    }

    @Override
    protected void onPreExecute() {
        editText.setText("0%");
    }

    @Override
    protected Long doInBackground(final Long... params) {
        long number = params[0];
        long greatestFactor = 0;
        int percentage = 0;
        for(long i = 2; i < number; ++i) {
            if(number % i == 0) {
                greatestFactor = i;
            }
            percentage = (int)((((double) i) / ((double) number)) * 100.0);
            if(i % (number / 100) == 0) {
                publishProgress(percentage);
            }
        }
        return greatestFactor;
    }

    @Override
    protected void onProgressUpdate(final Integer... progress) {
        editText.setText(Integer.toString(progress[0]));
    }

    @Override
    protected void onPostExecute(final Long result) {
        editText.setText("Greatest factor is: " + Long.toString(result));
    }
}

