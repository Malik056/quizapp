package com.hassam.begeniusbyhassam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyDb extends SQLiteOpenHelper {

    private static final String DBName = "myDb";
    private static final int VERSION = 2;
    private static MyDb myDb;
    static MyDb getInstance(@NonNull Context context){
        if(myDb == null){
            myDb = new MyDb(context);
        }
        return myDb;
    }

    private MyDb(@NonNull Context context) {
        super(context, DBName, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String userTable = "Create TABLE User(name VARCHAR, password VARCHAR, email VARCHAR PRIMARY KEY);";
        sqLiteDatabase.execSQL(userTable);

        String userScore =  "Create TABLE userScore(scoreId INTEGER PRIMARY KEY AUTOINCREMENT,score number, email VARCHAR,subjectName VARCHAR);";
        sqLiteDatabase.execSQL(userScore);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS User");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS userScore");
        onCreate(sqLiteDatabase);

    }
    public List<HashMap<String,Object>> getUserScores(String userId){
        SQLiteDatabase sqLiteDatabase = myDb.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from userScore where email = ?",new String[]{userId});
        List<HashMap<String,Object>> hashMaps = new ArrayList<>();

        int index = 0;
        while(cursor.moveToNext()){

            int subjectColumnFieldIndex = cursor.getColumnIndex("subjectName");
            int scoreColumnFieldIndex = cursor.getColumnIndex("score");

            HashMap <String,Object> hashMap = new HashMap<>();


            cursor.getColumnCount();
            hashMap.put("subjectName",cursor.getString(subjectColumnFieldIndex));
            hashMap.put("score",cursor.getDouble(scoreColumnFieldIndex));

            hashMaps.add(hashMap);
        }
        cursor.close();
        return hashMaps;
    }
}
