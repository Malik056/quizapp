package com.hassam.begeniusbyhassam;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView btnCreateAcc = findViewById(R.id.createone);
        btnCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void login(View view){
        MyDb myDb = MyDb.getInstance(getApplicationContext());
        SQLiteDatabase db = myDb.getReadableDatabase();

        EditText email = findViewById(R.id.txtUsername), password = findViewById(R.id.txtPass);

        String mEmail = email.getText().toString();

        String [] columns = {"email","password"};
        String [] cValues = {email.getText().toString(),password.getText().toString()};

        Cursor cursor = db.query("User",columns, "email = ? AND password = ?",cValues,null,null,null);
        if(cursor != null){
            if(cursor.moveToFirst()){


                cursor.close();

                Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
                intent.putExtra("email", mEmail);
                startActivity(intent);
            }
            else {
                cursor.close();
            }
        }

    }
}
