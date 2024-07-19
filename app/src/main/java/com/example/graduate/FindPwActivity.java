package com.example.graduate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class FindPwActivity extends AppCompatActivity {

    EditText fpwEmail, fpwNum;
    Button fpwSendB, fpwNumCheckB, fpwCheckB;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpw);

        fpwEmail = (EditText) findViewById(R.id.fpwEmail);
        fpwNum = (EditText) findViewById(R.id.fpwNum);

        fpwSendB = (Button) findViewById(R.id.fpwSendB);
        fpwNumCheckB = (Button) findViewById(R.id.fpwNumCheckB);
        fpwCheckB = (Button) findViewById(R.id.fpwCheckB);


    }
}