package com.example.user.mediaplayerexample;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    boolean play1=false,play=false;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button=(Button)this.findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        play=true;
        mediaPlayer=new MediaPlayer();
        String path= Environment.getExternalStorageDirectory().getPath()+"/abc.mp3";
        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(mediaPlayer.isPlaying()){
            button.setEnabled(false);
            button.setText("media playing");

        }
        else{

            button.setEnabled(true);
            button.setText("start media");
        }

    }
}
