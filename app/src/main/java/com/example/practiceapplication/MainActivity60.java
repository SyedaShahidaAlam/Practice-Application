
/////////// Creating table and database (SQLite Database) (Part_1) & (Part_2) (126 & 127 video)
/////////// Inserting data in SQLite (130 video)
/////////// Read data from SQLite (part_1) & (Part_2) (131 & 132 video)
/////////// Update data from SQLite (133 video)
/////////// Delete data from SQLite (134 video)


/////////// Main code

//package com.example.practiceapplication;
//
//import android.os.Bundle;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class MainActivity60 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main60);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}




/////////// Creating table and database (SQLite Database) (Part_1) & (Part_2) (126 & 127 video)
/////////// Inserting data in SQLite (130 video)
/////////// Read data from SQLite (part_1) & (Part_2) (131 & 132 video)
/////////// Update data from SQLite (133 video)
/////////// Delete data from SQLite (134 video)

package com.example.practiceapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity60 extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText, ageEditText, genderEditText, idEditText;
    private Button addButton, displayButton, updateButton, deleteButton;

    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main60);

        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();

        nameEditText = findViewById(R.id.etId1);
        ageEditText = findViewById(R.id.etId2);
        genderEditText = findViewById(R.id.etId3);
        idEditText = findViewById(R.id.etId4);

        addButton = findViewById(R.id.btnId);
        displayButton = findViewById(R.id.btnId2);
        updateButton = findViewById(R.id.btnId3);
        deleteButton = findViewById(R.id.btnId4);


        addButton.setOnClickListener(this);
        displayButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();
        String id = idEditText.getText().toString();

        if(v.getId() == R.id.btnId)
        {
            // Variable guloke MyDatabaseHelper e pathiyechi
            // insertData MyDatabaseHelper er method...tai ekhane myDatabaseHelper use korechi
            // MyDatabaseHelper er insertData method er rowId receive korechi
            long rowId = myDatabaseHelper.insertData(name, age, gender);

            if(rowId == -1)
            {
                Toast.makeText(this, "Unsuccessful", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Row "+rowId+" is successfully inserted", Toast.LENGTH_SHORT).show();
            }
        }

        if(v.getId() == R.id.btnId2)
        {
            Cursor cursor = myDatabaseHelper.displayAllData();

            // getCount method table er number of row count kore
            // cursor.getCount() == 0 mane jodi row sonkkha 0 hoy....orthath kunu data na takhe
            if(cursor.getCount() == 0)
            {
                showData("Error","No data Found");
                return;
            }

            // stringBuffer er moddhe shob gulo data eksathe rekhe debo....then eigulo ke display korbo
            StringBuffer stringBuffer = new StringBuffer();

            // eikhane cursor check korbe she je row te ache tar porobortite kunu row ache ki na
            while (cursor.moveToNext())
            {
                stringBuffer.append("ID : " + cursor.getString(0) + "\n");
                stringBuffer.append("Name : " + cursor.getString(1) + "\n");
                stringBuffer.append("Age : " + cursor.getString(2) + "\n");
                stringBuffer.append("Gender : " + cursor.getString(3) + "\n\n\n");
            }

            // showData() method string buffer er data ke display korbe
            showData("Resultset",stringBuffer.toString());
        }

        if (v.getId() == R.id.btnId3)
        {
            // ID holo unique key...ei ID er upor depend kore update kora hoy
            Boolean isUpdated = myDatabaseHelper.updateData(id, name, age, gender);

            if(isUpdated == true)
            {
                Toast.makeText(this, "Data is updated", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Data is not updated", Toast.LENGTH_SHORT).show();
            }
        }

        if (v.getId() == R.id.btnId4)
        {
            int value = myDatabaseHelper.deleteData(id);

            if(value > 0)
            {
                Toast.makeText(this, "Data is deleted", Toast.LENGTH_SHORT).show();
            }

            else
            {
                Toast.makeText(this, "Data is not deleted", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showData(String title, String message)
    {
        // AlertDialog is used for print result
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }
}


