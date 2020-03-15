package com.neongarage.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neongarage.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TipCountFragment extends Fragment {

    TextView tipView;
    EditText tipEdit;
    Button AddPerson;
    TextView personView;

    // View initialization logic
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tip_count_fragment, container, false);

        return rootView;
    }

    // Post view initialization logic
    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {

        AddPerson = view.findViewById(R.id.add_person);
        //personView = )findViewById(R.id.addPersonView);
        final FrameLayout layout = view.findViewById(R.id.add_person_view);

        AddPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText myEditText = new EditText(getContext());
                myEditText.setHint("New Guy");
                myEditText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                myEditText.setPadding(20, 20, 20, 20);
                layout.addView(myEditText);
            }
        });

        tipEdit = view.findViewById(R.id.tip_edit);
        //tipView = (TextView)findViewById(R.id.tip_view);
        //tipView.setText(tipEdit.toString());
    }


}
