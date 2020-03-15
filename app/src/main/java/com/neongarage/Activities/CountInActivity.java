package com.neongarage.Activities;

import android.os.Bundle;

import com.neongarage.Fragments.CountInFragment;
import com.neongarage.R;

public class CountInActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        if (savedInstanceState == null) {
            CountInFragment fragment = new CountInFragment();
            // Intent extras and fragment Args are both of type android.os.Bundle.
            fragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_content, fragment)
                    .commit();
        }
    }
}



