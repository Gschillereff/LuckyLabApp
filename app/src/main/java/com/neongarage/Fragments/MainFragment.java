package com.neongarage.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.neongarage.Activities.CountInActivity;
import com.neongarage.Activities.TipCountInActivity;
import com.neongarage.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    Button countInButton;
    Button tipOutButton;


    // View initialization logic
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        countInButton = view.findViewById(R.id.count_in_button);
        tipOutButton = view.findViewById(R.id.tip_out_button);

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
        Intent countInIntent = new Intent(getContext(), CountInActivity.class);
        startActivity(countInIntent);
    }

    private void goToThirdActivity() {
        Intent tipCountInIntent = new Intent(getContext(), TipCountInActivity.class);
        startActivity(tipCountInIntent);
    }

}
