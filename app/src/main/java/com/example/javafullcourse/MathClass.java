package com.example.javafullcourse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MathClass extends Activity implements View.OnClickListener {

    EditText firstValue, secondValue;
    Button max, min, ceil, floor, abs, sqrt, round, hypo;
    String getFV, getSV;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathclass);

        firstValue = findViewById(R.id.eTextNumber1);
        secondValue = findViewById(R.id.eTextNumber2);

        max = findViewById(R.id.maxButton);
        min = findViewById(R.id.minButton);
        ceil = findViewById(R.id.ceilButton);
        floor = findViewById(R.id.floorButton);
        abs = findViewById(R.id.absButton);
        sqrt = findViewById(R.id.sqrtButton);
        round = findViewById(R.id.roundButton);
        hypo = findViewById(R.id.roundButton);

        max.setOnClickListener(this);
        min.setOnClickListener(this);
        ceil.setOnClickListener(this);
        floor.setOnClickListener(this);
        abs.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        round.setOnClickListener(this);
        hypo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        getFV = firstValue.getText().toString();
        getSV = secondValue.getText().toString();

        //Switch case for all buttons
        switch (v.getId()) {
            case  R.id.maxButton:
                Toast.makeText(this, "Maximum number", Toast.LENGTH_SHORT).show();
                break;
            case R.id.minButton:
                Toast.makeText(this, "Minimum number", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ceilButton:
                Toast.makeText(this, "Round UP number", Toast.LENGTH_SHORT).show();
                break;
            case R.id.floorButton:
                Toast.makeText(this, "Round DOWN number", Toast.LENGTH_SHORT).show();
                break;
            case R.id.absButton:
                Toast.makeText(this, "Absolute number", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sqrtButton:
                Toast.makeText(this, "Square Root number", Toast.LENGTH_SHORT).show();
                break;
            case R.id.roundButton:
                Toast.makeText(this, "Round number", Toast.LENGTH_SHORT).show();
                break;
            case R.id.hypoButton:
                Toast.makeText(this, "Hypotenuse number", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
