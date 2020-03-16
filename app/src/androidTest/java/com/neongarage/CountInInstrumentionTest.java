package com.neongarage;

import com.google.android.material.textfield.TextInputEditText;
import com.neongarage.Fragments.CountInFragment;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CountInInstrumentionTest {
    @Test
    public void parseIntTest() {
        TextInputEditText editText = new TextInputEditText(InstrumentationRegistry.getTargetContext());
        editText.setText("5");
        int actualValue = CountInFragment.parseInt(editText, 0);
        Assert.assertEquals(5, actualValue);
    }

    @Test
    public void parseInvalidTest() {
        TextInputEditText editText = new TextInputEditText(InstrumentationRegistry.getTargetContext());
        editText.setText("Aaron Sux");
        int actualValue = CountInFragment.parseInt(editText, 9);

        Assert.assertEquals("We passed in Invalid int, expecting default value",9, actualValue);
    }
}



