package com.xingzy;

import android.app.Activity;
import android.view.Gravity;

import org.junit.Rule;
import org.junit.Test;

import androidx.appcompat.widget.Toolbar;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.contrib.DrawerMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;


/**
 * @author roy.xing
 * @date 2018/12/5
 */
public class GardenActivityTest {

    @Rule
    public ActivityTestRule<GardenActivity> rule = new ActivityTestRule<>(GardenActivity.class);

    @Test
    public void clickOnAndroidHomeIcon_OpensAndCloseNavigation() {
        Espresso.onView(ViewMatchers.withId(R.id.drawer_layout)).check(ViewAssertions.matches(DrawerMatchers.isClosed(Gravity.START)));

        clickOnHomeIconToOpenNavigationDrawer();
        checkDrawerIsOpen();
    }

    private void checkDrawerIsOpen() {
        Espresso.onView(ViewMatchers.withId(R.id.drawer_layout)).check(ViewAssertions.matches(DrawerMatchers.isOpen(Gravity.START)));
    }

    private void clickOnHomeIconToOpenNavigationDrawer() {
        Espresso.onView(ViewMatchers.withContentDescription(getToolbarNavigationContentDescription(rule.getActivity()))).perform(ViewActions.click());
    }

    private String getToolbarNavigationContentDescription(Activity activity) {
        return (String) ((Toolbar) (activity.findViewById(R.id.toolbar))).getNavigationContentDescription();
    }
}
