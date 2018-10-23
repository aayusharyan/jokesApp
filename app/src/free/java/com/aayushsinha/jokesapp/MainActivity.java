package com.aayushsinha.jokesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, getString(R.string.admob_app_id));

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
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
