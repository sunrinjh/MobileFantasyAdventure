package com.example.soundplayerexample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Random_Item> random_items=new ArrayList<>();



        random_items.add(new Random_Item("ㅋㅋ루삥뽕", R.raw.chan_gu));



        MySoundPlayer.initSounds(getApplicationContext());


        Random random = new Random();
        int randomValue = random.nextInt(random_items.size());
        findViewById(R.id.view).setOnClickListener((v)->{


            //MySoundPlayer.play();
        });

    }
}