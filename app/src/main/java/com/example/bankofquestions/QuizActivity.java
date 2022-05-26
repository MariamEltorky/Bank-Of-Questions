package com.example.bankofquestions;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;
public class QuizActivity extends AppCompatActivity {
    RadioGroup R1, R2, R3, R4, R5;
    RadioButton AQ11, BQ11, CQ11, AQ22, BQ22, CQ22, AQ33, BQ33, CQ33, AQ44, BQ44,
            CQ44, AQ55, BQ55, CQ55; //to set id of all choices RadioButton
    Button getscore;
    public String ChannalId = "0123X";
    public int NotificationId = 0;
    //to set id of all questions RadioButton
    TextView question1, question2, question3, question4, question5;
    Random r; //object from random to get questions randomly
    //to store correct answer and returned
    public String CAnswer1, CAnswer2, CAnswer3, CAnswer4, CAnswer5 = "";
    // to take returned correct answers
    public String CAnswer11, CAnswer22, CAnswer33, CAnswer44, CAnswer55;
    Questions mcq = new Questions();
    private int length = mcq.getLen();
    int x; //to store the value that taken randomly
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        r = new Random(); //object from random to get questions randomly
        R1 = findViewById(R.id.R1);
        question1 = findViewById(R.id.Q1);
        AQ11 = findViewById(R.id.AQ1);
        BQ11 = findViewById(R.id.BQ1);
        CQ11 = findViewById(R.id.CQ1);
        R2 = findViewById(R.id.R2);
        question2 = findViewById(R.id.Q2);
        AQ22 = findViewById(R.id.AQ2);
        BQ22 = findViewById(R.id.BQ2);
        CQ22 = findViewById(R.id.CQ2);
        R3 = findViewById(R.id.R3);
        question3 = findViewById(R.id.Q3);
        AQ33 = findViewById(R.id.AQ3);
        BQ33 = findViewById(R.id.BQ3);
        CQ33 = findViewById(R.id.CQ3);
        R4 = findViewById(R.id.R4);
        question4 = findViewById(R.id.Q4);
        AQ44 = findViewById(R.id.AQ4);
        BQ44 = findViewById(R.id.BQ4);
        CQ44 = findViewById(R.id.CQ4);
        R5 = findViewById(R.id.R5);
        question5 = findViewById(R.id.Q5);
        AQ55 = findViewById(R.id.AQ5);
        BQ55 = findViewById(R.id.BQ5);
        CQ55 = findViewById(R.id.CQ5);
        getscore = findViewById(R.id.idscore);
        x = r.nextInt(length); //to store the value that taken randomly
        //set question1 and choices and return correct in string
        CAnswer11 = updateQuestion1(x);
        CAnswer22 = updateQuestion2(x);
        CAnswer33 = updateQuestion3(x);
        CAnswer44 = updateQuestion4(x);
        CAnswer55 = updateQuestion5(x);
        getscore.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
//to get id of selected RadioButton
                int checkedId1 = R1.getCheckedRadioButtonId();
                int checkedId2 = R2.getCheckedRadioButtonId();
                int checkedId3 = R3.getCheckedRadioButtonId();
                int checkedId4 = R4.getCheckedRadioButtonId();
                int checkedId5 = R5.getCheckedRadioButtonId();
                //check if any question is not answered or not
                if (checkedId1 == -1 || checkedId2 == -1 || checkedId3 == -1 ||
                        checkedId4 == -1 || checkedId5 == -1) {
                    Message.message(getApplicationContext(), "Please Answer All Questions");
                } else {
                    //to get text of selected RadioButton
                    RadioButton selected1 = (RadioButton) findViewById(checkedId1);
                    String selectedText1 = selected1.getText().toString();
                    RadioButton selected2 = (RadioButton) findViewById(checkedId2);
                    String selectedText2 = selected2.getText().toString();
                    RadioButton selected3 = (RadioButton) findViewById(checkedId3);
                    String selectedText3 = selected3.getText().toString();
                    RadioButton selected4 = (RadioButton) findViewById(checkedId4);
                    String selectedText4 = selected4.getText().toString();
                    RadioButton selected5 = (RadioButton) findViewById(checkedId5);
                    String selectedText5 = selected5.getText().toString();
                    findanswers(selectedText1, CAnswer11,selectedText2,
                            CAnswer22,selectedText3, CAnswer33,selectedText4, CAnswer44,selectedText5,
                            CAnswer55);
                }
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    void createChannel() {
        NotificationChannel nch = new NotificationChannel(ChannalId, "Channal Score", NotificationManager.IMPORTANCE_DEFAULT);
        nch.setDescription("Answer is ");
        NotificationManager mng = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        mng.createNotificationChannel(nch);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    void createNotification(String s) {
        createChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,
                ChannalId);
        builder.setContentTitle("Answer ").setContentText(s).setSmallIcon(R.drawable.ic_launcher_background);
                NotificationManagerCompat nmc = NotificationManagerCompat.from(this);
        ++NotificationId;
        nmc.notify(NotificationId, builder.build());
    }
    //to get question1 and all choices and return correct answer of position num andset them in xml design
    public String updateQuestion1(int num) {
        question1.setText(mcq.getQuestion(num));
        AQ11.setText(mcq.getchoice1(num));
        BQ11.setText(mcq.getchoice2(num));
        CQ11.setText(mcq.getchoice3(num));
        CAnswer1 = mcq.getCorrect(num);
        return CAnswer1;
    }
    //to get question2 and all choices and return correct answer of position num and set them in xml design
    public String updateQuestion2(int num) {
        question2.setText(mcq.getQuestion(num + 1));
        AQ22.setText(mcq.getchoice1(num + 1));
        BQ22.setText(mcq.getchoice2(num + 1));
        CQ22.setText(mcq.getchoice3(num + 1));
        CAnswer2 = mcq.getCorrect(num + 1);
        return CAnswer2;
    }
    //to get question3 and all choices and return correct answer of position num and set them in xml design
    public String updateQuestion3(int num) {
        question3.setText(mcq.getQuestion(num + 2));
        AQ33.setText(mcq.getchoice1(num + 2));
        BQ33.setText(mcq.getchoice2(num + 2));
        CQ33.setText(mcq.getchoice3(num + 2));
        CAnswer3 = mcq.getCorrect(num + 2);
        return CAnswer3;
    }
    //to get question4 and all choices and return correct answer of position num and set them in xml design
    public String updateQuestion4(int num) {
        question4.setText(mcq.getQuestion(num + 3));
        AQ44.setText(mcq.getchoice1(num + 3));
        BQ44.setText(mcq.getchoice2(num + 3));
        CQ44.setText(mcq.getchoice3(num + 3));
        CAnswer4 = mcq.getCorrect(num + 3);
        return CAnswer4;
    }
    //to get question5 and all choices and return correct answer of position num and set them in xml design
    public String updateQuestion5(int num) {
        question5.setText(mcq.getQuestion(num + 4));
        AQ55.setText(mcq.getchoice1(num + 4));
        BQ55.setText(mcq.getchoice2(num + 4));
        CQ55.setText(mcq.getchoice3(num + 4));
        CAnswer5 = mcq.getCorrect(num + 4);
        return CAnswer5;
    }
    //to check if selected RadioButton is correct or not
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void findanswers(String selectedText1, String CAnswer11, String
            selectedText2, String CAnswer22, String selectedText3, String CAnswer33, String
                                     selectedText4, String CAnswer44, String selectedText5, String CAnswer55) {
        int sum = 0;
        if (selectedText1.equals(CAnswer11)) {
            sum = sum + 1;
            createNotification("Q1 is Correct");
        }
        else {
            createNotification("Q1 is InCorrect");
        }
        if (selectedText2.equals(CAnswer22)) {
            createNotification("Q2 is Correct");
            sum = sum + 1;
        }
        else {
            createNotification("Q2 is InCorrect");
        }
        if (selectedText3.equals(CAnswer33)) {
            sum = sum + 1;
            createNotification("Q3 is Correct");
        }
        else {
            createNotification("Q3 is InCorrect");
        }
        if (selectedText4.equals(CAnswer44)) {
            createNotification("Q4 is Correct");
            sum = sum + 1;
        }
        else {
            createNotification("Q4 is InCorrect");
        }
        if (selectedText5.equals(CAnswer55)) {
            createNotification("Q5 is Correct");
            sum = sum + 1;
        } else {
            createNotification("Q5 is InCorrect");
        }
        Intent intent =new Intent(this,ScoreActivity.class); //to open next activity that contains score of quiz
        intent.putExtra("value", sum); //to pass value of sum to next activity
        startActivity(intent);
    }
}