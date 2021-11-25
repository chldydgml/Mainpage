package com.example.mainpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mypage_Activity extends AppCompatActivity {
    private Button menu6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

       menu6.findViewById(R.id.menu6);
       menu6.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(Mypage_Activity.this, Question_Activity.class);
               startActivity(intent);
           }
       });
    }
}