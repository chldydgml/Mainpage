package com.example.mainpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private View drawerView;
    ImageView btn_filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_filter = findViewById(R.id.icon_filter1);
        mDrawer = findViewById(R.id.drawer_layout);
        drawerView = findViewById(R.id.drawerView2);
        mDrawer.setDrawerListener(listener);


        btn_filter.setOnClickListener(v -> mDrawer.openDrawer(drawerView));

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

                        case R.id.tab_info:
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment_info()).commitAllowingStateLoss();
                            break;

                        case R.id.tab_login:
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment_login()).commitAllowingStateLoss();
                            break;
                    }
                    return true;
                }
        );


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