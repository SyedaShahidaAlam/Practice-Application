
///////////// EditText code

/////////////// Main code

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
//public class MainActivity2 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main2);
//
//
//
//    }
//}





/////////// With implements OnclickListener

package com.example.practiceapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1, editText2;
    private Button button1, button2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        editText1 = findViewById(R.id.edittext_1ID);
        editText2 = findViewById(R.id.edittext_2ID);
        button1 = findViewById(R.id.btnaddID);
        button2 = findViewById(R.id.btnsubID);
        textView = findViewById(R.id.ETtextviewID);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try{
            String num1 = editText1.getText().toString();
            String num2 = editText2.getText().toString();

            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);

            if(v.getId() == R.id.btnaddID){
                double sum = n1 + n2;
                textView.setText("Result = " + sum);
            }
            else if(v.getId() == R.id.btnsubID){
                double sub = n1 - n2;
                textView.setText("Result = " + sub);
            }

        }catch(Exception e){
            Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }
    }
}


