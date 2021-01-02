package com.sakibnoman.guesspower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listviewactivity extends AppCompatActivity {

    private ListView listView;
    String[] playerlist = {"Sakib","Noman","Sazzad","Minhaz","Junaid","Riduan","Parvez","Saad","Fahim","Belal","Rafi","Hasnain","Jubair","Razib","Fahid","Furkan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewactivity);

        try{
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        listView =  findViewById(R.id.listViewID);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.samplelistview,R.id.textViewID,playerlist);
        listView.setAdapter(adapter);


    }
}