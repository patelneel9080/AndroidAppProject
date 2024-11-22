package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

private RadioGroup radioGroup;
private Button submitButton;
private RadioButton selectedRadioButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.SubmitButton);
        submitButton.setOnClickListener(view ->
        {
            int selectedRadioValue = radioGroup.getCheckedRadioButtonId();
            selectedRadioButton = findViewById(selectedRadioValue);
            if (selectedRadioButton != null)
            {
                Toast.makeText(MainActivity.this, "Selected: "  + selectedRadioButton.getText(), Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
