
////////// TextView and Button code

//////////////Main code

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
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}





//////////// Find view from java

//package com.example.practiceapplication;
//
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class MainActivity extends AppCompatActivity {
//
//    private TextView textviewName;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//
//        textviewName = findViewById(R.id.textview_nameID);
//
//        textviewName.setText("JUHA");
//    }
//}




/////////// Button with listener

//package com.example.practiceapplication;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class MainActivity extends AppCompatActivity {
//
//    int count1 = 0;
//    int count2 = 0;
//    private TextView textviewName;
//    private Button loginbuttonName,logoutbuttonName;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//
//        textviewName = findViewById(R.id.textview_nameID);
//        loginbuttonName = findViewById(R.id.loginbutton_nameID);
//        logoutbuttonName = findViewById(R.id.logoutbutton_nameID);
//
//        textviewName.setText("JUHA");
//
//        loginbuttonName.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                //loginbuttonName.setText("Login button clicked");
//                count1++;
//                Toast.makeText(MainActivity.this, "Login button clicked "+count1+" times", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        logoutbuttonName.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                //logoutbuttonName.setText("Logout button clicked");
//                count2++;
//                Toast.makeText(MainActivity.this, "Logout button clicked "+count2+" times", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
//
//}





/////////////// Button with listener using implements

//package com.example.practiceapplication;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
//    private TextView textviewName;
//    private Button loginbuttonName,logoutbuttonName;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//
//        textviewName = findViewById(R.id.textview_nameID);
//        loginbuttonName = findViewById(R.id.loginbutton_nameID);
//        logoutbuttonName = findViewById(R.id.logoutbutton_nameID);
//
//        textviewName.setText("JUHA");
//
//        loginbuttonName.setOnClickListener(this);
//        logoutbuttonName.setOnClickListener(this);
//
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        if(v.getId() == R.id.loginbutton_nameID)
//        {
//            Toast.makeText(this, "Login button clicked", Toast.LENGTH_SHORT).show();
//        }
//        if(v.getId() == R.id.logoutbutton_nameID)
//        {
//            Toast.makeText(this, "Logout button clicked", Toast.LENGTH_SHORT).show();
//        }
//
//    }
//}






///////////// Button with listener with inner class method

//package com.example.practiceapplication;
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class MainActivity extends AppCompatActivity{
//
//    private TextView textviewName;
//    private Button loginbuttonName,logoutbuttonName;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//
//        textviewName = findViewById(R.id.textview_nameID);
//        loginbuttonName = findViewById(R.id.loginbutton_nameID);
//        logoutbuttonName = findViewById(R.id.logoutbutton_nameID);
//
//        textviewName.setText("JUHA");
//
//        Handler handler = new Handler();
//
//        loginbuttonName.setOnClickListener(handler);
//        logoutbuttonName.setOnClickListener(handler);
//
//    }
//
//    class Handler implements View.OnClickListener
//    {
//
//        @Override
//        public void onClick(View v) {
//
//            if(v.getId() == R.id.loginbutton_nameID)
//            {
//                Toast.makeText(MainActivity.this, "Login button clicked", Toast.LENGTH_SHORT).show();
//            }
//            if(v.getId() == R.id.logoutbutton_nameID)
//            {
//                Toast.makeText(MainActivity.this, "Logout button clicked", Toast.LENGTH_SHORT).show();
//            }
//
//        }
//    }
//
//}






///////////////// Button with listener using xml

package com.example.practiceapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    private TextView textviewName;
    private Button loginbuttonName,logoutbuttonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textviewName = findViewById(R.id.textview_nameID);
        loginbuttonName = findViewById(R.id.loginbutton_nameID);
        logoutbuttonName = findViewById(R.id.logoutbutton_nameID);

        textviewName.setText("JUHA");

    }

    public void showmessage(View v)
    {
        if(v.getId() == R.id.loginbutton_nameID)
        {
            Toast.makeText(MainActivity.this, "Login button clicked", Toast.LENGTH_SHORT).show();
        }
        if(v.getId() == R.id.logoutbutton_nameID)
        {
            Toast.makeText(MainActivity.this, "Logout button clicked", Toast.LENGTH_SHORT).show();
        }
    }

}


