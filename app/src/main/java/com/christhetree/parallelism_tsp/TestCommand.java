package com.christhetree.parallelism_tsp;

import android.widget.EditText;

/**
 * Created by christhetree on 18/08/14.
 */
public class TestCommand implements Command {
    @Override
    public void execute(final int index, final Object data, final Object view) {
        EditText editText = (EditText) view;
        editText.setText("merp");
        int x = 3;
    }
}
