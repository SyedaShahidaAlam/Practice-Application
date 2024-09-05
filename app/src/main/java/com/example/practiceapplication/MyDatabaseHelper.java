
//////// MainActivity60  er part

package com.example.practiceapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME = "student.db";
    private static final String TABLE_NAME = "student_details";
    private static final int VERSION_NUMBER = 2;

    // Column name
    private static final String ID = "_id";
    private static final String NAME = "Name";
    private static final String AGE = "Age";
    private static final String GENDER = "Gender";

    // Create table
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VERCHAR(250), "+AGE+" INTEGER, "+GENDER+" VARCHAR(15)); ";

    // Drop table
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;


    private static final String SELECT_ALL = "SELECT * FROM "+TABLE_NAME;

    // OnCreate er toast e use korar jonno context ta create korechi
    private Context context;

    public MyDatabaseHelper(@Nullable Context context)
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
            Toast.makeText(context, "OnCreate is called", Toast.LENGTH_SHORT).show();
            db.execSQL(CREATE_TABLE);
        }
        catch(Exception e)
        {
            Toast.makeText(context, "Exception : "+e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        try
        {
            Toast.makeText(context, "OnUpgrade is called", Toast.LENGTH_SHORT).show();

            // Drop table
            db.execSQL(DROP_TABLE);

            // Recreate table
            onCreate(db);
        }

        catch(Exception e)
        {
            Toast.makeText(context, "Exception : "+e, Toast.LENGTH_SHORT).show();
        }
    }

    public long insertData(String name, String age, String gender)
    {
        // storing value in the database
        // ei method ta SQLiteDatabase ke return kore....tai SQLiteDatabase diyechi
        SQLiteDatabase db = this.getWritableDatabase();

        // ContentValues er moddhe shob gulo data eksathe rekha hoy....pore database e store kora hoy
        ContentValues contentValues = new ContentValues();

        // contentValues.put er maddhome column name er under e value rakha hoy
        contentValues.put(NAME, name);
        contentValues.put(AGE, age);
        contentValues.put(GENDER, gender);

        // Finally database er moddhe value insert kora
        // ekta row er value successfully insert hole shei row er id return korbe
        // successfully na hole -1 return korbe
        long rowId = db.insert(TABLE_NAME, null, contentValues);
        return rowId;
    }

    public Cursor displayAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        // For display data
        // Cursor holo ekta interface
        // Shob data gulo ekta whole set akare return kore...and sheta cursor er moddhe rakha hoy
        Cursor cursor = db.rawQuery(SELECT_ALL,null);
        return cursor;
    }

    public boolean updateData(String id, String name, String age, String gender)
    {
        // For update data
        // below 6 line from insert data
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(NAME, name);
        contentValues.put(AGE, age);
        contentValues.put(GENDER, gender);

        db.update(TABLE_NAME, contentValues, ID+" = ?", new String[]{id});
        return true;
    }

    public int deleteData(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        // je row return return korbe tar ID return korbe nicher line ta...otherwise return korbe 0
        return db.delete(TABLE_NAME, ID+" = ?", new String[]{id});
    }
}


