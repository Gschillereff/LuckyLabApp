package com.neongarage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TipCountInActivity extends Activity {
    TextView tipView;
    EditText tipEdit;
    Button AddPerson;
    TextView personView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_count_activity);
        AddPerson = findViewById(R.id.add_person);
        //personView = )findViewById(R.id.addPersonView);
        final FrameLayout layout = findViewById(R.id.add_person_view);

        AddPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText myEditText = new EditText(TipCountInActivity.this);
                myEditText.setHint("New Guy");
                myEditText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                myEditText.setPadding(20, 20, 20, 20);
                layout.addView(myEditText);
            }
        });

        tipEdit = findViewById(R.id.tip_edit);
        //tipView = (TextView)findViewById(R.id.tip_view);
        //tipView.setText(tipEdit.toString());

    }
}
