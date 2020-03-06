package com.example.schil.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity{
    TextView tipView;
    EditText tipEdit;
    Button AddPerson;
    TextView personView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        AddPerson = (Button)findViewById(R.id.addPerson);
       // personView = (TextView)findViewById(R.id.addPersonView);
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.addPersonView);


        AddPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText myEditText = new EditText(ThirdActivity.this);
                myEditText.setHint("New Guy");
                myEditText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                myEditText.setPadding(20,20,20,20);
               layout.addView(myEditText);

            }
        });

        tipEdit = (EditText)findViewById(R.id.tip_edit);
       // tipView = (TextView)findViewById(R.id.tip_view);
//        tipView.setText(tipEdit.toString());

    }}
