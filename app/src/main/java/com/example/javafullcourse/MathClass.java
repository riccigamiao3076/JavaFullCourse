package com.example.javafullcourse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MathClass extends Activity implements View.OnClickListener {

    EditText firstValue, secondValue, aValue, bValue;
    Button max, min, ceil, floor, abs, sqrt, round, hypo;
    TextView displayAns, displayHypo;
    String getFV, getSV, getSideA, getSideB;

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
        hypo = findViewById(R.id.hypoButton);

        max.setOnClickListener(this);
        min.setOnClickListener(this);
        ceil.setOnClickListener(this);
        floor.setOnClickListener(this);
        abs.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        round.setOnClickListener(this);
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

        //Convert String to double for Max and Min button
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
                Toast.makeText(this, "Maximum number", Toast.LENGTH_SHORT).show();
                missingValueChecker(getFV, getSV);
                displayAns.setText(String.valueOf(Math.max(m1,m2)));
                break;
            case R.id.minButton:
                Toast.makeText(this, "Minimum number", Toast.LENGTH_SHORT).show();
                missingValueChecker(getFV, getSV);
                displayAns.setText(String.valueOf(Math.min(m1,m2)));
                break;
            case R.id.ceilButton:
                Toast.makeText(this, "Round UP number", Toast.LENGTH_SHORT).show();
                firstValueChecker(getFV);
                displayAns.setText(String.valueOf(Math.ceil(v1)));
                break;
            case R.id.floorButton:
                Toast.makeText(this, "Round DOWN number", Toast.LENGTH_SHORT).show();
                firstValueChecker(getFV);
                displayAns.setText(String.valueOf(Math.floor(v1)));
                break;
            case R.id.absButton:
                Toast.makeText(this, "Absolute number", Toast.LENGTH_SHORT).show();
                firstValueChecker(getFV);
                displayAns.setText(String.valueOf(Math.abs(v1)));
                break;
            case R.id.sqrtButton:
                Toast.makeText(this, "Square Root number", Toast.LENGTH_SHORT).show();
                firstValueChecker(getFV);
                displayAns.setText(String.valueOf(Math.sqrt(v1)));
                break;
            case R.id.roundButton:
                Toast.makeText(this, "Round number", Toast.LENGTH_SHORT).show();
                firstValueChecker(getFV);
                displayAns.setText(String.valueOf(Math.round(v1)));
                break;
            case R.id.hypoButton:
                Toast.makeText(this, "Hypotenuse number", Toast.LENGTH_SHORT).show();
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
            firstValue.setError("Empty");

        } else if (sValue.isEmpty()) {
            secondValue.setError("Empty");
        }
    }

    public void firstValueChecker(String fValue) {
        if (fValue.isEmpty()) {
            firstValue.setError("Empty");
        }
    }

    public void hypoValueChecker(String fValue, String sValue) {
        if (fValue.isEmpty()) {
            aValue.setError("Empty");

        } else if (sValue.isEmpty()) {
            bValue.setError("Empty");
        }
    }

}
