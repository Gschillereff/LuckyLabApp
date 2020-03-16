package com.neongarage.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.neongarage.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class MainFragment extends Fragment {
    Button countInButton;
    Button tipOutButton;


    // View initialization logic
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        countInButton = view.findViewById(R.id.count_in_button);
        countInButton.setOnClickListener(countInClickCallback);
        tipOutButton = view.findViewById(R.id.tip_out_button);
        tipOutButton.setOnClickListener(tipOutCallback);

    }

    // The callback makes the call to the activity to make the transition to the count in fragment
    private View.OnClickListener countInClickCallback = countIn -> {
        NavHostFragment.findNavController(this).navigate(MainFragmentDirections.navigateToCountIn());
    };

    // The callback makes the call to the activity to make the tip count fragment
    private View.OnClickListener tipOutCallback = countIn -> {
        NavHostFragment.findNavController(this).navigate(MainFragmentDirections.navigateToTipCount());
    };
}
