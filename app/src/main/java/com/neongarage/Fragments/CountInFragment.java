package com.neongarage.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.neongarage.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
        coins.append("Nickels: ");
        coins.append(df.format(nickleTotal));
        coins.append("\nDimes: ");
        coins.append(df.format(dimeTotal));
        coins.append("\nQuarters: ");
        coins.append(df.format(quarterTotal));
        coinTotal.setText(coins);
        coins.setLength(0);

        //Count value of dollars
        double oneTotal = ones.getTotal();
        double fiveTotal = fives.getTotal();
        double tenTotal = tens.getTotal();
        double twentyTotal = twenties.getTotal();
        double dollarTot = oneTotal + fiveTotal + tenTotal + twentyTotal;
        dollar.append("Ones: ");
        dollar.append(df.format(oneTotal));
        dollar.append("\nFives: ");
        dollar.append(df.format(fiveTotal));
        dollar.append("\nTens: ");
        dollar.append(df.format(tenTotal));
        dollar.append("\nTwenties: ");
        dollar.append(df.format(twentyTotal));
        dollarTotal.setText(dollar);
        dollar.setLength(0);

        //Grand total
        double grandTot = dollarTot + coinValue;
        grand.append("Grand Total: ");
        grand.append(df.format(grandTot));
        grandTotal.setText(grand);
        grand.setLength(0);

        //Difference
        if (grandTot > 150.45) {
            double difference = grandTot - 150.45;
            //Shay says this is green....
            resultText.setTextColor(Color.rgb(0, 128, 0));
            result.append("You are over ");
            result.append(df.format(Math.ceil(difference)));
            resultText.setText(result);
            result.setLength(0);
        } else if (grandTot < 149.95) {
            double difference = 149.95 - grandTot;
            //Apparently this is red
            resultText.setTextColor(Color.rgb(128, 0, 0));
            result.append("You are under ");
            result.append(df.format(Math.ceil(difference)));
            resultText.setText(result);
            result.setLength(0);
        } else {
            resultText.setTextColor(Color.rgb(0, 0, 128));
            result.append("Perfect amount, good job!");
            resultText.setText(result);
            result.setLength(0);
        }
    }

    public static int parseInt(TextInputEditText editText, int defaultValue) {
        int intReturn;
        String value = editText.getText().toString();
        try {
            intReturn = Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            intReturn = defaultValue;
        }
        return intReturn;
    }
}
