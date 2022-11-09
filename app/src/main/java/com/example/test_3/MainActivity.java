package com.example.test_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public boolean checkEmpty(EditText edit){
        if (edit.getText().toString().matches("")) {
            Toast.makeText(this, "You did not fill " + edit.getHint() + " field", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    List<Visitor> visitorList = new ArrayList<>();

    EditText name;
    EditText surname;
    EditText height;
    EditText weight;
    EditText year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.personName);
        surname = (EditText) findViewById(R.id.personSurname);
        height = (EditText) findViewById(R.id.personHeight);
        weight = (EditText) findViewById(R.id.personWeight);
        year = (EditText) findViewById(R.id.year);

        Button add_btn = (Button) findViewById(R.id.addvisitor_btn);
        Button disp = (Button) findViewById(R.id.displayvisitors_btn);

        add_btn.setOnClickListener(v -> {

            if (checkEmpty(name)){
                return;
            }
            else if (checkEmpty(surname)){
                return;
            }
            else if (checkEmpty(height)){
                return;
            }
            else if (checkEmpty(weight)){
                return;
            }
            else if (checkEmpty(year)){
                return;
            }

            visitorList.add(new Visitor(name.getText().toString(),
                                        surname.getText().toString(),
                                        Double.parseDouble(height.getText().toString()),
                                        Double.parseDouble(weight.getText().toString()),
                                        Integer.parseInt(year.getText().toString())));

            name.setText("");
            surname.setText("");
            height.setText("");
            weight.setText("");
            year.setText("");


        });

        disp.setOnClickListener(v -> {

            Intent vlistIntent = new Intent(MainActivity.this, VisitorList.class);
            vlistIntent.putExtra("data", (Serializable) visitorList);
            MainActivity.this.startActivity(vlistIntent);

        });




    }
}