package com.example.javafullcourse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserInput extends Activity {

    EditText username;
    Button confirmInput;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinput);

        username = findViewById(R.id.userName);
        confirmInput = findViewById(R.id.confirmButton);

        confirmInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameCheck();
            }
        });
    }

    //Checks if username is empty, less than 3 characters, or contains integers
    private void nameCheck() {
        String name = username.getText().toString();

        if(name.isEmpty() || name.length() <= 2) {
            Toast.makeText(UserInput.this, "Please enter more than 2 characters.", Toast.LENGTH_LONG).show();
        } else if (name.matches(".*[0-9].*")) {
            Toast.makeText(UserInput.this, "Please enter letters only.", Toast.LENGTH_LONG).show();
        }
        //Print a string and the username
        else Toast.makeText(UserInput.this, "Hello there " + name, Toast.LENGTH_LONG).show();
    }
}
