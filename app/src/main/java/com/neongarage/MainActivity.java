package com.neongarage;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button countInButton = findViewById(R.id.count_in_button);
        Button tipOutButton = findViewById(R.id.tip_out_button);

        countInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
            }
        });
        tipOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                goToThirdActivity();
            }
        });
    }

    private void goToSecondActivity() {
        Intent intent = new Intent(this, CountInActivity.class);
        startActivity(intent);
    }

    private void goToThirdActivity() {
        Intent intent1 = new Intent(this, TipCountInActivity.class);
        startActivity(intent1);
    }
}
