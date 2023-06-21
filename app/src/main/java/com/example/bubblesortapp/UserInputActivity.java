package com.example.bubblesortapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInputActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.bubblesortapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubblesort);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, BubbleSortDisplayActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String message = editText.getText().toString();

        // User Input Validation
        if(UserInputValidation.CheckUserInput(message)){
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        } else{
            editText.setError("Incorrect input/Numbers not in range. Please enter again!");
        }
    }


}