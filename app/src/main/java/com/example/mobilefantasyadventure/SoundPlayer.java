package com.example.mobilefantasyadventure;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;

import java.util.HashMap;

public class SoundPlayer {
    private static SoundPool soundPool;
    private static int soundID = 0;
    public static void initSound(Context context){
        AudioAttributes attributes = null;

        attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();
        soundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
    }
    public static void playSound(Context context, Integer integer){
        if(soundID!=0){
            soundPool.release();
        }
        final int soundID = soundPool.load(context, integer, 1);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                soundPool.play(soundID,1,1,1,0,1f);
            }
        });
    }
}
