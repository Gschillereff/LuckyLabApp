package com.neongarage.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.neongarage.R;

public class SettingFragment extends Fragment implements View.OnClickListener {

   private Button darkModeButton;
   private Switch darkModeSwitch;
   Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.settings_fragment, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        context = getContext();
        darkModeButton = view.findViewById(R.id.dark_mode_button);
        darkModeButton.setOnClickListener(this);
        darkModeSwitch = view.findViewById(R.id.dark_mode_switch);
        darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    AppCompatDelegate.setDefaultNightMode
                            (AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode
                            (AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.dark_mode_button:
                runSettings(v);
                break;
        }
    }



    public void runSettings(View v) {
       int nightMode = AppCompatDelegate.getDefaultNightMode();

       if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
           AppCompatDelegate.setDefaultNightMode
                   (AppCompatDelegate.MODE_NIGHT_NO);
       }else{
           AppCompatDelegate.setDefaultNightMode
                   (AppCompatDelegate.MODE_NIGHT_YES);
       }

    }

}
