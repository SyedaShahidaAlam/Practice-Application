
//////////// CountryProfile Project (Part_1)

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
//public class MainActivity21 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main21);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}



/////////////// CountryProfile Project (Part_1)

package com.example.practiceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity21 extends AppCompatActivity implements View.OnClickListener {

    private Button bangladeshbtn, indiabtn, pakistanbtn;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main21);

        bangladeshbtn = findViewById(R.id.bngbtnId);
        indiabtn = findViewById(R.id.indbtnId);
        pakistanbtn = findViewById(R.id.pakbtnId);

        bangladeshbtn.setOnClickListener(this);
        indiabtn.setOnClickListener(this);
        pakistanbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {

        if(v.getId() == R.id.bngbtnId)
        {
            intent = new Intent(MainActivity21.this, MainActivity22.class);
            intent.putExtra("name","Bangladesh");
            startActivity(intent);
        }

        if(v.getId() == R.id.indbtnId)
        {
            intent = new Intent(MainActivity21.this, MainActivity22.class);
            intent.putExtra("name","India");
            startActivity(intent);
        }

        if(v.getId() == R.id.pakbtnId)
        {
            intent = new Intent(MainActivity21.this, MainActivity22.class);
            intent.putExtra("name","Pakistan");
            startActivity(intent);
        }
    }
}


