package com.example.green;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.HashMap;

public class upload extends AppCompatActivity {

    private static final int PICK_IMG = 1;
    private ArrayList<Uri> ImageList = new ArrayList<Uri>();
    private int uploads = 0;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    int index = 0;
    TextView textView;
    EditText Event;
    Button choose,send;
    Context context;

    String text1;
    String evnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Uploading... Please Wait");
        textView = findViewById(R.id.text);
        choose = findViewById(R.id.choose);
        Event=findViewById(R.id.event);

        send = findViewById(R.id.upload);

    }



    public void choose(View view) {
        if (Event.getText().toString().equals("")){
            Event.setError("Enter Event Before Choosing Images ");
        }
        else {
            Event.setError(null);
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);

            startActivityForResult(intent, PICK_IMG);
        }

    }

  

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMG) {
            if (resultCode == RESULT_OK) {
                if (data.getClipData() != null) {
                    int count = data.getClipData().getItemCount();

                    int CurrentImageSelect = 0;

                    while (CurrentImageSelect < count) {
                        Uri imageuri = data.getClipData().getItemAt(CurrentImageSelect).getUri();
                        ImageList.add(imageuri);
                        CurrentImageSelect = CurrentImageSelect + 1;
                    }
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("You Have Selected "+ ImageList.size() +" Pictures" );
                    choose.setVisibility(View.GONE);
                    send.setVisibility(View.VISIBLE);
                }

            }

        }

    }

    @SuppressLint("SetTextI18n")
    public void upload(View view) {
        text1=Event.getText().toString();
        databaseReference = FirebaseDatabase.getInstance().getReference().child(text1);
        textView.setText("Please Wait ... If Uploading takes Too much time please the button again ");
        progressDialog.show();
        final StorageReference ImageFolder =  FirebaseStorage.getInstance().getReference().child("ImageFolder");
        for (uploads=0; uploads < ImageList.size(); uploads++) {
            Uri Image  = ImageList.get(uploads);
            final StorageReference imagename = ImageFolder.child("image/"+Image.getLastPathSegment());

            imagename.putFile(ImageList.get(uploads)).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    imagename.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {

                            String url = String.valueOf(uri);
                            SendLink(url);
                        }
                    });

                }
            });


        }


    }

    private void SendLink(String url) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("imageUrl", url);
        databaseReference.push().setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                progressDialog.dismiss();
                textView.setText("Image Uploaded Successfully");
                send.setVisibility(View.GONE);
                ImageList.clear();
             //   allevents();

                Intent i = new Intent(upload.this,upload.class);
                startActivity(i);
                finish();
            }
        });


    }



    public void view(View view) {
evnt=Event.getText().toString().trim();
System.out.println(evnt);

Intent i = new Intent(upload.this, com.example.green.ShowActivity.class);
i.putExtra("evnt",evnt);
startActivity(i);
    }


}





