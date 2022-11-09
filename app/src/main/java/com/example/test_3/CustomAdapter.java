package com.example.test_3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Visitor> {

    private final int resourceLayout;
    private final Context ctx;

    public CustomAdapter(Context context, Integer resource, ArrayList<Visitor> visitors) {
        super(context, resource, visitors);
        this.resourceLayout = resource;
        this.ctx = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Visitor visitor = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(ctx);
            convertView = vi.inflate(resourceLayout, null);
        }


        // Lookup view for data population
        TextView tvNameSurname = (TextView) convertView.findViewById(R.id.name);
        TextView tvHeight;
        TextView tvWeight;
        TextView tvYear;
        TextView tvAge;

        tvNameSurname.setText(visitor.name + " " + visitor.surname);

        switch (resourceLayout){
            case (R.layout.listview_item_mode_1):
                tvHeight = (TextView) convertView.findViewById(R.id.height);
                tvWeight = (TextView) convertView.findViewById(R.id.weight);
                tvYear = (TextView) convertView.findViewById(R.id.year);
                tvAge = (TextView) convertView.findViewById(R.id.age);

                // Populate the data into the template view using the data object
                tvHeight.setText("Height: " + visitor.height.toString() + " cm");
                tvWeight.setText("Weight: " + visitor.weight.toString() + " kg");
                tvYear.setText("Year of birth: " + visitor.year.toString());
                tvAge.setText("Age: " + visitor.age.toString());
                break;

            case (R.layout.listview_item_mode_2):
                tvAge = (TextView) convertView.findViewById(R.id.age);
                tvAge.setText("Age: " + visitor.age.toString());
                break;

            case (R.layout.listview_item_mode_3):
                tvWeight = (TextView) convertView.findViewById(R.id.weight);
                tvWeight.setText("Weight: " + visitor.weight.toString() + "kg");
        }




        // Return the completed view to render on screen
        return convertView;
    }

}
