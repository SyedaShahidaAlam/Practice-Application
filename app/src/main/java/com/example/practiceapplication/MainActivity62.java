
///////////// Sign in & Sign up code in android  (SQLite Database) (Part_3) (137 video)
///////////// Sign in & Sign up code in android  (SQLite Database) (Part_4) (138 video)

//////////// Eita Sign up er code

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
//public class MainActivity62 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main62);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}




///////////// Sign in & Sign up code in android  (SQLite Database) (Part_3) (137 video)
///////////// Sign in & Sign up code in android  (SQLite Database) (Part_4) (138 video)

//////////// Eita Sign up er code

package com.example.practiceapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity62 extends AppCompatActivity implements View.OnClickListener {

    EditText SignUpNameEditText, SignUpEmailEditText, SignUpUsernameEditText, SignUpPasswordEditText;
    Button SignUpBtnId;
    UserDetails userDetails;

    MyDatabaseHelper2 myDatabaseHelper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main62);

        SignUpNameEditText = findViewById(R.id.signupNameEtId);
        SignUpEmailEditText = findViewById(R.id.signupEmailEtId);
        SignUpUsernameEditText = findViewById(R.id.signupUsernameEtId);
        SignUpPasswordEditText = findViewById(R.id.signupPasswordEtId);

        SignUpBtnId = findViewById(R.id.signupBtnId);

        // User theke pawa data gulo database e store korechi
        userDetails = new UserDetails();

        // initialize insert method
        myDatabaseHelper2 = new MyDatabaseHelper2(this);

        SignUpBtnId.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        String SUname = SignUpNameEditText.getText().toString();
        String SUemail = SignUpEmailEditText.getText().toString();
        String SUusername = SignUpUsernameEditText.getText().toString();
        String SUpassword = SignUpPasswordEditText.getText().toString();

        // Databage er maddhome directly value set korbo na eikhane
        // UserDetails name e arekti class create kore tar maddhome value set kore get korbo

        // userDetails e data set korechi
        userDetails.setName(SUname);
        userDetails.setEmail(SUemail);
        userDetails.setUsername(SUusername);
        userDetails.setPassword(SUpassword);

        // User theke pawa data gulo database e store korechi
        long rowId = myDatabaseHelper2.insertData(userDetails);

        // check korechi data insert hoyeche ki na
        if(rowId > 0)
        {
            Toast.makeText(this, "Row " +rowId+ "is successfully inserted", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Row insertion failed", Toast.LENGTH_SHORT).show();
        }
    }
}


