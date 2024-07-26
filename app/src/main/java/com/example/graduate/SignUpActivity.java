package com.example.graduate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDBRef;

    EditText signEmail, signNum, signUpPw, signUpPwC;
    Button signSendB, signNumCheckB, signUpCB;

    int checkNum = (int) (Math.random() * 10000);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();
        mDBRef = FirebaseDatabase.getInstance().getReference("Donggle");

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
                String strEmail = signEmail.getText().toString();
                String strpwd = signUpPw.getText().toString();
                String strpwdc = signUpPwC.getText().toString();
                boolean check = strpwd.equals(strpwdc);
                if (check){
                    //이메일 인증번호 받기
                    ActionCodeSettings actionCodeSettings =
                            ActionCodeSettings.newBuilder()
                                    // URL you want to redirect back to. The domain (www.example.com) for this
                                    // URL must be whitelisted in the Firebase Console.
                                    .setUrl("https://www.example.com/finishSignUp?cartId=1234")
                                    // This must be true
                                    .setHandleCodeInApp(true)
                                    .setIOSBundleId("com.example.ios")
                                    .setAndroidPackageName(
                                            "com.example.android",
                                            true, /* installIfNotAvailable */
                                            "12"    /* minimumVersion */)
                                    .build();
                }
            }
        });

    }
}