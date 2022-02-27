package com.example.green;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class viewNotice extends AppCompatActivity {
    RecyclerView recyclerView;
    com.example.green.myfirebaseadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notice);
        recyclerView=(RecyclerView)findViewById(R.id.recview2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<com.example.green.noticeuserhelperclass> options = new FirebaseRecyclerOptions.Builder<com.example.green.noticeuserhelperclass>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("notice"), com.example.green.noticeuserhelperclass.class)
                .build();
        myadapter= new com.example.green.myfirebaseadapter(options);
        recyclerView.setAdapter(myadapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        myadapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        myadapter.stopListening();
    }
}