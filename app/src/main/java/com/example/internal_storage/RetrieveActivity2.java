package com.example.internal_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;

public class RetrieveActivity2 extends AppCompatActivity {
    EditText nameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve2);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditTextID);
    }
    public void Retrieve(View view){
    try {
        FileInputStream fileInputStream = openFileInput("andriodtext.txt");
        int read = -1;
        StringBuffer buffer = new StringBuffer();
        while ((read = fileInputStream.read()) !=-1){
            buffer.append((char)read);
        }

        String name = buffer.substring(0, buffer.indexOf(" "));
        String password = buffer.substring(buffer.indexOf(" ") + 1);

        nameEditText.setText(name);
        passwordEditText.setText(password);



    }catch (Exception e){
    Log.e("Exception", e.toString());

    }
    }
    public void Back(View view){
        Intent intent = new Intent(RetrieveActivity2.this, MainActivity.class);
        startActivity(intent);

    }
}