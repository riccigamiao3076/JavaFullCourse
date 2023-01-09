package com.example.javafullcourse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Expressions extends Activity implements AdapterView.OnItemSelectedListener {

    EditText firstValue, secondValue;
    Spinner opSpinner;
    Button answer;
    TextView displayAns;
    String theChoice;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expressions);

        firstValue = findViewById(R.id.editTextNumber1);
        secondValue = findViewById(R.id.editTextNumber2);
        opSpinner = findViewById(R.id.operatorsSpinner);
        answer = findViewById(R.id.answerButton);
        displayAns = findViewById(R.id.displayAnswer);

        //Operators Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.operators, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opSpinner.setAdapter(adapter);
        opSpinner.setOnItemSelectedListener(this);

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fValue = firstValue.getText().toString();
                String sValue = secondValue.getText().toString();

                //Passing String fValue and sValue to the methods
                valueChecker(fValue, sValue);
                calculate(fValue, sValue);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();

        //Displays Toast message based on the selected operator
        if (choice.equals("+")) {
            Toast.makeText(this, R.string.additionToast, Toast.LENGTH_SHORT).show();
        } else if (choice.equals("-")) {
            Toast.makeText( this, R.string.subtractionToast, Toast.LENGTH_SHORT).show();
        } else if (choice.equals("x")) {
            Toast.makeText( this, R.string.multiplicationToast, Toast.LENGTH_SHORT).show();
        } else if (choice.equals("/")) {
            Toast.makeText( this, R.string.divisionToast, Toast.LENGTH_SHORT).show();
        } else if (choice.equals("%")) {
            Toast.makeText( this, R.string.modulationToast, Toast.LENGTH_SHORT).show();
        }
        //Passing String choice (operator)
        store(choice);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //empty
    }

    //Stores choice (operator)
    public String store(String choice) {
        theChoice = choice;
        return theChoice;
    }

    //Checks if EditText fields is/are empty
    public void valueChecker(String fValue, String sValue) {
        if (fValue.isEmpty() || sValue.isEmpty()) {
            Toast.makeText(this, R.string.enterValue, Toast.LENGTH_SHORT).show();
        }
    }

    public void calculate(String fValue, String sValue) {
        try {
            //String to int conversion
            double fV = Double.parseDouble(fValue);
            double sV = Double.parseDouble(sValue);
            double sum, diff, prod, quo, mod;

            //Operators formula
            sum = fV + sV;
            diff = fV - sV;
            prod = fV * sV;
            quo = fV / sV;
            mod = fV % sV;

            //Display the result on TextView displayAns
            if (theChoice.equals(getString(R.string.plus))) {
                displayAns.setText(String.valueOf(sum));
            } else if (theChoice.equals(getString(R.string.sub))) {
                displayAns.setText(String.valueOf(diff));
            } else if (theChoice.equals(getString(R.string.times))) {
                displayAns.setText(String.valueOf(prod));
            } else if (theChoice.equals(getString(R.string.divided))) {
                displayAns.setText(String.valueOf(quo));
            } else if (theChoice.equals(getString(R.string.mod))) {
                displayAns.setText(String.valueOf(mod));
            }

        } catch (NumberFormatException e) {
            //Set values to 0 if String is empty
            int fV = 0;
            int sV = 0;
        }
    }

}
