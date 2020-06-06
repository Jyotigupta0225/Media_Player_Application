package com.example.user.mediaplayerexample;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button3,button4,button;
    boolean play1=false,play=false;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button3=(Button)this.findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4=(Button)this.findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button=(Button)this.findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==button3){

            play=true;
            mediaPlayer=new MediaPlayer();
            String path= Environment.getExternalStorageDirectory().getPath()+"/abcjj.mp3";
            try {
                mediaPlayer.setDataSource(path);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (mediaPlayer.isPlaying()==false){
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setIcon(R.mipmap.ic_launcher_round);
                builder.setTitle("Android Alert Box");
                builder.setMessage("File Deleted By User");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
                //Toast.makeText(this, "sond deleted by user", Toast.LENGTH_SHORT).show();
            }
        }
        if(v==button4){
            if (play==true){
                mediaPlayer.stop();
                play=true;
            }
        }
        if (v==button){
            Intent intent=new Intent(this,Main2Activity.class);
            this.startActivity(intent);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(play==true){
            mediaPlayer.stop();}
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
