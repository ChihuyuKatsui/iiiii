package com.example.iiiii.service;

//import android.app.IntentService;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.AsyncTask;
import com.example.iiiii.R;


import java.util.Random;


public class SoundService extends AsyncTask<Integer, Integer, Integer> {
    Random r = new Random();
    private int r1;
    private int sound[] = new int[5];
    private Context context;
    private SoundPool soundPool;

    public SoundService(Context context){
        super();
        this.context = context;
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);

        sound[0] = soundPool.load(context,R.raw.one, 1);
        sound[1] = soundPool.load(context, R.raw.two, 1);
        sound[2] = soundPool.load(context, R.raw.three, 1);
        sound[3] = soundPool.load(context, R.raw.four, 1);
//        sound[4] = soundPool.load(context, R.raw.sound5, 1);
    }

    @Override
    protected Integer doInBackground(Integer... params) {

        soundPool.play(sound[0], 1.0f, 1.0f, 0, 0, 1.0f);
        try {
            Thread.sleep(500);
            soundPool.play(sound[0], 1.0f, 1.0f, 0, 0, 1.0f);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0; i<5; i++){
            r1 = r.nextInt(4);
            switch (r1){
                case 0:
                    soundPool.play(sound[0], 1.0f, 1.0f, 0, 0, 1.0f);
                    break;
                case 1:
                    soundPool.play(sound[1], 1.0f, 1.0f, 0, 0, 1.0f);
                    break;
                case 2:
                    soundPool.play(sound[2], 1.0f, 1.0f, 0, 0, 1.0f);
                    break;
                case 3:
                    soundPool.play(sound[3], 1.0f, 1.0f, 0, 0, 1.0f);
                    break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

}
