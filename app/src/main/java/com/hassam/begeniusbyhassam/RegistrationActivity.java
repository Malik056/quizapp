package com.hassam.begeniusbyhassam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class RegistrationActivity extends AppCompatActivity {


    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mView = findViewById(R.id.grand_parent);

        TextView mLoginText = findViewById(R.id.alreadytext);
        Button mBtnCreateOne = findViewById(R.id.btnCreateAccount);


        mLoginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mBtnCreateOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText nameTxt, emailTxt, passwordTxt;
                nameTxt = findViewById(R.id.txtFullName);
                emailTxt = findViewById(R.id.txtEmail);
                passwordTxt = findViewById(R.id.txtPassword);


                String name = nameTxt.getText().toString();
                String email = emailTxt.getText().toString();
                String password = passwordTxt.getText().toString();

                MyDb myDb = MyDb.getInstance(getApplicationContext());
                SQLiteDatabase db = myDb.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("name",name);
                values.put("password",password);
                values.put("email",email);

                db.insert("User",null,values);

                Snackbar.make(mView,"Succesfully Registered!",Snackbar.LENGTH_LONG).show();

                nameTxt.getText().clear();
                emailTxt.getText().clear();
                passwordTxt.getText().clear();

                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
