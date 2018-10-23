package com.aayushsinha.jokesapp;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.aayushsinha.jokesapplib.androidlib.ShowJokeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class APITesting {
    @Rule public IntentsTestRule<MainActivity> mainActivityActivityTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void clickRecipe_opensRecipeActivity() {
        onView(withId(R.id.showJokeBtn)).perform(click());
        intended(hasComponent(ShowJokeActivity.class.getName()));
    }

}
