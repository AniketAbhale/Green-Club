package com.example.green;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;

public class login extends AppCompatActivity {
    TextInputLayout id,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        id=findViewById(R.id.aid);
        pass=findViewById(R.id.password);

    }

    public void back(View view) {

        Intent i = new Intent(this,login.class);
        startActivity(i);

    }

    public void submit(View view) {

        if(id.getEditText().getText().toString().toLowerCase(Locale.ROOT).trim().equals("admin")){
            if (pass.getEditText().getText().toString().toLowerCase(Locale.ROOT).trim().equals("admin@123")){
                Toast.makeText(this,"LOGIN DONE",Toast.LENGTH_LONG).show();
                pass.getEditText().setText("");
                id.getEditText().setText("");
                Intent i=new Intent(login.this,admin_home.class);
                startActivity(i);
                finish();

            }
            else{
                pass.getEditText().setText("");
                id.setError(null);
                pass.setError("Invalid Password");
            }

        }
        else{
            pass.getEditText().setText("");
            id.getEditText().setText("");
            id.setError("Invalid User");
        }




    }
}