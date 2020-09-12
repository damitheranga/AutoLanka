package com.example.testmapcar;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DatabaseVersion = 1;
    public static final String DATABASE_NAME = "Route.db";
    public static final String TABLE_NAME = "mapRoute";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "DeviceID";
    public static final String COL_3 = "Route";
    public static final String COL_4 = "Bearing";
    public static final String COL_5 = "Accuarcy";
    public static final String COL_6 = "Altitude";
    public static final String COL_7 = "Speed";
    public static final String COL_8 = "timeStamp";








    public DBHandler(@Nullable Context context) {

        super(context, DATABASE_NAME, null, DatabaseVersion);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,DeviceID TEXT,Route INTEGER,Bearing INTEGER,Accuarcy INTEGER,Altitude INTEGER,Speed INTEGER)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String DeviceID, LatLng Route, float Bearing, float Accuracy, double Altitude, int Speed,String time) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,DeviceID);
        contentValues.put(COL_3, String.valueOf(Route));
        contentValues.put(COL_4,Bearing);
        contentValues.put(COL_5,Accuracy);
        contentValues.put(COL_6,Altitude);
        contentValues.put(COL_7,Speed);
        contentValues.put(COL_8,time);



        long result = sqLiteDatabase.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }


}
