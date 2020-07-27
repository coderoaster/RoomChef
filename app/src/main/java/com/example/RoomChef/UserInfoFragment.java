package com.example.RoomChef;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class UserInfoFragment extends Fragment {

    Button btn_userUpdate, btn_logout;
    String nowPw, urlAddr, returnPw, phone;
    String centIP = RecipeData.CENIP;
    String email = RecipeData.USERID;
    ArrayList<UserInfo> beans;


    public static UserInfoFragment newInstance() {
        return new UserInfoFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.userinfo,container,false);

        btn_userUpdate = rootView.findViewById(R.id.btn_userUpdate);

        btn_userUpdate.setOnClickListener(onClickListener);
        return rootView;
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case R.id.btn_userUpdate:
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    final LayoutInflater inflater = getActivity().getLayoutInflater();
                    final View view1 = inflater.inflate(R.layout.pwcheck, null);
                    builder.setView(view1)
                            .setTitle("비밀번호를 입력해주세요")
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    try {
                                        EditText ed_nowPw = view1.findViewById(R.id.ed_nowPw);
                                        nowPw = ed_nowPw.getText().toString().trim();
                                        urlAddr = "http://" + centIP + ":8080/test/project_roomchefcall.jsp?";
                                        urlAddr = urlAddr + "email=" + email;
                                        Log.v("어디로가니", urlAddr);
                                        Log.v("이메일잘 저장되나", email);
                                        connectGetData();
                                        returnPw = beans.get(0).getPassword();
                                        phone = beans.get(0).getPhone();
                                        if (returnPw.equals(nowPw)) {
                                            Intent intent = new Intent(getActivity(), UserInfoUpdate.class);
                                            intent.putExtra("phone", phone);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(getActivity(), "비밀번호가 올바르지 않습니다.", Toast.LENGTH_SHORT).show();
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            })
                            .setNegativeButton("취소", null)
                            .show();
                    break;
                case R.id.btn_logout:
                    break;
            }
        }
    };
    private void connectGetData() {
        try {
            UpdateCallNetworkTask networkTask = new UpdateCallNetworkTask(getContext(), urlAddr);
            Object obj = networkTask.execute().get();  //
            beans = (ArrayList<UserInfo>) obj;
            Log.v("phone",beans.get(0).getPhone());
            Log.v("password",beans.get(0).getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}