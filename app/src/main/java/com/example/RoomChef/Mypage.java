
package com.example.RoomChef;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class Mypage extends Fragment {

    public static Mypage newInstance() {
        return new Mypage();
    }

    String strColor = "#FFE33939";
    String nowPw, urlAddr, returnPw, phone;
    String centIP = RecipeData.CENIP;
    String email = RecipeData.USERID;
    ArrayList<UserInfo> beans;

    Button btn_1, btn_2, btn_3, btn_userUpdate;

    public Mypage(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_mypage,container,false);

        btn_1 = rootView.findViewById(R.id.btn_1);
        btn_2 = rootView.findViewById(R.id.btn_2);
        btn_3 = rootView.findViewById(R.id.btn_3);
//        btn_userUpdate = rootView.findViewById(R.id.btn_userUpdate);

        ((MainActivity) getActivity()).replaceFragment(likelist.newInstance());
        btn_1.setTextColor(Color.parseColor(strColor));

        btn_1.setOnClickListener(onClickListener);
        btn_2.setOnClickListener(onClickListener);
        btn_3.setOnClickListener(onClickListener);
//        btn_userUpdate.setOnClickListener(onClickListener);

        return rootView;

    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            switch (view.getId()) {
                case R.id.btn_1:
                    btn_1.setTextColor(Color.parseColor(strColor));
                    btn_2.setTextColor(Color.parseColor("#000000"));
                    btn_3.setTextColor(Color.parseColor("#000000"));
                    // getActivity()로 MainActivity의 replaceFragment를 불러옵니다.

                    ((MainActivity) getActivity()).replaceFragment(likelist.newInstance());    // 새로 불러올 Fragment의 Instance를 Main으로 전달
                    break;
                case R.id.btn_2:
                    btn_2.setTextColor(Color.parseColor(strColor));
                    btn_1.setTextColor(Color.parseColor("#000000"));
                    btn_3.setTextColor(Color.parseColor("#000000"));
                    // getActivity()로 MainActivity의 replaceFragment를 불러옵니다.
                    ((MainActivity) getActivity()).replaceFragment(ReviewListFragment.newInstance());    // 새로 불러올 Fragment의 Instance를 Main으로 전달
                    break;
                case R.id.btn_3:
                    btn_3.setTextColor(Color.parseColor(strColor));
                    btn_1.setTextColor(Color.parseColor("#000000"));
                    btn_2.setTextColor(Color.parseColor("#000000"));
                    // getActivity()로 MainActivity의 replaceFragment를 불러옵니다.
                    ((MainActivity) getActivity()).replaceFragment(UserInfoFragment.newInstance());    // 새로 불러올 Fragment의 Instance를 Main으로 전달
                    break;
//                case R.id.btn_userUpdate:
//                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                    final LayoutInflater inflater = getActivity().getLayoutInflater();
//                    final View view1 = inflater.inflate(R.layout.pwcheck, null);
//                    builder.setView(view1)
//                            .setTitle("비밀번호를 입력해주세요")
//                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int id) {
//                                    try {
//                                        EditText ed_nowPw = view1.findViewById(R.id.ed_nowPw);
//                                        nowPw = ed_nowPw.getText().toString().trim();
//                                        urlAddr = "http://" + centIP + ":8080/test/project_roomchefcall.jsp?";
//                                        urlAddr = urlAddr + "email=" + email;
//                                        Log.v("어디로가니",urlAddr);
//                                        Log.v("이메일잘 저장되나",email);
//                                        connectGetData();
//                                        returnPw = beans.get(0).getPassword();
//                                        phone = beans.get(0).getPhone();
//                                        if(returnPw.equals(nowPw)){
//                                            Intent intent = new Intent(getActivity(), UserInfoUpdate.class);
//                                            intent.putExtra("phone", phone);
//                                            startActivity(intent);
//                                        }else{
//                                            Toast.makeText(getActivity(),"비밀번호가 올바르지 않습니다.", Toast.LENGTH_SHORT).show();
//                                        }
//
//                                    } catch (Exception e) {
//                                        e.printStackTrace();
//                                    }
//                                }
//                            })
//                            .setNegativeButton("취소", null)
//                            .show();
//                    break;

            }
        }

    };
//    private void connectGetData() {
//        try {
//            UpdateCallNetworkTask networkTask = new UpdateCallNetworkTask(getContext(), urlAddr);
//            Object obj = networkTask.execute().get();  //
//            beans = (ArrayList<UserInfo>) obj;
//            Log.v("phone",beans.get(0).getPhone());
//            Log.v("password",beans.get(0).getPassword());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}





