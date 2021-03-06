package com.example.assignment;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.assignment", appContext.getPackageName());
    }

    //public void ActivityScenarioRule<MainActivity> = new ActivityScenarioRule<>(Payment.class);

    @Rule
    public ActivityScenarioRule<Payment> activityScenarioRule=new ActivityScenarioRule<Payment>(Payment.class);

    @Test
    public void checkCreatePayment(){
        onView(withId(R.id.btn_CreatePayment))
                .perform(click());
        onView(withId(R.id.btn_CreatePayment))
                .check(matches(withText("Successfully create payment!")));
    }



}