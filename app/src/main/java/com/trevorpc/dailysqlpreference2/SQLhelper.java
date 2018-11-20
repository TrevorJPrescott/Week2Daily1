package com.trevorpc.dailysqlpreference2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.provider.Telephony.Carriers.PASSWORD;
import static com.trevorpc.dailysqlpreference2.Constants.DATABASE_NAME;
import static com.trevorpc.dailysqlpreference2.Constants.EMAIL;
import static com.trevorpc.dailysqlpreference2.Constants.FB;
import static com.trevorpc.dailysqlpreference2.Constants.PHONE;
import static com.trevorpc.dailysqlpreference2.Constants.SKYPE;
import static com.trevorpc.dailysqlpreference2.Constants.TABLE_NAME;
import static com.trevorpc.dailysqlpreference2.Constants.USER_NAME_KEY;

public class SQLhelper extends SQLiteOpenHelper
{
    public SQLhelper(Context context, SQLiteDatabase.CursorFactory factory)
    {
        super(context, DATABASE_NAME, factory, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTableQuery = "CREATE TABLE " + TABLE_NAME
                + " (" + USER_NAME_KEY + " TEXT PRIMARY KEY, "
                + PHONE + " TEXT, "
                + EMAIL + " TEXT, "
                + SKYPE + " TEXT, "
                + FB + " TEXT)";
        Log.d("Tag", "onCreate: "+createTableQuery);
        sqLiteDatabase.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

    public boolean insertInput (String pname,String name, String phone,String email,String skype,String facebook)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.USER_NAME_KEY,pname);
        contentValues.put(Constants.NAME, name);
        contentValues.put(PHONE, phone);
        contentValues.put(Constants.EMAIL,email);
        contentValues.put(Constants.SKYPE,skype);
        contentValues.put(FB,facebook);
        db.insert(TABLE_NAME, null, contentValues);
        Log.d("Tag", "insertInput: "+contentValues);
        return true;
    }

    public Cursor getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select "+ Constants.NAME +" from " + TABLE_NAME, null );
        return res;
    }

    public Cursor getUsersByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from " + TABLE_NAME  + " WHERE " + USER_NAME_KEY + " = \"" +  name + "\"", null );
        return res;
    }

    public Cursor getAllUsersNames() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select " + USER_NAME_KEY + " from " + TABLE_NAME, null );
        return res;
    }

}

