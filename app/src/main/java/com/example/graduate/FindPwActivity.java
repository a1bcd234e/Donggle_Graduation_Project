package com.example.graduate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FindPwActivity extends AppCompatActivity {

    int randomNum = (int) (Math.random() * 10000);
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

        fpwSendB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        fpwNumCheckB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fpwNum.getText().toString() != "") {
                    try {
                        int userNum = Integer.parseInt(fpwNum.getText().toString());

                        if(userNum == randomNum) {
                            fpwNum.setFocusableInTouchMode(true);
                            fpwNum.setFocusable(true);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "인증번호가 올바르지 않습니다.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    } catch (NumberFormatException e) {
                        // 변환 실패 처리
                        e.printStackTrace();
                    }
                } else {
                    // stringValue가 비어있는 경우 기본값 설정 등의 처리
                    Toast.makeText(getApplicationContext(), "이메일 형식이 올바르지 않습니다.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}