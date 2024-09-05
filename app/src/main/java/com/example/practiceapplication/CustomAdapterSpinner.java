package com.example.practiceapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapterSpinner extends BaseAdapter {

    private String[] countryNames;
    private String[] population;
    int[] flags;
    Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapterSpinner(Context context,int[] flags,String[] countryNames,String[] population)
    {
        this.context = context;
        this.countryNames = countryNames;
        this.flags = flags;
        this.population = population;
    }


    @Override
    public int getCount()
    {
        return countryNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.spinner_listener_layout,null,false);
        }

        ImageView imageView = convertView.findViewById(R.id.imgviewId);
        imageView.setImageResource(flags[position]);

        TextView country = convertView.findViewById(R.id.countryId);
        country.setText(countryNames[position]);

        TextView populationNumber = convertView.findViewById(R.id.populationId);
        populationNumber.setText(population[position]);

        return convertView;
    }
}


