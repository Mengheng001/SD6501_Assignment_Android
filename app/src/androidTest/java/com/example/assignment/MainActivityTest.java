package com.example.assignment;

import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityActivityScenarioRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testToast_Logout(){
        onView(withId(R.id.btn_Logout))
                .perform(click())
                .check(matches(withText("You have been logout!")));
        //onView(withId(R.id.btn_Logout))


    }


    @After
    public void tearDown() throws Exception {
    }


}