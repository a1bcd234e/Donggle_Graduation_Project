package com.example.graduate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    FirebaseAuth auth = FirebaseAuth.getInstance();

    EditText signEmail, signNum, signUpPw, signUpPwC;
    Button signSendB, signNumCheckB, signUpCB;

    int checkNum = (int) (Math.random() * 10000);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signEmail = (EditText) findViewById(R.id.signEmail);
        signNum = (EditText) findViewById(R.id.signNum);
        signUpPw = (EditText) findViewById(R.id.signUpPw);
        signUpPwC = (EditText) findViewById(R.id.signUpPwC);

        signSendB = (Button) findViewById(R.id.signSendB);
        signNumCheckB = (Button) findViewById(R.id.signNumCheckB);
        signUpCB = (Button) findViewById(R.id.signUpCB);

        // 인증번호가 확인되기 전까지는 해당 editText에 입력하지 못하도록 함
        signUpPw.setFocusableInTouchMode(false);
        signUpPw.setFocusable(false);
        signUpPwC.setFocusableInTouchMode(false);
        signUpPwC.setFocusable(false);

        signSendB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // edtEmail을 getText로 가져와서 이메일 보내기
                // checkNum 숫자를 보낼거임.
                Intent emailSend = new Intent(Intent.ACTION_SEND);
                emailSend.setType("plain/text");

                String emailAdd = signEmail.getText().toString();
                String sendText = String.format("Donggle 동글 이메일 인증번호 : %d", checkNum);

                emailSend.putExtra(Intent.EXTRA_EMAIL, emailAdd);
                emailSend.putExtra(Intent.EXTRA_SUBJECT, "Donggle 동글 이메일 인증번호");
                emailSend.putExtra(Intent.EXTRA_TEXT, sendText);

                startActivity(emailSend);
            }
        });

        int userNum;

        // edtNum을 int형으로 변환 후 userNum에 저장함
        if (signNum.getText().toString() != "") {
            try {
                userNum = Integer.parseInt(signNum.getText().toString());

                if(userNum == checkNum) {
                    signUpPw.setFocusableInTouchMode(true);
                    signUpPw.setFocusable(true);
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