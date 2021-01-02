package com.sakibnoman.guesspower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MusicActivity extends AppCompatActivity {

    MediaPlayer relaxPlayer;
    ImageView imageView;
    SeekBar audioSeekbar,volumeSeekbar;
    AudioManager relaxManager;
    Button playMusic,stopMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        try{
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        relaxPlayer = MediaPlayer.create(this, R.raw.aud);

        imageView = findViewById(R.id.musIcon);
        audioSeekbar = findViewById(R.id.audioSeekbar);
        volumeSeekbar = findViewById(R.id.volumeSeekbar);
        playMusic = findViewById(R.id.playMusicbtn);
        stopMusic = findViewById(R.id.stopMusicbtn);

        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relaxPlayer.start();
                imageView.animate().rotation(12960f).setDuration(180000);
            }
        });
        stopMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relaxPlayer.pause();
                imageView.animate().rotation(360f).setDuration(500);
            }
        });

        relaxManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = relaxManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currVolume = relaxManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        volumeSeekbar.setMax(maxVolume);
        volumeSeekbar.setProgress(currVolume);
        volumeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                relaxManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        audioSeekbar.setMax(relaxPlayer.getDuration());
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                    audioSeekbar.setProgress(relaxPlayer.getCurrentPosition());
            }
        },0,100);

//        audioSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                relaxPlayer.seekTo(progress);
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });

    }
//        public void playMusic (View view){
//            relaxPlayer.start();
//            imageView.animate().rotation(12960f).setDuration(180000);
//        }
//
//        public void stopMusic (View view){
//            relaxPlayer.pause();
//            imageView.animate().rotation(360f).setDuration(500);
//        }

        public void watchVideo (View view){
            Intent gotoActivity = new Intent(MusicActivity.this, VideoPlayer.class);
            startActivity(gotoActivity);
        }


}