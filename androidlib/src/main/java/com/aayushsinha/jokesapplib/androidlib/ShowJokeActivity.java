package com.aayushsinha.jokesapplib.androidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    public static String JOKE_INTENT = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        if (getIntent().hasExtra(JOKE_INTENT)) {
            String joke = getIntent().getStringExtra(JOKE_INTENT);
            TextView jokeView = findViewById(R.id.jokeView);
            jokeView.setText(joke);
        }
    }
}
