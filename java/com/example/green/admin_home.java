package com.example.green;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class admin_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void uploadevent(View view) {
        Intent i = new Intent(admin_home.this,upload.class);
        startActivity(i);
    }

    public void addnotice(View view) {
        Intent i=new Intent(admin_home.this,notification.class);
        startActivity(i);

    }

    public void logout(View view) {
        finish();
    }
}