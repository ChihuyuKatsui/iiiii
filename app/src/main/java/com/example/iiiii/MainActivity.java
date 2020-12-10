package com.example.iiiii;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iiiii.service.SoundService;


public class MainActivity extends AppCompatActivity {

    Button button;
    SoundService soundServiceInstance;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.stopBtn);
        //↓ここなければ一応動く
        soundServiceInstance = new SoundService(this);
//        soundServiceInstance.execute();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundServiceInstance.execute();
            }
        });
    }
}

