package ru.iteco.fmhandroid.ui.common;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.ui.data.Helper;

public class Elements {

    public ViewInteraction toast(int id) {
        return onView(withText(id)).inRoot(new Helper.ToastMatcher());
    }

}