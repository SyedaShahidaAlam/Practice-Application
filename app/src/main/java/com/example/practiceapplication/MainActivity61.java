
///////////// Sign in & Sign up code in android  (SQLite Database) (Part_1) & (Part_2) (135 & 136 video)

//////////// Eita MainActivity er code

//////////// MainActivity62 holo sign up er code

//////////// MainActivity63 holo sign in er code

///////////// Main code

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
//public class MainActivity61 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main61);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}



///////////// Sign in & Sign up code in android  (SQLite Database) (Part_1) & (Part_2) (135 & 136 video)

//////////// Eita MainActivity er code

//////////// MainActivity62 holo sign up er code

//////////// MainActivity63 holo sign in er code

package com.example.practiceapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity61 extends AppCompatActivity implements View.OnClickListener {

    MyDatabaseHelper2 myDatabaseHelper2;

    private EditText SigninUsernameEditText, SigninPasswordEditText;
    private Button SignInButton, SignUpHereButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main61);

        myDatabaseHelper2 = new MyDatabaseHelper2(this);
        SQLiteDatabase db = myDatabaseHelper2.getWritableDatabase();

        SigninUsernameEditText = findViewById(R.id.signinUsernameEtId);
        SigninPasswordEditText = findViewById(R.id.signinPasswordEtId);

        SignInButton = findViewById(R.id.signinBtnId);
        SignUpHereButton = findViewById(R.id.signupHereBtnId);

        SignInButton.setOnClickListener(this);
        SignUpHereButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        String SIusername = SigninUsernameEditText.getText().toString();
        String SIpassword = SigninPasswordEditText.getText().toString();

        if(v.getId() == R.id.signinBtnId)
        {
            // myDatabaseHelper2 er maddhome ekta method call
            Boolean result = myDatabaseHelper2.findPassword(SIusername,SIpassword);

            if(result == true)
            {
                Intent intent = new Intent(MainActivity61.this, MainActivity63.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "username and password didn't match", Toast.LENGTH_SHORT).show();
            }
        }

        else if(v.getId() == R.id.signupHereBtnId)
        {
            Intent intent = new Intent(MainActivity61.this, MainActivity62.class);
            startActivity(intent);
        }
    }
}



