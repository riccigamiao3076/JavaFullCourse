package com.example.javafullcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button userInputButton;
    Button expressionButton;
    Button mathClButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInputButton = findViewById(R.id.inputButton);
        expressionButton = findViewById(R.id.expreButton);
        mathClButton = findViewById(R.id.mathClassButton);

        userInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.userInput, Toast.LENGTH_LONG).show();
                //get to UserInput Activity
                Intent userInputIntent = new Intent(MainActivity.this, UserInput.class);
                startActivity(userInputIntent);
            }
        });

        expressionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity.this, R.string.expressions, Toast.LENGTH_LONG).show();
                //get to UserInput Activity
                Intent expressionsIntent = new Intent(MainActivity.this, Expressions.class);
                startActivity(expressionsIntent);
            }
        });

        mathClButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Math Class", Toast.LENGTH_LONG).show();
            }
        });

    }

}