package com.example.graduate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChangePwActivity extends AppCompatActivity {
    EditText originPw, newPw, newPwC;
    Button pwChangeB, nextTimeB;
    TextView fPwText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpw);

        originPw = (EditText) findViewById(R.id.originPw);
        newPw = (EditText) findViewById(R.id.newPw);
        newPwC = (EditText) findViewById(R.id.newPwC);

        pwChangeB = (Button) findViewById(R.id.pwChangeB);
        nextTimeB = (Button) findViewById(R.id.nextTimeB);

        fPwText = (TextView) findViewById(R.id.fPwText);

        // originPw와 FireBase에 저장된 비밀번호와 같아야 함
        // newPw와 newPwC가 같아야 함
        // 이 둘을 모두 만족해야 pwChangeB를 활성화할 수 있도록 함.
        // nextTimeB를 누르면 이전 화면으로 넘어가거나 메인 화면으로 넘어가게

        fPwText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FindPwActivity.class);

                startActivity(intent);
            }
        });

    }
}
