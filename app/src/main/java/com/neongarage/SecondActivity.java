package com.neongarage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.neongarage.schil.helloworld.R;


public class SecondActivity extends AppCompatActivity {

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
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){

             //Get the nickels
            nickelsEdit = findViewById(R.id.nickles_count);

            //Get the dimes
            dimesEdit = findViewById(R.id.dimes_count);

            //Get the quarters
            quarterEdit = findViewById(R.id.quarters_count);

            //Get the ones
            onesEdit = findViewById(R.id.ones_count);
            int numOne = Integer.parseInt(onesEdit.getText().toString());

            //Get fives
            fivesEdit =  findViewById(R.id.fives_count);
            int numFive = Integer.parseInt(fivesEdit.getText().toString());

            //Get tens
            tensEdit =  findViewById(R.id.tens_count);
            int numTen = Integer.parseInt(tensEdit.getText().toString());

            //Get twenties
             twentiesEdit = findViewById(R.id.twentites_count);
             int numTwnety = Integer.parseInt(twentiesEdit.getText().toString());

            //Count the coins, has running total right now, need to multiply by values and get money total
            int numNick = Integer.parseInt(nickelsEdit.getText().toString());
            int numDime = Integer.parseInt(dimesEdit.getText().toString());
            int numQuart = Integer.parseInt(quarterEdit.getText().toString());
            double nickleTotal = numNick * nickelValue;
            double dimeTotal = numDime * dimeValue;
            double quarterTotal = numQuart * quarterValue;
            double coinValue = nickleTotal + quarterTotal + dimeTotal;
            coinTotal = findViewById((R.id.coinView));
            coinTotal.setText("Coin Total: " + coinValue);

            //Count value of dollars
            int fiveTotal = numFive * fivesValue;
            int tenTotal = numTen * tensValue;
            int twentyTotal = numTwnety * twentiesValue;
            int dollarTot = numOne + fiveTotal + tenTotal + twentyTotal;
            dollarTotal = findViewById(R.id.dollarView);
            dollarTotal.setText("Dollar Total: " + dollarTot);

            //Grand total
            double grandTot = dollarTot + coinValue;
            grandTotal = findViewById(R.id.totalView);
            grandTotal.setText("Grand Total: " + grandTot);

            //Difference
            resultText = findViewById(R.id.resultView);
            if(grandTot > 150.45)
            {
                double difference = grandTot - 150.45;
                resultText.setText("You are over\nDrop: " + Math.ceil(difference));
            }
            else if(grandTot < 149.45)
            {
                double difference = 149.95 - grandTot;
                resultText.setText("You are under. \nAsk Gatekeeper for " + Math.ceil(difference));
            }
            else
            resultText.setText("You are right on the Money. Good Job");


        }}
        );
}}


