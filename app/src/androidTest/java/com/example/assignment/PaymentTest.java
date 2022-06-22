package com.example.assignment;

import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static java.util.regex.Pattern.matches;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)

public class PaymentTest {

    @Rule
    public ActivityScenarioRule<Settings> activityActivityScenarioRule = new ActivityScenarioRule<Settings>(Settings.class);



    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testbtn_payment(){
      onView(withId(R.id.btn_Payment))
              .check(ViewAssertions.matches(isDisplayed()));

    }

    @Test
    public void testTitle_homeActivity(){
        onView(withId(R.id.homeActivity_text))
                .check(ViewAssertions.matches(isDisplayed()));

    }

    @Test
    public void testTitle_amount(){
        onView(withId(R.id.txtAmount))
                .check(ViewAssertions.matches(isDisplayed()));

    }

    @Test
    public void testTitle_date(){
        onView(withId(R.id.txtDate))
                .check(ViewAssertions.matches(isDisplayed()));

    }

    @Test
    public void testTitle_tax(){
        onView(withId(R.id.txtTax))
                .check(ViewAssertions.matches(isDisplayed()));

    }


    @After
    public void tearDown() throws Exception {
    }
}