package com.sakibnoman.guesspower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {
    VideoView videoPlayer;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        try{
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        videoPlayer = findViewById(R.id.videoView);
        videoPlayer.setVideoPath("android.resource://"+getPackageName()+"/"+ R.raw.vid);
        MediaController relaxcontroller = new MediaController(this);
        relaxcontroller.setAnchorView(relaxcontroller);
        videoPlayer.setMediaController(relaxcontroller);
        btn = findViewById(R.id.playVideo1);

    }

    public void playVideo(View view) {
        videoPlayer.start();
        btn.animate().alpha(0f).setDuration(1000);
    }

}