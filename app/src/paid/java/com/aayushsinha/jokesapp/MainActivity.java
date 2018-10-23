package com.aayushsinha.jokesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showJoke(View view) {
        setLoading(true);

        new JokesAsyncTask(this).execute(this);
    }

    public void setLoading(boolean loading) {
        ProgressBar loadingBar  = findViewById(R.id.loadingBar);
        Button showJokeBtn      = findViewById(R.id.showJokeBtn);

        if(loading) {
            showJokeBtn.setVisibility(View.GONE);
            loadingBar.setVisibility(View.VISIBLE);
        } else {
            loadingBar.setVisibility(View.GONE);
            showJokeBtn.setVisibility(View.VISIBLE);
        }
    }
}
