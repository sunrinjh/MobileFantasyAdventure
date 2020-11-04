package com.example.soundplayerexample;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MySoundPlayer {
    public static ArrayList<Integer> soundIDArrayList;

    private static SoundPool soundPool;
    private static HashMap<Integer, Integer> soundPoolMap;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void initSounds(Context context){
        AudioAttributes attributes = null;

        attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();

        soundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
        soundPoolMap = new HashMap(2);
        for(Integer i : soundIDArrayList){
            soundPoolMap.put(i, soundPool.load(context, i, 1));
        }


    }
    public static void play(int raw_id){
        if(soundPoolMap.containsKey(raw_id)){
            soundPool.play(soundPoolMap.get(raw_id),1,1,1,0,1f);
        }
    }
}
