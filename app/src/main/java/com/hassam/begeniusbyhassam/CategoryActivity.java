package com.hassam.begeniusbyhassam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {

    private Button mBtnComputer, mBtnMath, mBtnGKnowledge,mBtnDatabase,mBtnSoftwareEngineering;
    private ImageButton mBtnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        final String userName = getIntent().getStringExtra("email");
        final TextView mLoginTxt = findViewById(R.id.txtLogin);
        mLoginTxt.setText("Login As: "+userName);


        mBtnComputer = findViewById(R.id.btnComputer);
        mBtnMath = findViewById(R.id.btnMath);
        mBtnGKnowledge = findViewById(R.id.btnGKnowledge);
        mBtnDatabase = findViewById(R.id.btnDatabase);
        mBtnSoftwareEngineering = findViewById(R.id.btnSoftwareEngineering);
        mBtnLogout = findViewById(R.id.btnLogout);

        mBtnComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, ComputerActivity.class);
                intent.putExtra("email",userName);
                startActivity(intent);
            }
        });
        mBtnMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, MathActivity.class);
                intent.putExtra("email",userName);
                startActivity(intent);
            }
        });
        mBtnGKnowledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, GKnowledgeActivity.class);
                intent.putExtra("email",userName);
                startActivity(intent);
            }
        });
        mBtnDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, DatabaseActivity.class);
                intent.putExtra("email",userName);
                startActivity(intent);
            }
        });
        mBtnSoftwareEngineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, SoftwareEngineeringActivity.class);
                intent.putExtra("email",userName);
                startActivity(intent);
            }
        });
        mBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
