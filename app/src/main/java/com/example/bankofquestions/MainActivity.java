package com.example.bankofquestions;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity {
    SharedPreferences spf;
    EditText edtusername;
    EditText edtpassword;
    Button clicklogin,clickregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtusername = findViewById(R.id.idusername);
        edtpassword = findViewById(R.id.idpassword);
        clicklogin = findViewById(R.id.idlogin);
        clickregister = findViewById(R.id.idregister);
        spf = getSharedPreferences("Users", Context.MODE_PRIVATE);
        clicklogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verification(v);
                edtusername.setText(""); //to get username editText empty
                edtpassword.setText(""); //to get password editText empty
            }
        });
        clickregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterData(v);
            }
        });
    }
    //if new user entered that method will store new user data
    public void RegisterData (View v) {
        SharedPreferences.Editor editor=spf.edit();
        if (edtusername.getText().length()>0 && edtpassword.getText().length()>0) {
            String pass=edtpassword.getText().toString();
            String name=edtusername.getText().toString();
            editor.putString(pass + "name" ,edtusername.getText().toString());
            editor.putString(name + "pass" ,edtpassword.getText().toString());
            editor.commit();
        }
        else {
            Message.message(getApplicationContext(), "Please Enter UserName and Password"); //to show Message
        }
    }
    //If the old user wants to enter the quiz, this method will verify the user
    public void verification(View v) {
        String pass=edtpassword.getText().toString();
        String name=edtusername.getText().toString();
        if (edtusername.getText().length()>0 && edtpassword.getText().length()>0) {
//to check if editText ofusername and password empty or not
            String na=spf.getString(pass +"name" ,"Not Exist");
            String pa=spf.getString(name +"pass" ,"Not Exist");
            String Rna=spf.getString(pass +"name" , name);
            String Rpa=spf.getString(name +"pass" , pass);
            if (Rpa.equals(pass)) { //to check if password correct or not
                if (!na.equals("Not Exist") && !pa.equals("Not Exist")) {
                    //to check if name and password are exist in SharedPreferences or not
                    OpenQuizActivity();
                    Message.message(getApplicationContext(), "Successful login");
                }
                else {
                    Message.message(getApplicationContext(), "Please Register First");
                    //if not exist in SharedPreferences
                    edtusername.setText("");
                    edtpassword.setText("");
                }
            }
            if (!Rpa.equals(pass)) { //if user entered incorrect answer
                Message.message(getApplicationContext(), "Please Enter Correct Password");
            }
        } //any editText if empty
        Message.message(getApplicationContext(), "Please Enter your Name and Password");
    }
    //open second activity if data of user verify
    public void OpenQuizActivity() {
        Intent intent =new Intent(this,QuizActivity.class);
        startActivity(intent);
    }
}

