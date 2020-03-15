package com.neongarage;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import android.widget.EditText;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CountInInstrumentionTest {
    @Test
    public void parseIntTest() {
        EditText editText = new EditText(InstrumentationRegistry.getTargetContext());
        editText.setText("5");
        int actualValue = CountInActivity.parseInt(editText, 0);
        Assert.assertEquals(5, actualValue);
    }

    @Test
    public void parseInvalidTest() {
        EditText editText = new EditText(InstrumentationRegistry.getTargetContext());
        editText.setText("Aaron Sux");
        int actualValue = CountInActivity.parseInt(editText, 9);

        Assert.assertEquals("We passed in Invalid int, expecting default value",9, actualValue);
    }
}



