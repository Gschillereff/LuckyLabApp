package com.neongarage.Fragments;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.neongarage.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

public class CountInFragment extends Fragment implements View.OnClickListener {

    enum CurrencyValue {

        NICKEL(.05), DIME(.1), QUARTER(.25), DOLLAR(1), FIVE(5), TEN(10), TWENTY(20);

        CurrencyValue(double value) {
            this.value = value;
        }

        double value;
        int count;

        public double getValue() {
            return value;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public double getTotal() {
            return count * getValue();
        }
    }

    private Button submitButton;
    private TextInputEditText nickelsEdit;
    private TextInputEditText dimesEdit;
    TextInputEditText quartersEdit;
    TextInputEditText onesEdit;
    TextInputEditText fivesEdit;
    TextInputEditText tensEdit;
    TextInputEditText twentiesEdit;
    TextView resultText;
    TextView dollarTotal;
    TextView coinTotal;
    TextView grandTotal;
    DecimalFormat df = new DecimalFormat("#.00");
    StringBuilder coins = new StringBuilder();
    StringBuilder dollar = new StringBuilder();
    StringBuilder grand = new StringBuilder();
    StringBuilder result = new StringBuilder();
    Context context;


    // View initialization logic
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.count_in_fragment, container, false);

        return rootView;
    }

    // Post view initialization logic
    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        context = getContext();
        submitButton = view.findViewById(R.id.submit_button);
        submitButton.setOnClickListener(this);
        nickelsEdit = view.findViewById(R.id.nickles_edit);
        dimesEdit = view.findViewById(R.id.dimes_edit);
        quartersEdit = view.findViewById(R.id.quarters_edit);
        onesEdit = view.findViewById(R.id.ones_edit);
        fivesEdit = view.findViewById(R.id.fives_edit);
        tensEdit = view.findViewById(R.id.tens_edit);
        twentiesEdit = view.findViewById(R.id.twenties_edit);
        coinTotal = view.findViewById((R.id.coin_view));
        dollarTotal = view.findViewById(R.id.dollar_view);
        grandTotal = view.findViewById(R.id.total_view);
        resultText = view.findViewById(R.id.result_view);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_button:
                handleSubmitClick(v);
                break;
        }
    }

    /**
     * This handles the submit button click
     */
    public void handleSubmitClick(View v) {

        //Get the nickels
        CurrencyValue nickels = CurrencyValue.NICKEL;
        nickels.setCount(parseInt(nickelsEdit, 0));

        //Get the dimes
        CurrencyValue dimes = CurrencyValue.DIME;
        dimes.setCount(parseInt(dimesEdit, 0));

        //Get the quarters
        CurrencyValue quarters = CurrencyValue.QUARTER;
        quarters.setCount(parseInt(quartersEdit, 0));

        //Get the ones
        CurrencyValue ones = CurrencyValue.DOLLAR;
        ones.setCount(parseInt(onesEdit, 0));

        //Get fives
        CurrencyValue fives = CurrencyValue.FIVE;
        fives.setCount(parseInt(fivesEdit, 0));

        //Get tens
        CurrencyValue tens = CurrencyValue.TEN;
        tens.setCount(parseInt(tensEdit, 0));

        //Get twenties
        CurrencyValue twenties = CurrencyValue.TWENTY;
        twenties.setCount(parseInt(twentiesEdit, 0));

        double nickleTotal = nickels.getTotal();
        double dimeTotal = dimes.getTotal();
        double quarterTotal = quarters.getTotal();
        double coinValue = nickleTotal + quarterTotal + dimeTotal;
        coins.append("Nickels: ").append(df.format(nickleTotal)).append("\nDimes: ").append(df.format(dimeTotal)).append("\nQuarters: ").append(df.format(quarterTotal));
        coinTotal.setText(coins);
        coins.setLength(0);

        //Count value of dollars
        double oneTotal = ones.getTotal();
        double fiveTotal = fives.getTotal();
        double tenTotal = tens.getTotal();
        double twentyTotal = twenties.getTotal();
        double dollarTot = oneTotal + fiveTotal + tenTotal + twentyTotal;
        dollar.append("Ones: ").append(df.format(oneTotal));
        dollar.append("\nFives: ").append(df.format(fiveTotal)).append("\nTens: ").append(df.format(tenTotal)).append("\nTwenties: ").append(df.format(twentyTotal));
        dollarTotal.setText(dollar);
        dollar.setLength(0);

        //Grand total
        double grandTot = dollarTot + coinValue;
        grand.append("Grand Total: ").append(df.format(grandTot));
        grandTotal.setText(grand);
        grand.setLength(0);

        //Difference
        if (grandTot > 150.45) {
            double difference = grandTot - 150.45;
            //Shay says this is green....
            resultText.setTextColor(resolveThemeColorStateList(context, R.attr.overColor));
            result.append("You are over ").append(df.format(Math.ceil(difference)));
            resultText.setText(result);
            result.setLength(0);
        } else if (grandTot < 149.50) {
            double difference = 149.50 - grandTot;
            //Apparently this is red
            resultText.setTextColor(resolveThemeColorStateList(context, R.attr.underColor));
            result.append("You are under ").append(df.format(Math.ceil(difference)));
            resultText.setText(result);
            result.setLength(0);
        } else {
            resultText.setTextColor(resolveThemeColorStateList(context, R.attr.perfectColor));
            result.append("Perfect amount, good job!");
            resultText.setText(result);
            result.setLength(0);
        }
    }

    public static ColorStateList resolveThemeColorStateList(Context context, int attributeName) {
        TypedValue tv = new TypedValue();
        if (context != null && (context.getTheme().resolveAttribute(attributeName, tv, true) && tv.resourceId != 0)) {
            return ContextCompat.getColorStateList(context, tv.resourceId);
        }
        return null;
    }


    public static int parseInt(TextInputEditText editText, int defaultValue) {
        int intReturn;
        String value = editText.getText().toString();
        try {
            intReturn = Integer.parseInt(value);
        } catch (NumberFormatException ex)
        {
            intReturn = defaultValue;
        }
        return intReturn;
    }
}
