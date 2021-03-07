package com.example.algorithm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.algorithm.R;

public class MainActivity extends AppCompatActivity {

    Button studentLogin, adminLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentLogin = findViewById(R.id.student_login);
        adminLogin = findViewById(R.id.admin_login);

        studentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StudentPanelActivity.class);
                startActivity(intent);
            }
        });

        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminPanelActivity.class);
                startActivity(intent);
            }
        });
    }
}
