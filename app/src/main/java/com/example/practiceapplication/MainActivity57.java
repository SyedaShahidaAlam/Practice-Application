
/////////// Create login application (Part_1)

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
//public class MainActivity57 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main57);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}



/////////// Create login application

package com.example.practiceapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity57 extends AppCompatActivity {

    private EditText usernameeditText, passeditText;
    private Button loginbutton;
    private TextView textView;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main57);

        usernameeditText = findViewById(R.id.etId1);
        passeditText = findViewById(R.id.etId2);
        loginbutton = findViewById(R.id.btnId);
        textView = findViewById(R.id.txtviewId);
        textView.setText("Number of attempt remaining : 3");

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernameeditText.getText().toString();
                String password = passeditText.getText().toString();

                if(username.equals("admin") && password.equals("1234"))
                {
                    Intent intent = new Intent(MainActivity57.this,MainActivity58.class);
                    startActivity(intent);
                }
                else
                {
                    counter--;
                    textView.setText("Number of attempt remaining : " + counter);
                    if(counter == 0)
                    {
                        loginbutton.setEnabled(false);
                    }
                }
            }
        });

    }
}



