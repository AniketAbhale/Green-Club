package com.example.green;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void viewevent(View view) {
        Intent i = new Intent(home.this,activity_showevents.class);
        startActivity(i);

    }

    public void viewnotice(View view) {
        Intent i = new Intent(home.this,viewNotice.class);
        startActivity(i);

    }

    public void logout(View view) {
        finish();
    }

    public void admin(View view) {
        Intent i = new Intent(home.this,login.class);
        startActivity(i);
    }

    public void environment(View view) {
        Intent i=new Intent(home.this,enviawarness.class);
        startActivity(i);

    }

    public void grp(View view) {
        Intent i=new Intent(home.this,grpdetails.class);
        startActivity(i);

    }
}