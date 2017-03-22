package com.example.tinag.calculator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CalculatorInstrumentedTest {

    @Rule
    public ActivityTestRule<Calculator> mActivityRule = new ActivityTestRule<>(Calculator.class);

    @Test
    public void testButtons() throws Exception {
        // Context of the app under test.
       // Context appContext = InstrumentationRegistry.getTargetContext();
        //assertEquals("com.example.tinag.calculator", appContext.getPackageName());

        for (int i=0; i<=9; i++){
            onView(withText(Integer.toString(i))).perform(click());
        }
        onView(withText("+")).perform(click());
        onView(withText("-")).perform(click());
        onView(withText("=")).perform(click());
        onView(withText("*")).perform(click());
        onView(withText("/")).perform(click());
        onView(withText("C")).perform(click());
    }

    @Test
    public void testInputField(){
        for(int i=9; i>=0; i--){
            onView(withText(Integer.toString(i))).perform(click());
        }
        onView(withText("9876543210")).check(matches(isDisplayed()));
    }

    @Test
    public void testClearButton(){
        onView(withText("3")).perform(click());
        onView(withText("C")).perform(click());

        onView(withId(R.id.textView)).check(matches(withText("0")));
    }

    @Test
    public void testAdd(){
        onView(withText("3")).perform(click());
        onView(withText("+")).perform(click());
        onView(withText("5")).perform(click());
        onView(withText("=")).perform(click());

        onView(withId(R.id.textView)).check(matches(withText("8")));
    }

    @Test
    public void testSub(){
        onView(withText("5")).perform(click());
        onView(withText("-")).perform(click());
        onView(withText("3")).perform(click());
        onView(withText("=")).perform(click());

        onView(withId(R.id.textView)).check(matches(withText("2")));
    }

    @Test
    public void testMult(){
        onView(withText("3")).perform(click());
        onView(withText("*")).perform(click());
        onView(withText("5")).perform(click());
        onView(withText("=")).perform(click());

        onView(withId(R.id.textView)).check(matches(withText("15")));
    }

    @Test
    public void testDiv(){
        onView(withText("8")).perform(click());
        onView(withText("/")).perform(click());
        onView(withText("2")).perform(click());
        onView(withText("=")).perform(click());

        onView(withId(R.id.textView)).check(matches(withText("4")));
    }

    @Test
    public void testDiv1(){
        onView(withText("8")).perform(click());
        onView(withText("/")).perform(click());
        onView(withText("0")).perform(click());
        onView(withText("=")).perform(click());

        onView(withId(R.id.textView)).check(matches(withText("0")));
    }

    @Test
    public void testNoEqual(){
        onView(withText("3")).perform(click());
        onView(withText("+")).perform(click());
        onView(withText("5")).perform(click());

        onView(withId(R.id.textView)).check(matches(withText("5")));
    }

    @Test
    public void testNum(){
        onView(withText("=")).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("0")));
    }
}

