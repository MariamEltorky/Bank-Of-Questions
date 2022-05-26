package com.example.bankofquestions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class ScoreActivity extends AppCompatActivity {
    TextView finalsc;
    TextView fin;
    Button logout,ans,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        finalsc=findViewById(R.id.finalscore); //to display score
        fin=findViewById(R.id.fin); //to display words Congratulations or Try Again
        logout=findViewById(R.id.logout); //button to lot out
        back=findViewById(R.id.back); //button to answer another questions again
        int receiveValue = getIntent().getIntExtra("value", 0); //to receive value of sum and display it
        finalsc.setText("" + receiveValue);
        if (receiveValue > 2) {
            fin.setText("Congratulations!");
        }
        else {
            fin.setText("Try Again!");
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new
                        AlertDialog.Builder(ScoreActivity.this); //to create AlertDialog
                builder.setTitle("Confirmation!").setMessage("Are you sure, you want to logout?");
                        builder.setPositiveButton("Yes", //if user press yes in AlertDialog
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(getApplicationContext(),
                                MainActivity.class); //if user wants to log out, Main activity will open
                        startActivity(i);
                    }
                });
                builder.setNegativeButton("No", //if user pressno in AlertDialog
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel(); //user will be in the same activity
                    }
                });
                AlertDialog alert11 = builder.create(); //to create AlertDialog
                alert11.show(); //to display AlertDialog
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new
                        AlertDialog.Builder(ScoreActivity.this); //to create AlertDialog
                builder.setTitle("Confirmation!").setMessage("You want To Try Quiz Again With another Questions?");
                        builder.setPositiveButton("Yes",
//if user press yes in AlertDialog
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent i = new Intent(getApplicationContext(),
                                                QuizActivity.class); //if user wants to try again, quiz activity will open
                                        startActivity(i);
                                    }
                                });
                builder.setNegativeButton("No", //if user press no in AlertDialog
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel(); //user will be in the same activity
                    }
                });
                AlertDialog alert11 = builder.create(); //to create AlertDialog
                alert11.show(); //to display AlertDialog
            }
        });
    }
}