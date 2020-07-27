package com.example.RoomChef;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ReviewListFragment extends Fragment {
    ListView listView;
    TextView tv_title;
    String centIP = RecipeData.CENIP;
    String urlAddr;
    String email = RecipeData.USERID;
    Context mContext;
    ArrayList<Review> data;
    reviewAdapter adapter;
    String imgurlAddr ="http://192.168.0.148:8080/test2/imgs/";
    ImageView imageView;
    String imagename;
    String seq;


    public static ReviewListFragment newInstance() {
        return new ReviewListFragment();
    }
    public ReviewListFragment(){

    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext =context;
        Log.v("mContext","onAttach"+mContext.toString());

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("mContext","onCreate"+mContext.toString());


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.v("mContext","onViewCreated"+mContext.toString());

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.v("mContext","onActivityCreated"+mContext.toString());

    }

    @Override
    public void onResume() {
        super.onResume();
        connectGetData(); // 입력 후 리스트 새로 불러옴
        Log.v("mContext","onResume"+ mContext.toString());

    }

    //Fragment에서 실행될떄 MainActivity//onCreate와 같다고보면됨.
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.reviewlist, container, false);
        View v = inflater.inflate(R.layout.reviewlistview,container,false);
            listView = root.findViewById(R.id.lv_review);
            imageView = listView.findViewById(R.id.iv_review);

        connectGetData();
        listView.setOnItemClickListener(onClickListener);
//        NetworkTask networkTask = new NetworkTask(mContext, imgurlAddr, imageView);
//        // 100 바이트씩 읽어와라 (NetworkTask 의 len 변수를 말한다.)
//        networkTask.execute(100);

        return root;
    }

    final ListView.OnItemClickListener onClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            seq = Integer.toString(data.get(i).getSeq());
            Log.v("레시피번호",seq);
            Intent intent = new Intent(getActivity(), ReviewDetail.class);
            intent.putExtra("seq",seq);

            startActivity(intent);
        }
    };

    protected void connectGetData() { // 리스트 불러오기
        try {
            urlAddr = "http://" + centIP + ":8080/test/select_review.jsp?";
            urlAddr = urlAddr + "email=" + email;

            Log.v("urlAddr",urlAddr);
            reviewNetworkTask networkTask = new reviewNetworkTask(mContext, urlAddr);

            // execute() java 파일안의 메소드 한번에 동작시키기, 메소드를 사용하면 HttpURLConnection 이 제대로 작동하지않는다.
            Object obj = networkTask.execute().get();
            data = (ArrayList<Review>) obj;

            adapter = new reviewAdapter(mContext, R.layout.reviewlistview, data);
            listView.setAdapter(adapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}//-----
