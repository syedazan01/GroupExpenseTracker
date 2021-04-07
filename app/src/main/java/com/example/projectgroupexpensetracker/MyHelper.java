package com.example.projectgroupexpensetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.List;

public class MyHelper extends SQLiteOpenHelper {
    public static String dbname = "azanapp.db";
    public static int dbversion = 1;
    public static final SQLiteDatabase db = null;
    public static final String TRIP_TABLE="triptable";
    public static final String Key_id="id";
    public static final String Key_trip="trip";
    public static final String Key_group="groups";
    public static final String Key_name="name";
    public static final String Key_expanse="expanse";
    public static final String Key_amount="amount";


    public MyHelper(Context context){
        super(context,dbname,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE TRIPDATA(_id INTEGER PRIMARY KEY AUTOINCREMENT,TRIP TEXT,INTEGER GROUP,NAME TEXT,EXPNSES TEXT,INTEGER AMOUNT)";
        sqLiteDatabase.execSQL(" Create Table " + TRIP_TABLE + "(" + Key_id + " INTEGER PRIMARY KEY AUTOINCREMENT ," + Key_trip + " VARCHAR ," + Key_group + " VARCHAR , "+Key_name +" VARCHAR ,"+Key_amount+" VARCHAR ,"+ Key_expanse +" VARCHAR );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertData(String name,String trip,String groups,String amount,String expanse)
    {
        SQLiteDatabase sd=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Key_trip,trip);
        contentValues.put(Key_group,groups);
        contentValues.put(Key_amount,amount);
        contentValues.put(Key_name,name);
        contentValues.put(Key_expanse,expanse);
        sd.insert(TRIP_TABLE,null,contentValues);
        sd.close();
    }
    public boolean isNameExist(String name)
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor;
        cursor=sqLiteDatabase.rawQuery(" Select * From "+ TRIP_TABLE + " Where "+ Key_name +" = '" + name + " ' ",null);

        cursor.moveToFirst();

        if (cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public String[] getAllName()
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();

        Cursor cursor=sqLiteDatabase.rawQuery(" Select "+Key_name+" From "+TRIP_TABLE,null);
        String[] allname=new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int i=0;i<cursor.getCount();i++)
        {
            allname[i]=cursor.getString(cursor.getColumnIndex(Key_name));
            cursor.moveToNext();
        }
        cursor.close();
        sqLiteDatabase.close();
        return allname;
    }
    public String[] getAllType()
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();

        Cursor cursor=sqLiteDatabase.rawQuery(" Select "+Key_expanse+" From "+TRIP_TABLE,null);
        String[] allexpanse=new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int i=0;i<cursor.getCount();i++)
        {
            allexpanse[i]=cursor.getString(cursor.getColumnIndex(Key_expanse));
            cursor.moveToNext();
        }
        cursor.close();
        sqLiteDatabase.close();
        return allexpanse;
    }
    public void updateUser(String name,String key_expanse,String key_amount) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Key_expanse,key_expanse);
        values.put(Key_amount,key_amount);
        // updating row
        db.update(TRIP_TABLE, values, Key_name + " = ?",
                new String[]{name});
        db.close();
    }
    public List<Module> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                Key_id,
                Key_name,
                Key_expanse
        };
        // sorting orders
        String sortOrder =
                Key_id + " ASC";
        List<Module> userList = new ArrayList<Module>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = sqLiteDatabase.query(TRIP_TABLE, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                Module user = new Module(Key_id,Key_name,Key_expanse);
                user.setId(cursor.getString(cursor.getColumnIndex(Key_id)));
                user.setName(cursor.getString(cursor.getColumnIndex(Key_name)));
                user.setExpanse(cursor.getString(cursor.getColumnIndex(Key_expanse)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();

        // return user list
        return userList;
    }
}
