package com.example.mobilefantasyadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Context context;
    int randomBound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        setPhrase();
        randomBound = Phrase.getStringArrayList().size()-1;
        SoundPlayer.initSound(context);

        findViewById(R.id.view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refillPhrase();
            }
        });
    }
    public void refillPhrase(){
        Random random = new Random();
        int randInt = random.nextInt(randomBound);
        SoundPlayer.playSound(context,Phrase.getIntegerArrayList_Changu().get(randInt));
    }
    private void setPhrase(){
        Phrase.addPhrase("everydownside", R.raw.changu_everydownsidecanbegoodside);
        Phrase.addPhrase("트위터는 인생의 낭비다", R.raw.changu_twitterisfuck);
    }

}