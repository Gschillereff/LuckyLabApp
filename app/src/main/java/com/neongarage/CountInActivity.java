package com.neongarage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.neongarage.schil.helloworld.R;


public class CountInActivity extends AppCompatActivity {

    Button submitButton;
    EditText nickelsEdit;
    EditText dimesEdit;
    EditText quarterEdit;
    EditText onesEdit;
    EditText fivesEdit;
    EditText tensEdit;
    EditText twentiesEdit;
    TextView nickelsText;
    TextView dimesText;
    TextView quarterText;
    TextView onesText;
    TextView fivesText;
    TextView tensText;
    TextView twentiesText;
    TextView resultText;
    TextView dollarTotal;
    TextView coinTotal;
    TextView grandTotal;
    String numNic = "Number of nickels: ";
    double nickelValue = .05;
    double dimeValue = .10;
    double quarterValue = .25;
    int fivesValue = 5;
    int tensValue = 10;
    int twentiesValue = 20;


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
        int numOne = parseInt(onesEdit, 0);

        //Get fives
        fivesEdit = findViewById(R.id.fives_count);
        int numFive = parseInt(fivesEdit, 0);

        //Get tens
        tensEdit = findViewById(R.id.tens_count);
        int numTen = parseInt(tensEdit, 0);

        //Get twenties
        twentiesEdit = findViewById(R.id.twentites_count);
        int numTwenty = parseInt(twentiesEdit, 0);

        //Count the coins, has running total right now, need to multiply by values and get money total
        int numNick = parseInt(nickelsEdit, 0);
        int numDime = parseInt(dimesEdit, 0);
        int numQuart = parseInt(quarterEdit, 0);
        double nickleTotal = numNick * nickelValue;
        double dimeTotal = numDime * dimeValue;
        double quarterTotal = numQuart * quarterValue;
        double coinValue = nickleTotal + quarterTotal + dimeTotal;
        coinTotal = findViewById((R.id.coin_view));
        coinTotal.setText("Coin Total: " + coinValue);

        //Count value of dollars
        int fiveTotal = numFive * fivesValue;
        int tenTotal = numTen * tensValue;
        int twentyTotal = numTwenty * twentiesValue;
        int dollarTot = numOne + fiveTotal + tenTotal + twentyTotal;
        dollarTotal = findViewById(R.id.dollarView);
        dollarTotal.setText("Dollar Total: " + dollarTot);

        //Grand total
        double grandTot = dollarTot + coinValue;
        grandTotal = findViewById(R.id.totalView);
        grandTotal.setText("Grand Total: " + grandTot);

        //Difference
        resultText = findViewById(R.id.resultView);
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


