
/////////// CheckBox code

/////////// Main code

//package com.example.practiceapplication;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.TextView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class MainActivity3 extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main3);
//
//    }
//}






//////////// CheckBox code

package com.example.practiceapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private TextView textView1, textView2;
    private CheckBox checkBox1, checkBox2, checkBox3;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        textView1 = findViewById(R.id.textview1ID);
        textView2 = findViewById(R.id.textview2ID);
        checkBox1 = findViewById(R.id.checkbox1ID);
        checkBox2 = findViewById(R.id.checkbox2ID);
        checkBox3 = findViewById(R.id.checkbox3ID);
        button = findViewById(R.id.buttonID);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder stringBuilder = new StringBuilder();

                if(checkBox1.isChecked())
                {
                    String value1 = checkBox1.getText().toString();
                    stringBuilder.append(value1 + " is inserted" + "\n");
                }

                if(checkBox2.isChecked())
                {
                    String value2 = checkBox2.getText().toString();
                    stringBuilder.append(value2 + " is inserted" + "\n");
                }

                if(checkBox3.isChecked())
                {
                    String value3 = checkBox3.getText().toString();
                    stringBuilder.append(value3 + " is inserted");
                }

                textView2.setText(stringBuilder);
            }
        });
    }

}


