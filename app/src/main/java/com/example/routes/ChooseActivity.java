package com.example.routes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ArrayAdapter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChooseActivity extends AppCompatActivity implements View.OnClickListener {


    private String[] locations = {"Railways", "NgongRoad", "Kawangware",
            "Kikuyu","Odeon","Westlands","Chiromo","Kangemi","Kinoo","Regen","Kikuyu",
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
        switch (v.getId()) {

            case R.id.search_stage:

                Intent mapIntent = new Intent(ChooseActivity.this, MapActivity.class);
                startActivity(mapIntent);



                break;
        }
    }


    private void downloadJSON(final String urlWebService) {

        @SuppressLint("StaticFieldLeak")
        class DownloadJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json).append("\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        DownloadJSON getJSON = new DownloadJSON();
        getJSON.execute();
    }

    private void loadIntoListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        String[] stocks = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            stocks[i] = obj.getString("name") + " " + obj.getString("price");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stocks);
        setdestination.setAdapter(arrayAdapter);
        setstart.setAdapter(arrayAdapter);

    }
}
