
//////// MainActivity61  er part

package com.example.practiceapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper2 extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "userdetails.db";
    private static final String TABLE_NAME = "user_details";
    private static final String ID = "Id";
    private static final String NAME = "Name";
    private static final String EMAIL = "Email";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final int VERSION_NUMBER = 1;

    // OnCreate er toast e use korar jonno context ta create korechi
    private Context context;

    // OnCreate er jonno table create korechi
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(250) NOT NULL, "+EMAIL+" TEXT NOT NULL, "+USERNAME+" TEXT NOT NULL, "+PASSWORD+" TEXT NOT NULL )";

    // OnUpgrade er jonno table drop korechi
    private static final String DROP_TABLE = " DROP TABLE IF EXISTS " + TABLE_NAME;

    public MyDatabaseHelper2(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);

        // context ta k receive korechi
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try
        {
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context, "OnCreate is called", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(context, "Exception : "+e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // First e table ta drop hobe then abar OnCreate method call hobe
        try
        {
            Toast.makeText(context, "OnUpgrade is called", Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
        catch(Exception e)
        {
            Toast.makeText(context, "Exception : "+e, Toast.LENGTH_SHORT).show();
        }
    }

    public long insertData(UserDetails userDetails)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, userDetails.getName());
        contentValues.put(EMAIL, userDetails.getEmail());
        contentValues.put(USERNAME, userDetails.getUsername());
        contentValues.put(PASSWORD, userDetails.getPassword());

        // Je row insert hobe tar Id return hobe
        long rowId = db.insert(TABLE_NAME, null, contentValues);
        return rowId;
    }

    // ei method check korbe user er deya data database er datar sathe match kore ki na
    public Boolean findPassword(String uname, String pass)
    {
        // Data kujar jonno....database read korar jonno
        SQLiteDatabase db = this.getReadableDatabase();

        // Shob data kujar jonno query
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);

        // result ta check korar jonno ekti variable
        Boolean result = false;

        // cursor e kuno row na takle 0....row takle move next cursor
        if(cursor.getCount() == 0)
        {
            Toast.makeText(context, "No data is found", Toast.LENGTH_SHORT).show();
        }

        else
        {
            while(cursor.moveToNext())
            {
                // 3 number column username tai 3 diyechi......same as 4 number column password tai 4 diyechi
                String SIusername = cursor.getString(3);
                String SIpassword = cursor.getString(4);

                // check korechi user er deya info database er info er sathe match kore ki na
                if(SIusername.equals(uname) && SIpassword.equals(pass))
                {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}



