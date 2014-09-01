package com.christhetree.parallelism_tsp;

import android.os.AsyncTask;
import android.widget.EditText;

public class GreatestFactorAsyncTask extends AsyncTask<Object, Integer, Object> { // make progress double
    private Command command;
    private EditText editText;

    public GreatestFactorAsyncTask(final Command command, final EditText editTest) {
        this.command = command;
        this.editText = editTest;
    }

    @Override
    protected void onPreExecute() {
//        editText.setText("0%");
    }

    @Override
    protected Object doInBackground(final Object... params) {
        return command.executeCommand(params);
    }

    @Override
    protected void onProgressUpdate(final Integer... progress) {
        editText.setText(Integer.toString(progress[0]));
    }

    @Override
    protected void onPostExecute(final Object result) {
        editText.setText("Greatest factor is: " + Long.toString((Long) result));
    }
}

