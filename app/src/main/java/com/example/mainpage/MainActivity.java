package com.example.mainpage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom);
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

                        case R.id.tab_login:
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment_login()).commitAllowingStateLoss();
                            break;

                        case R.id.tab_filter:
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment_filter()).commitAllowingStateLoss();
                            break;
                    }
                    return true;
                }
        );
    }
}