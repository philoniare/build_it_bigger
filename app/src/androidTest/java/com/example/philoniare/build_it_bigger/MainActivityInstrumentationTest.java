package com.example.philoniare.build_it_bigger;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {
  @Rule
  public ActivityTestRule mActivityRule = new ActivityTestRule<>(
          MainActivity.class);

  @Test
  public void sayHello(){
    onView(withId(R.id.fetch_joke_btn)).perform(click());
    onView(withId(R.id.jokeTV)).check(matches(not(withText(""))));
  }
}
