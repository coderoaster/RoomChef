package com.example.RoomChef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button btn_email;
    TextView tv_signUp;
    TextView tv_nonUser;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_email = findViewById(R.id.btn_email);
        tv_signUp = findViewById(R.id.tv_signUp);
        tv_nonUser = findViewById(R.id.tv_nonUser);

        btn_email.setOnClickListener(onClickListener);
        tv_signUp.setOnClickListener(onClickListener);
        tv_nonUser.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_email: // 이메일로 간편로그인 페이지 이동
                    intent = new Intent(LoginActivity.this, EmailLoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.tv_signUp: // 회원가입 페이지 이동
                    intent = new Intent(LoginActivity.this,SignUpActivity.class);
                    startActivity(intent);
                    break;
                case R.id.tv_nonUser: // 비회원으로 메인페이지 이동
                    break;
            }

        }
    };
}