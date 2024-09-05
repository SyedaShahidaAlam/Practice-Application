
/////////// CardView

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
//public class MainActivity59 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main59);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}





package com.example.practiceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity59 extends AppCompatActivity implements View.OnClickListener {

    private CardView schoolcardView, hospitalcardView, restaurantcardView, airportcardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main59);

        schoolcardView = findViewById(R.id.schoolId);
        hospitalcardView = findViewById(R.id.hospitalId);
        restaurantcardView = findViewById(R.id.restaurantId);
        airportcardView = findViewById(R.id.airportId);

        schoolcardView.setOnClickListener(this);
        hospitalcardView.setOnClickListener(this);
        restaurantcardView.setOnClickListener(this);
        airportcardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.schoolId)
        {
            Intent intent = new Intent(MainActivity59.this,SchoolActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.hospitalId)
        {
            Intent intent = new Intent(MainActivity59.this,HospitalActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.restaurantId)
        {
            Intent intent = new Intent(MainActivity59.this,RestaurantActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.airportId)
        {
            Intent intent = new Intent(MainActivity59.this,AirportActivity.class);
            startActivity(intent);
        }

    }
}



