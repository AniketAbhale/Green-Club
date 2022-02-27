package com.example.green;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class enviawarness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviawarness);
    }

    public void sanitation(View view) {
        Intent i=new Intent(enviawarness.this, com.example.green.sanhygiene.class);
        startActivity(i);
    }

    public void waste(View view) {
        Intent i=new Intent(enviawarness.this, com.example.green.wasteman.class);
        startActivity(i);
    }

    public void energy(View view) {
        Intent i=new Intent(enviawarness.this,energyman.class);
        startActivity(i);
    }
}