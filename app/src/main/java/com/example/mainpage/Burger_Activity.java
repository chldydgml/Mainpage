package com.example.mainpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Burger_Activity extends AppCompatActivity {
    private TextView menu1, menu2, menu3, menu4, menu5, menu6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);

        menu6 = findViewById(R.id.H_4);
        menu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Burger_Activity.this, Provision_Activity.class);
                startActivity(intent);
            }
        });
    }
}