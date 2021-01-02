package com.sakibnoman.guesspower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
    }

    public void gotoGameActivity(View view) {

        Intent gotoActivity = new Intent(MainActivity.this,GameActivity.class);
                startActivity(gotoActivity);
    }

    public void gotoMusicActivity(View view) {
        Intent gotoActivity = new Intent(MainActivity.this,MusicActivity.class);
            startActivity(gotoActivity);
    }
}