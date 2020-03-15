package com.neongarage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    EditText nickelsEdit;
    EditText dimesEdit;
    EditText quarterEdit;
    EditText onesEdit;
    EditText fivesEdit;
    EditText tensEdit;
    EditText twentiesEdit;
    TextView resultText;
    TextView dollarTotal;
    TextView coinTotal;
    TextView grandTotal;

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
        nickelsEdit = findViewById(R.id.nickles_count);

        //Get the dimes
        dimesEdit = findViewById(R.id.dimes_count);

        //Get the quarters
        quarterEdit = findViewById(R.id.quarters_count);

        //Get the ones
        onesEdit = findViewById(R.id.ones_count);
        CurrencyValue ones = CurrencyValue.DOLLAR;
        ones.setCount(parseInt(onesEdit, 0));

        //Get fives
        fivesEdit = findViewById(R.id.fives_count);
        CurrencyValue fives = CurrencyValue.FIVE;
        fives.setCount(parseInt(fivesEdit, 0));

        //Get tens
        tensEdit = findViewById(R.id.tens_count);
        CurrencyValue tens = CurrencyValue.TEN;
        tens.setCount(parseInt(tensEdit, 0));

        //Get twenties
        twentiesEdit = findViewById(R.id.twentites_count);
        CurrencyValue twenties = CurrencyValue.TWENTY;
        twenties.setCount(parseInt(twentiesEdit, 0));

        //Count the coins, has running total right now, need to multiply by values and get money total
        CurrencyValue nickels = CurrencyValue.NICKEL;
        nickels.setCount(parseInt(nickelsEdit, 0));

        CurrencyValue dimes = CurrencyValue.DIME;
        dimes.setCount(parseInt(dimesEdit, 0));

        CurrencyValue quarters = CurrencyValue.QUARTER;
        quarters.setCount(parseInt(quarterEdit, 0));

        double nickleTotal = nickels.getTotal();
        double dimeTotal = dimes.getTotal();
        double quarterTotal = quarters.getTotal();
        double coinValue = nickleTotal + quarterTotal + dimeTotal;
        coinTotal = findViewById((R.id.coin_view));
        coinTotal.setText("Coin Total: " + coinValue);

        //Count value of dollars
        double onesTotal = ones.getTotal();
        double fiveTotal = fives.getTotal();
        double tenTotal = tens.getTotal();
        double twentyTotal = twenties.getTotal();
        double dollarTot = onesTotal + fiveTotal + tenTotal + twentyTotal;
        dollarTotal = findViewById(R.id.dollar_view);
        dollarTotal.setText("Dollar Total: " + dollarTot);

        //Grand total
        double grandTot = dollarTot + coinValue;
        grandTotal = findViewById(R.id.total_view);
        grandTotal.setText("Grand Total: " + grandTot);

        //Difference
        resultText = findViewById(R.id.result_view);
        if (grandTot > 150.45) {
            double difference = grandTot - 150.45;
            resultText.setText("You are over\nDrop: " + Math.ceil(difference));
        } else if (grandTot < 149.45) {
            double difference = 149.95 - grandTot;
            resultText.setText("You are under. \nAsk Gatekeeper for " + Math.ceil(difference));
        } else
            resultText.setText("You are right on the Money. Good Job");
    }

    public static int parseInt(EditText editText, int defaultValue) {
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


