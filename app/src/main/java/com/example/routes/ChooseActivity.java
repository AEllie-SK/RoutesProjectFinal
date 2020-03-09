package com.example.routes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

public class ChooseActivity extends AppCompatActivity implements View.OnClickListener {


    private String[] locations = {"Railways", "NgongRoad", "Kawangware",
            "Kikuyu","Odeon","Westlands","Chiromo","Kangemi","Kinoo","Regen",
            "Magu","Kingeero", "Kaka","Limuru","Koja","Kabete","Wangige",
            "Ngara","Town","Peponi Road","Spring Valley","ISK","MP Shah",
            "Nation Building","Museum Hill","Graffins College","Bypass",
            "Methodist Guesthouse","Yaya","ABC Place","Lavington","Gathiga","Othaya Road"};

    private AppCompatAutoCompleteTextView setstart;
    private AppCompatAutoCompleteTextView setdestination;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_activity);


        setstart = findViewById(R.id.set_start);
        setdestination= findViewById(R.id.set_destination);

        Button btnSearch = findViewById(R.id.search_stage);

        btnSearch.setOnClickListener(this);


        ArrayAdapter<String> startadapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, locations);
        setstart.setThreshold(1); //will start working from first character
        setstart.setAdapter(startadapter);

        ArrayAdapter<String> destinationadapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, locations);
        setdestination.setThreshold(1); //will start working from first character
        setdestination.setAdapter(destinationadapter);






    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.search_stage) {
            Intent mapIntent = new Intent(ChooseActivity.this, MapActivity.class);
            startActivity(mapIntent);

            String destination = setdestination.getText().toString().trim();

            SharedPreferences ui = getSharedPreferences("UserInfo", MODE_PRIVATE);
            SharedPreferences.Editor edUi = ui.edit();
            edUi.putString("KEY_DEST", destination);
            edUi.apply();

            Log.d("DESTINATION:", destination);
        }
    }



}
