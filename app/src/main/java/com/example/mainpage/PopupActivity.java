package com.example.mainpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mainpage.R;

public class PopupActivity extends AppCompatActivity {
    TextView mTitle;
    TextView mTime;
    ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        mTitle = findViewById(R.id.tv_title);
        mTime = findViewById(R.id.tv_time);
        mImage = findViewById(R.id.img_img);

        Intent intent = getIntent();
        mTitle.setText(intent.getStringExtra("title"));
        mTime.setText(intent.getStringExtra("time"));
        mImage.setImageResource(intent.getIntExtra("image", 0));

        Button back = (Button)findViewById(R.id.btn_back);
        back.setOnClickListener(v -> finish());

        findViewById(R.id.btn_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("http://in2youth.kr/bbs/board.php?bo_table=intoyou_01&wr_id=48"));
                startActivity(intent1);
            }
        });
    }
}