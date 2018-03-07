package com.bryonnicoson.simpleasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String MTEXTVIEW_STATE = "mTextViewCurrentText";

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView1);

        if(savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(MTEXTVIEW_STATE));
        }
    }

    public void startTask(View view) {
        mTextView.setText("Napping...");
        new SimpleAsyncTask(mTextView).execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MTEXTVIEW_STATE, mTextView.getText().toString());
    }
}
