package com.example.graduate;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    FirebaseAuth auth = FirebaseAuth.getInstance();

    EditText edtEmail, edtNum, signUpPw, signUpPwC;
    Button sendB, numCheckB, signUpCB;

    int checkNum = (int) (Math.random() * 10000);
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtNum = (EditText) findViewById(R.id.edtNum);
        signUpPw = (EditText) findViewById(R.id.signUpPw);
        signUpPwC = (EditText) findViewById(R.id.signUpPwC);

        sendB = (Button) findViewById(R.id.sendB);
        numCheckB = (Button) findViewById(R.id.numCheckB);
        signUpCB = (Button) findViewById(R.id.signUpCB);

        // 인증번호가 확인되기 전까지는 해당 editText에 입력하지 못하도록 함
        signUpPw.setFocusableInTouchMode(false);
        signUpPw.setFocusable(false);
        signUpPwC.setFocusableInTouchMode(false);
        signUpPwC.setFocusable(false);

        sendB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // edtEmail을 getText로 가져와서 이메일 보내기
                // checkNum 숫자를 보낼거임.
            }
        });

        // edtNum을 int형으로 변환 후 userNum에 저장함
        int userNum = Integer.parseInt(edtNum.getText().toString());

        if(userNum == checkNum) {
            signUpPw.setFocusableInTouchMode(true);
            signUpPw.setFocusable(true);
        }
        else {
            Toast.makeText(getApplicationContext(), "인증번호가 올바르지 않습니다.",
                    Toast.LENGTH_SHORT).show();
        }
        if(signUpPw.getText().toString() == signUpPwC.getText().toString()) {
            // 비밀번호가 둘이 같다면 '확인'버튼 누를 시, '내 정보' 화면으로 넘어가게 함
            signUpCB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(getApplicationContext(), UserInfoActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}