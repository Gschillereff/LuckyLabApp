package com.neongarage.Activities;

import android.os.Bundle;

import com.neongarage.Fragments.MainFragment;
import com.neongarage.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_host);

        if (savedInstanceState == null) {
            MainFragment fragment = new MainFragment();
            // Intent extras and fragment Args are both of type android.os.Bundle.
            fragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_content, fragment)
                    .commit();
        }
    }
}
