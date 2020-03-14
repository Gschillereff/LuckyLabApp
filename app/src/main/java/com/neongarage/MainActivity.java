package com.neongarage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.neongarage.schil.helloworld.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.count_in_button);
        Button button1 = findViewById(R.id.tip_out_button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToSecondActivity();
            }
        });

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v1){
                goToThirdActivity();
            }
        });
    }
    private void goToSecondActivity(){
        Intent intent = new Intent(this, CountInActivity.class);
        startActivity(intent);
    }

    private void goToThirdActivity(){
        Intent intent1 = new Intent(this, TipCountInActivity.class);
        startActivity(intent1);
    }
}
