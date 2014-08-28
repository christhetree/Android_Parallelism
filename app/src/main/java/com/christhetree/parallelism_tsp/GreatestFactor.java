package com.christhetree.parallelism_tsp;

import android.widget.EditText;

/**
 * Created by christhetree on 18/08/14.
 */
public class GreatestFactor implements Command {
    @Override
    public void execute(final int index, final Object data, final Object view) {
        long number = (Long) data;
        long greatestFactor = 0;
        EditText editText = (EditText) view;
        int percentage = 0;
        for(long i = 2; i < number; ++i) {
            if(number % i == 0) {
                greatestFactor = i;
            }
            percentage = (int)((((double) i) / ((double) number)) * 100.0);
        }
        editText.setText(Long.toString(greatestFactor));
    }
}
