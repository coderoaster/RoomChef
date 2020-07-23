package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import static com.example.tablayout.R.layout.activity_recipe_list;


public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;
    PageAdapter adapter;
    TabLayout tab;
    SearchView searchView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.main_viewPager);
        searchView = findViewById(R.id.serch_bar);
        Intent intent = getIntent();
        RecipeData.USERID = intent.getStringExtra("email");

        tab = findViewById(R.id.main_tablayout);
        tab.addTab(tab.newTab().setText("추천 레시피"));
        tab.addTab(tab.newTab().setText("내 냉장고"));
        tab.addTab(tab.newTab().setText("마이 페이지"));
        tab.setTabGravity(tab.GRAVITY_FILL);

        viewlist();

        searchView.setOnQueryTextListener(onQueryTextListener);
    }
    SearchView.OnQueryTextListener onQueryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            RecipeData.SEARCH =query;
            viewlist();
            return true;
        }


        @Override
        public boolean onQueryTextChange(String newText) {


            return false;
        }
    };

    public void viewlist(){
        tab.addOnTabSelectedListener( new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        viewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener(tab));
        adapter = new PageAdapter(getSupportFragmentManager(),3);
        viewPager.setAdapter(adapter);
    }
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }



}