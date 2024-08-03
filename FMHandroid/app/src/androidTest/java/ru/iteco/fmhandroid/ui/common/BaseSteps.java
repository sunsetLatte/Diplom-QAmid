package ru.iteco.fmhandroid.ui.common;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Helper;

import static org.hamcrest.core.IsNot.not;

import androidx.test.espresso.ViewInteraction;

public class BaseSteps {


    Elements elements = new Elements();
    Helper helper = new Helper();

    public void logOut() {
        ViewInteraction userButton = onView(withId(R.id.authorization_image_button));
        userButton.check(matches(isDisplayed()));
        userButton.perform(click());

        ViewInteraction logOutButton = onView(withText("Log out"));
        logOutButton.check(matches(isDisplayed()));
        logOutButton.perform(click());
    }

    public void checkToast(int id, boolean visible) {
        if (visible) {
            elements.toast(id).check(matches(isDisplayed()));
        } else {
            elements.toast(id).check(matches(not(isDisplayed())));
        }
    }


    public void checkWrongAuthDataToast() {

        checkToast(R.string.wrong_login_or_password, true);
    }

    public void checkEmptyAuthDataToast() {

        checkToast(R.string.empty_login_or_password, true);
    }
}