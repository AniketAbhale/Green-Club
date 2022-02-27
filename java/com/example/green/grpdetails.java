package com.example.green;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class grpdetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grpdetails);
    }

    public void link(View view) {
        Uri uri=Uri.parse("https://chat.whatsapp.com/GFjiIu6KhDvEJXPCyScAaw");
        Intent i=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }
}