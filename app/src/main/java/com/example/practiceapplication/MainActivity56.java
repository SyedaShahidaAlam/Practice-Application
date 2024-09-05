
//////////// Scroll tabs android (Part_1)

//////////// Main code

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
//public class MainActivity56 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main56);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}



//////////// Scroll tabs android (Part_1)

package com.example.practiceapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MainActivity56 extends FragmentActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main56);

        viewPager = findViewById(R.id.pagerId);
        FragmentManager fragmentManager = getSupportFragmentManager();
        ScrollAdapter scrollAdapter = new ScrollAdapter(fragmentManager);
        viewPager.setAdapter(scrollAdapter);
    }
}

class ScrollAdapter extends FragmentStatePagerAdapter
{

    public ScrollAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = null;

        if(position == 0)
        {
            fragment = new FragmentOne();
        }

        else if(position == 1)
        {
            fragment = new FragmentTwo();
        }

        else if(position == 2)
        {
            fragment = new FragmentThree();
        }

        return null;
    }

    @Override
    public int getCount()
    {
        return 3;
    }

    public CharSequence getPageTitle(int position)
    {
        if(position == 0)
        {
            return "Tab1";
        }

        if(position == 1)
        {
            return "Tab2";
        }

        if(position == 2)
        {
            return "Tab3";
        }

        return null;
    }
}


