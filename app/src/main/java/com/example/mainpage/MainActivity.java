package com.example.mainpage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private View drawerView;
    ImageView btn_filter, burger;
    private boolean login = false;
    BottomNavigationView bottomNavigationView;
    private Button mSearchButton;
    private RadioGroup mRadioGroup1;
    private RadioGroup mRadioGroup2;
    private RadioGroup mRadioGroup3;
    private CheckBox p_btn;
    private int mSelectGender = 0;
    private int mSelectLocal = 0;
    private boolean isLogin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setGenderRadioGroup();
        setLocalInput();
        setMultipleRadioButton();

        mSearchButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), FilterActivity.class);
            intent.putExtra("gender", mSelectGender);
            intent.putExtra("local", mSelectLocal);
            startActivity(intent);
            finish();
            mDrawer.closeDrawer(GravityCompat.END);
        });

        btn_filter.setOnClickListener(v -> mDrawer.openDrawer(drawerView));
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment_home()).commitAllowingStateLoss();

        btn_filter.setOnClickListener(v -> mDrawer.openDrawer(drawerView));
        burger.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Burger_Activity.class);
            startActivity(intent);
        });

        bottomNavigationView = findViewById(R.id.bottom);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment_home()).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.tab_home:
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment_home()).commitAllowingStateLoss();
                            break;

                        case R.id.tab_search:
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment_search()).commitAllowingStateLoss();
                            break;

                        case R.id.tab_info:
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment_info()).commitAllowingStateLoss();
                            break;

                        case R.id.tab_login:
                            if(login){
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment_mypage()).commitAllowingStateLoss();
                            }else{
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment_login()).commitAllowingStateLoss();
                            }
                            break;
                    }
                    return true;
                }
        );
    }

    private void initView() {
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawerView2);
        mDrawer.setDrawerListener(listener);
        burger = findViewById(R.id.icon_burger);
        btn_filter = findViewById(R.id.icon_filter1);
        mRadioGroup1 = findViewById(R.id.group1);
        mRadioGroup2 = findViewById(R.id.group2);
        mRadioGroup3 = findViewById(R.id.group3);
        mSearchButton = findViewById(R.id.btn_search);
        p_btn = (CheckBox) findViewById(R.id.pbtn_5);
    }

    private void setGenderRadioGroup() {
        mRadioGroup1.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbtn_1) {
                mSelectGender = 1;
            } else if (checkedId == R.id.rbtn_2) {
                mSelectGender = 2;
            } else if (checkedId == R.id.rbtn_3) {
                mSelectGender = 3;
            }
        });
    }

    private void setLocalInput(){
        p_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mSelectLocal = 1;
            }
        });
    }

    private void setMultipleRadioButton() {
        mRadioGroup2.clearCheck();
        mRadioGroup2.setOnCheckedChangeListener(listener2);
        mRadioGroup3.clearCheck();
        mRadioGroup3.setOnCheckedChangeListener(listener3);
    }

    private RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                mRadioGroup3.setOnCheckedChangeListener(null);
                mRadioGroup3.clearCheck();
                mRadioGroup3.setOnCheckedChangeListener(listener3);
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener listener3 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                mRadioGroup2.setOnCheckedChangeListener(null);
                mRadioGroup2.clearCheck();
                mRadioGroup2.setOnCheckedChangeListener(listener2);
            }
        }
    };

    void replaceFragment(Boolean loginCheck){
        InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        if(loginCheck){
            login = true;
            bottomNavigationView.setSelectedItemId(R.id.tab_home);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment_home()).commitAllowingStateLoss();
        }
    }

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull @NotNull View drawerView, float slideOffset) { }
        @Override
        public void onDrawerOpened(@NonNull @NotNull View drawerView) { }
        @Override
        public void onDrawerClosed(@NonNull @NotNull View drawerView) { }
        @Override
        public void onDrawerStateChanged(int newState) { }
    };
}