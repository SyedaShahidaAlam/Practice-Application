
//////////// CountryProfile Project (Part_2)

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
//public class MainActivity22 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main22);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}



//////////// CountryProfile Project (Part_2)

package com.example.practiceapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity22 extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main22);

        imageView = findViewById(R.id.imgId);
        textView = findViewById(R.id.txtId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null)
        {
            String countryName = bundle.getString("name");
            showDetails(countryName);
        }

    }

    void showDetails(String countryName)
    {
        if(countryName.equals("Bangladesh"))
        {
            imageView.setImageResource(R.drawable.gov_bng);
            textView.setText(R.string.info_bd);
        }

        if(countryName.equals("India"))
        {
            imageView.setImageResource(R.drawable.park_ind);
            textView.setText(R.string.info_ind);
        }

        if(countryName.equals("Pakistan"))
        {
            imageView.setImageResource(R.drawable.park_pak);
            textView.setText(R.string.info_pak);
        }
    }
}


