package com.example.RoomChef;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {

    public static Fragment3 newInstance() {
        return new Fragment3();
    }
    public Fragment3(){

    }

    //Fragment에서 실행될떄 MainActivity//onCreate와 같다고보면됨.
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.reviewlist, container, false);
    }
}//-----
