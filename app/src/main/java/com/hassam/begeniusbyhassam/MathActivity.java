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

public class MathActivity extends AppCompatActivity {

    Button mOption1, mOption2, mOption3, mOption4;
    TextView score, question;

    private MathQuestions mMathQuestions = new MathQuestions();

    private String mAnswer;
    private double mScore = 0;
    int btnPressed = 0;

    private View mView;

    private String userName;

    double temp = mScore;

    private int mMathQuestionsLength = mMathQuestions.mMathQuestions.length;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        mOption1 = findViewById(R.id.ansOne);
        mOption2 = findViewById(R.id.ansTwo);
        mOption3 = findViewById(R.id.ansThree);
        mOption4 = findViewById(R.id.ansFour);

        mView = findViewById(R.id.parent);

        score = findViewById(R.id.txtScore);
        question = findViewById(R.id.txtQuestion);

        userName = getIntent().getStringExtra("email");

        r = new Random();

        updateQuestions(r.nextInt(mMathQuestionsLength));

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
                Snackbar.make(mView,"Correct Answer",Snackbar.LENGTH_LONG).show();
                temp = mScore + 1;
                updateQuestions(r.nextInt(mMathQuestionsLength));

            } else {
                mScore = (mScore - 0.5);
                score.setText("Score: " + mScore);
                Snackbar.make(mView,"Incorrect Answer",Snackbar.LENGTH_LONG).show();
                updateQuestions(r.nextInt(mMathQuestionsLength));
                temp = (mScore - 0.5);
                if (mScore < 0) {
                    mScore = 0;
                    score.setText("Score: " + mScore);
                }

            }
            if (btnPressed >= 10) {


                MyDb myDb = MyDb.getInstance(getApplicationContext());
                SQLiteDatabase sqLiteDatabase = myDb.getWritableDatabase();
                ContentValues values = new ContentValues();

                String subject = "Math";

                values.put("score", mScore);
                values.put("email", userName);
                values.put("subjectName", subject);

                sqLiteDatabase.insert("userScore", null, values);


                String grade = "";
                grade = (mScore < 7 ? "Fail" : "Pass");

                AlertDialog.Builder builder = new AlertDialog.Builder(MathActivity.this);
                builder.setTitle("Result").setMessage(userName + " have " + mScore + " marks. According to your Marks. " + userName + " is " + grade)
                        .setCancelable(false)
                        .setPositiveButton("Result Sheet", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(MathActivity.this, ResultActivity.class);
                                intent.putExtra("email",userName);

                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Select Subject", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(MathActivity.this, CategoryActivity.class);
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

        question.setText(mMathQuestions.getQuestion(num));
        mOption1.setText(mMathQuestions.getChoice1(num));
        mOption2.setText(mMathQuestions.getChoice2(num));
        mOption3.setText(mMathQuestions.getChoice3(num));
        mOption4.setText(mMathQuestions.getChoice4(num));

        mAnswer = mMathQuestions.getCorrectAnswers(num);

    }
}
