package com.example.RoomChef;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class UserInfoUpdate extends AppCompatActivity {

    ArrayList<UserInfo> beans;
    String centIP = RecipeData.CENIP;
    String email = RecipeData.USERID;
    EditText Newpw, NewpwChk, Phone;
    TextView tv_chk;
    Button btn_update, btn_cancel;
    String urlAddr, sPhone, sPw, sPwChk;
    Intent intent;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info_update);


        btn_update = findViewById(R.id.btn_update);
        btn_cancel = findViewById(R.id.btn_update_cancel);
        Phone = findViewById(R.id.edit_phone);
        Newpw = findViewById(R.id.edit_update_pw);
        NewpwChk = findViewById(R.id.edit_update_pw2);
        tv_chk = findViewById(R.id.tv_update_chk);

        intent = getIntent();
        Phone.setText(intent.getStringExtra("phone"));



        btn_update.setOnClickListener(onClickListener);
        btn_cancel.setOnClickListener(onClickListener);

        Phone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});


    }


    /// 개인정보 수정 버튼
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_update:
                    urlAddr = "";
                    sPhone = Phone.getText().toString().trim();
                    sPw = Newpw.getText().toString().trim();
                    sPwChk = NewpwChk.getText().toString().trim();
                    if (sPw.equals(sPwChk)) {
                        urlAddr = "http://" + centIP + ":8080/test/project_userInfoUpdate.jsp?";
                        urlAddr = urlAddr + "phone=" + sPhone + "&password=" + sPw + "&email=" + email;
                        Log.v("urlAddr", urlAddr);
                        connectUpdateData();
                        Toast.makeText(UserInfoUpdate.this,"완료되었습니다.",Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        tv_chk.setText("비밀번호가 일치하지 않습니다.");
                    }
                    break;
                case R.id.btn_update_cancel:
                    finish();
                    break;

            }
        }
    };
        private void connectUpdateData(){
            try{
                UpdateNetworkTask updateNetworkTask = new UpdateNetworkTask(UserInfoUpdate.this,urlAddr);
                updateNetworkTask.execute().get();
            }catch (Exception e){
                e.printStackTrace();
            }
        }




}//--

