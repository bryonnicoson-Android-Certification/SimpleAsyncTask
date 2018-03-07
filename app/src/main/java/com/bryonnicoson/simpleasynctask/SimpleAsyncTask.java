package com.bryonnicoson.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by bryon on 3/7/18.
 */

public class SimpleAsyncTask extends AsyncTask<Void, Integer, String> {

    TextView mTextView;

    public SimpleAsyncTask(TextView tv) {
        mTextView = tv;
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11) * 1000;

        for (int i = n; i > -1; i--) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return "Awake at last after sleeping for " + n + " milliseconds!";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        mTextView.setText("Nap termination in " + values[0] + " ms.");
    }

    protected void onPostExecute(String result) {
        mTextView.setText(result);
    }

}
