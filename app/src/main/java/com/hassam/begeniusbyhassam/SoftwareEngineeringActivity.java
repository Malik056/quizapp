package com.hassam.begeniusbyhassam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class SoftwareEngineeringActivity extends AppCompatActivity {

    Button mOption1, mOption2, mOption3, mOption4;
    TextView score, question;

    private SoftwareEngineeringQuestions mSoftwareEngineeringQuestions = new SoftwareEngineeringQuestions();

    private String mAnswer;
    private double mScore = 0;
    int btnPressed = 0;
    private String userName;

    private View mView;

    private int mSoftwareEngineeringQuestionsLength = mSoftwareEngineeringQuestions.mSoftwareEngineeringQuestions.length;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software_engineering);
        mOption1 = findViewById(R.id.ansOne);
        mOption2 = findViewById(R.id.ansTwo);
        mOption3 = findViewById(R.id.ansThree);
        mOption4 = findViewById(R.id.ansFour);

        mView = findViewById(R.id.parent);

        userName = getIntent().getStringExtra("email");

        score = findViewById(R.id.txtScore);
        question = findViewById(R.id.txtQuestion);

        r = new Random();

        updateQuestions(r.nextInt(mSoftwareEngineeringQuestionsLength));

        final Random r1 = new Random();

        mOption1.setOnClickListener(clickListener);
        mOption2.setOnClickListener(clickListener);
        mOption3.setOnClickListener(clickListener);
        mOption4.setOnClickListener(clickListener);

    }
    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            btnPressed++;
            userName = getIntent().getStringExtra("email");

            Button option = (Button) view;
            if (option.getText() == mAnswer) {
                mScore++;
                score.setText("Score: " + mScore);
                Snackbar.make(mView,"Correct Answer", Snackbar.LENGTH_LONG).show();
                updateQuestions(r.nextInt(mSoftwareEngineeringQuestionsLength));

            } else {
                mScore = (mScore - 0.5);
                score.setText("Score: " + mScore);
                Snackbar.make(mView,"Incorrect Answer", Snackbar.LENGTH_LONG).show();
                updateQuestions(r.nextInt(mSoftwareEngineeringQuestionsLength));
                if(mScore<0){
                    mScore = 0;
                    score.setText("Score: " + mScore);
                }

            }
            if(btnPressed>=10){


                MyDb myDb = MyDb.getInstance(getApplicationContext());
                SQLiteDatabase sqLiteDatabase = myDb.getReadableDatabase();
                ContentValues values = new ContentValues();

                String subject = "Software Engineering";

                values.put("Score", mScore);
                values.put("email", userName);
                values.put("subjectName", subject);

                sqLiteDatabase.insert("userScore", null, values);
                String grade = "";
                grade = (mScore < 7 ? "Fail" : "Pass");

                AlertDialog.Builder builder = new AlertDialog.Builder(SoftwareEngineeringActivity.this);
                builder.setTitle("Result").setMessage(userName+" have " +mScore+" marks. According to your Marks. "+userName+ " is " +grade)
                        .setCancelable(false)
                        .setPositiveButton("Result Sheet", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(SoftwareEngineeringActivity.this,ResultActivity.class);
                                intent.putExtra("email",userName);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Select Subject", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(SoftwareEngineeringActivity.this,CategoryActivity.class);
                                intent.putExtra("email",userName);
                                startActivity(intent);
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }

        }
    };

    private void updateQuestions(int num) {

        question.setText(mSoftwareEngineeringQuestions.getQuestion(num));
        mOption1.setText(mSoftwareEngineeringQuestions.getChoice1(num));
        mOption2.setText(mSoftwareEngineeringQuestions.getChoice2(num));
        mOption3.setText(mSoftwareEngineeringQuestions.getChoice3(num));
        mOption4.setText(mSoftwareEngineeringQuestions.getChoice4(num));

        mAnswer = mSoftwareEngineeringQuestions.getCorrectAnswers(num);

    }

}
