package com.example.javafullcourse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MathClass extends Activity implements View.OnClickListener {

    EditText firstValue, secondValue, aValue, bValue;
    Button max, min, ceil, floor, abs, sqrt, round, rndm, hypo;
    TextView displayAns, displayHypo;
    String getFV, getSV, getSideA, getSideB;
    Random random = new Random();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathclass);

        firstValue = findViewById(R.id.eTextNumber1);
        secondValue = findViewById(R.id.eTextNumber2);
        aValue = findViewById(R.id.sideNum1);
        bValue = findViewById(R.id.sideNum2);

        max = findViewById(R.id.maxButton);
        min = findViewById(R.id.minButton);
        ceil = findViewById(R.id.ceilButton);
        floor = findViewById(R.id.floorButton);
        abs = findViewById(R.id.absButton);
        sqrt = findViewById(R.id.sqrtButton);
        round = findViewById(R.id.roundButton);
        rndm = findViewById(R.id.randomButton);
        hypo = findViewById(R.id.hypoButton);

        max.setOnClickListener(this);
        min.setOnClickListener(this);
        ceil.setOnClickListener(this);
        floor.setOnClickListener(this);
        abs.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        round.setOnClickListener(this);
        rndm.setOnClickListener(this);
        hypo.setOnClickListener(this);

        displayAns = findViewById(R.id.displayAns);
        displayHypo = findViewById(R.id.displayHypo);
    }

    @Override
    public void onClick(View v) {
        getFV = firstValue.getText().toString();
        getSV = secondValue.getText().toString();
        getSideA = aValue.getText().toString();
        getSideB = bValue.getText().toString();
        double m1, m2, v1, sA, sB;
        int i1, i2, d1, d2;

        //Convert String to double for Max, Min, and Random button
        try {
             m1 = Double.parseDouble(getFV);
             m2 = Double.parseDouble(getSV);
        } catch (NumberFormatException e) {
             m1 = 0;
             m2 = 0;
        }

        //Only convert the first value for all other buttons
        try {
            v1 = Double.parseDouble(getFV);
        } catch (NumberFormatException e) {
            v1 = 0;
        }

        //Switch case for all buttons
        switch (v.getId()) {
            case  R.id.maxButton:
                Toast.makeText( this, R.string.maxNum, Toast.LENGTH_SHORT).show();
                missingValueChecker(getFV, getSV);
                displayAns.setText(String.valueOf(Math.max(m1,m2)));
                break;
            case R.id.minButton:
                Toast.makeText( this, R.string.minNum, Toast.LENGTH_SHORT).show();
                missingValueChecker(getFV, getSV);
                displayAns.setText(String.valueOf(Math.min(m1,m2)));
                break;
            case R.id.ceilButton:
                Toast.makeText( this, R.string.rUpNum, Toast.LENGTH_SHORT).show();
                firstValueChecker(getFV);
                displayAns.setText(String.valueOf(Math.ceil(v1)));
                break;
            case R.id.floorButton:
                Toast.makeText( this, R.string.rDownNum, Toast.LENGTH_SHORT).show();
                firstValueChecker(getFV);
                displayAns.setText(String.valueOf(Math.floor(v1)));
                break;
            case R.id.absButton:
                Toast.makeText( this, R.string.absNum, Toast.LENGTH_SHORT).show();
                firstValueChecker(getFV);
                displayAns.setText(String.valueOf(Math.abs(v1)));
                break;
            case R.id.sqrtButton:
                Toast.makeText( this, R.string.sqRootNum, Toast.LENGTH_SHORT).show();
                firstValueChecker(getFV);
                displayAns.setText(String.valueOf(Math.sqrt(v1)));
                break;
            case R.id.roundButton:
                Toast.makeText( this, R.string.roundNum, Toast.LENGTH_SHORT).show();
                firstValueChecker(getFV);
                displayAns.setText(String.valueOf(Math.round(v1)));
                break;
            case R.id.randomButton:
                Toast.makeText(  this, R.string.rndmNum, Toast.LENGTH_SHORT).show();
                missingValueChecker(getFV, getSV);

                //Convert double to int for random
                try {
                    i1 = Integer.parseInt(getFV);
                    i2 = Integer.parseInt(getSV);

                } catch (NumberFormatException e) {
                    i1 = 0;
                    i2 = 0;
                }

                //Checks if the range is invalid
                if (i1 > i2) {
                    firstValue.setError(getString(R.string.rangeError));
                } else {
                    //Random generator (max - min + 1) + min
                    int range = i2 - i1 + 1;
                    displayAns.setText(String.valueOf(random.nextInt(range) + i1 ));
                }
                break;

            case R.id.hypoButton:
                Toast.makeText( this, R.string.hypoNum, Toast.LENGTH_SHORT).show();
                hypoValueChecker(getSideA, getSideB);
                //Convert String to double for Hypotenuse
                try {
                    sA = Double.parseDouble(getSideA);
                    sB = Double.parseDouble(getSideB);
                } catch (NumberFormatException e) {
                    sA = 0;
                    sB = 0;
                }
                displayHypo.setText(String.valueOf(Math.sqrt((sA*sA)+(sB*sB))));
                break;
        }
    }

    public void missingValueChecker(String fValue, String sValue) {
        if (fValue.isEmpty()) {
            firstValue.setError(getString(R.string.empty));
            firstValue.clearFocus();

        } else if (sValue.isEmpty()) {
            secondValue.setError(getString(R.string.empty));
            secondValue.clearFocus();
        }
    }

    public void firstValueChecker(String fValue) {
        if (fValue.isEmpty()) {
            firstValue.setError(getString(R.string.empty));
            firstValue.clearFocus();
        }
    }

    public void hypoValueChecker(String fValue, String sValue) {
        if (fValue.isEmpty()) {
            aValue.setError(getString(R.string.empty));
            aValue.clearFocus();

        } else if (sValue.isEmpty()) {
            bValue.setError(getString(R.string.empty));
            bValue.clearFocus();
        }
    }

}
