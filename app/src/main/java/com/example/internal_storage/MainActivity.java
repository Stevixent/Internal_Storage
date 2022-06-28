package com.example.internal_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText, passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditTextID);


    }

    public void Save(View view){
        String name = nameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        File file = null;
        FileOutputStream fileOutputStream = null;

        try {
            name = name + " ";
            file = getFilesDir();

            fileOutputStream = openFileOutput("andriodtext.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(name.getBytes());
            fileOutputStream.write(password.getBytes());
            fileOutputStream.close();

            Toast.makeText(MainActivity.this, "Your file has been saved \n at path " + file + "\tandroidtext.txt ", Toast.LENGTH_LONG ).show();

            nameEditText.setText("");
            passwordEditText.setText("");

            return;

        }catch (Exception e){
            Log.e("Exception", e.toString());
        }finally {
            try {
                fileOutputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    public void Next(View view){
        Intent intent = new Intent(MainActivity.this, RetrieveActivity2.class);
        startActivity(intent);

    }
}