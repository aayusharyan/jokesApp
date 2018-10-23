package com.aayushsinha.jokesapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.aayushsinha.jokesapplib.androidlib.ShowJokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.aayushsinha.jokesapp.backend.jokesLib.*;
import com.google.api.client.json.gson.GsonFactory;

import java.io.IOException;

public class JokesAsyncTask extends AsyncTask<Context, Void, String> {
    private static JokesLib jokesLib = null;

    private Context context;

    public JokesAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Context... contexts) {

        if(jokesLib == null) {
            JokesLib.Builder builder = new JokesLib.Builder(
                    AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
            jokesLib = builder.build();
        }

        try {
            return jokesLib.tellJoke().execute().getJoke();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        String joke = s;
        MainActivity mainActivity = (MainActivity) context;

        if(joke != null) {
            Intent intent = new Intent(context, ShowJokeActivity.class);
            intent.putExtra(ShowJokeActivity.JOKE_INTENT, joke);
            context.startActivity(intent);

            try {
                mainActivity.setLoading(false);
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(context, mainActivity.getString(R.string.no_internet_toast), Toast.LENGTH_LONG).show();
            mainActivity.setLoading(false);
        }

        super.onPostExecute(s);
    }
}
