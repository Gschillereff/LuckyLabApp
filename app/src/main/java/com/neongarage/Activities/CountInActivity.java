package com.neongarage.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.neongarage.R;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class CountInActivity extends BaseActivity {

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

    Button submitButton;
    TextInputEditText nickelsEdit;
    TextInputEditText dimesEdit;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_in_activity);

        submitButton = findViewById(R.id.submit_button);
    }

    /**
     * This handles the submit button click
     */
    public void handleSubmitClick(View v) {

        //Get the nickels
        nickelsEdit = findViewById(R.id.nickles_edit);
        CurrencyValue nickels = CurrencyValue.NICKEL;
        nickels.setCount(parseInt(nickelsEdit, 0));

        //Get the dimes
        dimesEdit = findViewById(R.id.dimes_edit);
        CurrencyValue dimes = CurrencyValue.DIME;
        dimes.setCount(parseInt(dimesEdit, 0));

        //Get the quarters
        quartersEdit = findViewById(R.id.quarters_edit);
        CurrencyValue quarters = CurrencyValue.QUARTER;
        quarters.setCount(parseInt(quartersEdit, 0));

        //Get the ones
        onesEdit = findViewById(R.id.ones_edit);
        CurrencyValue ones = CurrencyValue.DOLLAR;
        ones.setCount(parseInt(onesEdit, 0));

        //Get fives
        fivesEdit = findViewById(R.id.fives_edit);
        CurrencyValue fives = CurrencyValue.FIVE;
        fives.setCount(parseInt(fivesEdit, 0));

        //Get tens
        tensEdit = findViewById(R.id.tens_edit);
        CurrencyValue tens = CurrencyValue.TEN;
        tens.setCount(parseInt(tensEdit, 0));

        //Get twenties
        twentiesEdit = findViewById(R.id.twenties_edit);
        CurrencyValue twenties = CurrencyValue.TWENTY;
        twenties.setCount(parseInt(twentiesEdit, 0));

        double nickleTotal = nickels.getTotal();
        double dimeTotal = dimes.getTotal();
        double quarterTotal = quarters.getTotal();
        double coinValue = nickleTotal + quarterTotal + dimeTotal;
        coinTotal = findViewById((R.id.coin_view));
        coinTotal.setText("Nickels: " + df.format(nickleTotal) + "\nDimes: " + df.format(dimeTotal) +"\nQuarters: " + df.format(quarterTotal));

        //Count value of dollars
        double oneTotal = ones.getTotal();
        double fiveTotal = fives.getTotal();
        double tenTotal = tens.getTotal();
        double twentyTotal = twenties.getTotal();
        double dollarTot = oneTotal + fiveTotal + tenTotal + twentyTotal;
        dollarTotal = findViewById(R.id.dollar_view);
        dollarTotal.setText("Ones: " + df.format(oneTotal) +"\nFives: " + df.format(fiveTotal) + "\nTens: " + df.format(tenTotal) + "\nTwenties: " + df.format(twentyTotal));

        //Grand total
        double grandTot = dollarTot + coinValue;
        grandTotal = findViewById(R.id.total_view);
        grandTotal.setText("Grand Total: " + df.format(grandTot));

        //Difference
        resultText = findViewById(R.id.result_view);
        if (grandTot > 150.45) {
            double difference = grandTot - 150.45;
            resultText.setText("You are over\nDrop: " + df.format(Math.ceil(difference)));
        } else if (grandTot < 149.95) {
            double difference = 149.95 - grandTot;
            resultText.setText("You are under. \nAsk Gatekeeper for " + df.format(Math.ceil(difference)));
        } else
            resultText.setText("You are right on the Money. Good Job");
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


