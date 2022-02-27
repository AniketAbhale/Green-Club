package com.example.green;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class activity_showevents extends AppCompatActivity {
    EditText Event;
    String evnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showevents);

        Event=findViewById(R.id.event);


    }
    public void view(View view) {


        evnt=Event.getText().toString().trim();
        System.out.println(evnt);
        if (Event.getText().toString().equals("")){
            Event.setError("Enter Event Before Choosing Images ");
        }
        else{
        Intent i = new Intent(activity_showevents.this, com.example.green.ShowActivity.class);
        i.putExtra("evnt",evnt);
        startActivity(i);
        }
    }
}