package com.example.test_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VisitorList extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    CustomAdapter adapter1;
    CustomAdapter adapter2;
    CustomAdapter adapter3;
    List<Visitor> visitorList;
    ListView visitorslst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_list);

        visitorslst = findViewById(R.id.visitors);
        Intent _intent = getIntent();
        visitorList = (List<Visitor>) _intent.getSerializableExtra("data");
        radioGroup = findViewById(R.id.radioGroup);

        adapter1 = new CustomAdapter((Context) this, R.layout.listview_item_mode_1, (ArrayList<Visitor>) visitorList);
        adapter2 = new CustomAdapter((Context) this, R.layout.listview_item_mode_2, (ArrayList<Visitor>) visitorList);
        adapter3 = new CustomAdapter((Context) this, R.layout.listview_item_mode_3, (ArrayList<Visitor>) visitorList);

        visitorslst.setAdapter(adapter1);

    }

    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        Log.d("id", String.valueOf(radioId));
        Log.d("id", String.valueOf(R.id.radio_one));
        Log.d("id", String.valueOf(R.id.radio_two));
        Log.d("id", String.valueOf(R.id.radio_three));
        radioButton = findViewById(radioId);

        switch (radioId){
            case (R.id.radio_two):
                visitorslst.setAdapter(adapter2);
                break;
            case (R.id.radio_three):
                visitorslst.setAdapter(adapter3);
                break;
            default:
                visitorslst.setAdapter(adapter1);
                break;
        }

        Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(),
                        Toast.LENGTH_SHORT).show();
    }

}