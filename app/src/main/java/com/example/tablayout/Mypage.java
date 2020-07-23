
package com.example.tablayout;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Mypage extends Fragment {

    public static Mypage newInstance() {
        return new Mypage();
    }

    String strColor = "#FFE33939";

    Button btn_1, btn_2, btn_3;

    public Mypage(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_mypage,container,false);

        btn_1 = rootView.findViewById(R.id.btn_1);
        btn_2 = rootView.findViewById(R.id.btn_2);
        btn_3 = rootView.findViewById(R.id.btn_3);

        ((MainActivity) getActivity()).replaceFragment(ingredientFragment.newInstance());
        btn_1.setTextColor(Color.parseColor(strColor));

        btn_1.setOnClickListener(onClickListener);
        btn_2.setOnClickListener(onClickListener);
        btn_3.setOnClickListener(onClickListener);

        return rootView;

    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_1:
                    btn_1.setTextColor(Color.parseColor(strColor));
                    btn_2.setTextColor(Color.parseColor("#000000"));
                    btn_3.setTextColor(Color.parseColor("#000000"));
                    // getActivity()로 MainActivity의 replaceFragment를 불러옵니다.
                    ((MainActivity) getActivity()).replaceFragment(ingredientFragment.newInstance());    // 새로 불러올 Fragment의 Instance를 Main으로 전달
                    break;
                case R.id.btn_2:
                    btn_2.setTextColor(Color.parseColor(strColor));
                    btn_1.setTextColor(Color.parseColor("#000000"));
                    btn_3.setTextColor(Color.parseColor("#000000"));
                    // getActivity()로 MainActivity의 replaceFragment를 불러옵니다.
                    ((MainActivity) getActivity()).replaceFragment(Fragment2.newInstance());    // 새로 불러올 Fragment의 Instance를 Main으로 전달
                    break;
                case R.id.btn_3:
                    btn_3.setTextColor(Color.parseColor(strColor));
                    btn_1.setTextColor(Color.parseColor("#000000"));
                    btn_2.setTextColor(Color.parseColor("#000000"));
                    // getActivity()로 MainActivity의 replaceFragment를 불러옵니다.
                    ((MainActivity) getActivity()).replaceFragment(Fragment3.newInstance());    // 새로 불러올 Fragment의 Instance를 Main으로 전달
                    break;
            }
        }

    };

}





