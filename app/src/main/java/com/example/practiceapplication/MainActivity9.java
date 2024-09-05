
/////////// DatePicker code

//////// Main code

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
//public class MainActivity9 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main9);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}





/////////// DatePicker code

package com.example.practiceapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity9 extends AppCompatActivity {

    private TextView textView;
    //private TextView textView2;
    private Button button;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main9);

        textView = findViewById(R.id.textviewid);
        //textView2 = findViewById(R.id.textview2id);
        button = findViewById(R.id.buttonid);
        datePicker = findViewById(R.id.datepickerID);

        //textView.setText(currentDate());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText(currentDate());
            }
        });
    }
    String currentDate()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Current Date : ");
        stringBuilder.append(datePicker.getDayOfMonth() + "/");
        stringBuilder.append((datePicker.getMonth() + 1) + "/"); // for start counting from 1
        stringBuilder.append(datePicker.getYear());

        return datePicker.toString();
    }
}


//android:text="Pick your date from here"
//android:textSize="20sp"
//android:textStyle="bold"
//android:layout_gravity="center_horizontal"
//android:layout_marginTop="25sp"
//android:padding="10dp"