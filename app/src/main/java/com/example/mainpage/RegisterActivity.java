package com.example.mainpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth; // 파이어베이스 인증 처리
    private DatabaseReference mDatabaseReference; //실시간 데이터 베이스
    private EditText mEtEmail, mEetPwd, mEtname;
    private Button mBtnREgister; // 회원 가입 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("FBLoginLast");

        mEtEmail = findViewById(R.id.input_id);
        mEetPwd= findViewById(R.id.input_pwd);
        mEtname = findViewById(R.id.input_name);
        mBtnREgister = findViewById(R.id.btn_register);

        mBtnREgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //회원가입 처리가 시작되는 위치
                String strEmail = mEtEmail.getText().toString();
                String strPwd = mEetPwd.getText().toString();
                String strName = mEtname.getText().toString();

                //FirebaseAuth 시작
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser(); //가져온다 현재의 유저를
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseUser.getUid()); // 고유값
                            account.setEmailId(firebaseUser.getEmail());
                            account.setPassword(strPwd); // 사용자가 입력했던 것을 그대로 가져온다.
                            account.setName(strName);

                            //setValue : dataBase에 insert
                            mDatabaseReference.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                            Toast.makeText(RegisterActivity.this, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this,Fragment_home.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(RegisterActivity.this, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}