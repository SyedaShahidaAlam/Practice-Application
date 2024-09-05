
///////////// Spinner with Listener

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
//public class MainActivity33 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main33);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}

//<item>Belgium</item>
//<item>Iraq</item>
//<item>Indonesia</item>
//<item>Papua New Guinea</item>
//<item>Denmark</item>

///////////// Spinner with Listener

package com.example.practiceapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity33 extends AppCompatActivity {

    private Spinner spinner;
    private String[] countryNames;
    private String[] population;
    private int[] flags = {R.drawable.bangladesh, R.drawable.india, R.drawable.bhutan, R.drawable.iran, R.drawable.pakistan, R.drawable.canada, R.drawable.palestine};

    private boolean isFirstSelection = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main33);

        countryNames = getResources().getStringArray(R.array.country_names);
        population = getResources().getStringArray(R.array.population);

        spinner = findViewById(R.id.spinnerId);

        CustomAdapterSpinner customAdapterSpinner = new CustomAdapterSpinner(this,flags,countryNames,population);
        spinner.setAdapter(customAdapterSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if(isFirstSelection == true)
                {
                    isFirstSelection = false;
                }
                else
                {
                    Toast.makeText(MainActivity33.this, countryNames[position]+"is selected", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

    }
}


