package com.example.iiiii;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

import com.example.iiiii.service.SoundService;


public class MainActivity extends AppCompatActivity {

    Button button;
    SoundService soundServiceInstance;
    public ProgressDialog mDialog;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.stopBtn);
        //↓ここなければ一応動く
        mDialog = new ProgressDialog(this);
        soundServiceInstance = new SoundService(this, mDialog);
        soundServiceInstance.execute();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundServiceInstance.cancel(true);
            }
        });
    }
}

