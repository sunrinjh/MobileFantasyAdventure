package com.example.mobilefantasyadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.PhantomReference;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
        AssetManager assetManager;
        Context context;
        int randomBound;
        int engRandomBound;
        TextView textView;
        Switch engSwitch;
        RadioGroup radioGroup;
        ImageView imageView;
        boolean isEng = false;
        int easterEggCounter = 0;
        int easterEggIndex[] = {1,2,1,0,1,2};
        boolean zzfzzMode = false;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            setTheme(R.style.AppTheme);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            context = getApplicationContext();
            assetManager = context.getAssets();
            setPhrase();
            randomBound = Phrase.getStringArrayList().size();
            setEnglishPhrase();
            engRandomBound = EnglishPhrase.getStringArrayList().size();
            SoundPlayer.initSound(context);
            findViewById(R.id.zzrzzbutton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!isEng && radioGroup.getCheckedRadioButtonId() == R.id.leftRadioButton){
                        SoundPlayer.playSound(context, R.raw.zzrzz);
                    }
                }
            });
            findViewById(R.id.view).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    refillPhrase();
                }
            });
            textView = findViewById(R.id.text);
            imageView = findViewById(R.id.imageView);
            radioGroup = findViewById(R.id.RadioGroup);
            radioGroup.check(R.id.leftRadioButton);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if(easterEggIndex[easterEggCounter] == checkedId){
                        easterEggCounter++;
                    }
                    if(easterEggCounter > 6){
                        zzfzzMode=true;
                    }
                    System.out.println(checkedId);
                    if(!isEng){
                        switch (checkedId){
                            case R.id.leftRadioButton: //찬구
                                imageView.setImageResource(R.drawable.changuillust);
                                break;
                            case R.id.middleRadioButton: //리춘희
                                imageView.setImageResource(R.drawable.chunillust);
                                break;
                            case R.id.rightRadioButton: // 영길
                                imageView.setImageResource(R.drawable.yeonggilillust);
                                break;

                        }
                    }
                    else {
                        switch (checkedId){
                            case R.id.leftRadioButton: //Kamila
                                imageView.setImageResource(R.drawable.kamilaillust);
                                break;
                            case R.id.middleRadioButton: //Juila
                                imageView.setImageResource(R.drawable.juliaillust);
                                break;
                            case R.id.rightRadioButton: // Trump
                                imageView.setImageResource(R.drawable.trumpillust);
                                break;
                        }
                    }

                }
            });
            engSwitch = findViewById(R.id.engSwitch);
            engSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(!isChecked){
                        //
                        isEng = false;
                        ((RadioButton)radioGroup.getChildAt(0)).setText("찬구");
                        ((RadioButton)radioGroup.getChildAt(1)).setText("리춘희");
                        ((RadioButton)radioGroup.getChildAt(2)).setText("영길");
                        switch (radioGroup.getCheckedRadioButtonId()){
                            case R.id.leftRadioButton: //찬구
                                imageView.setImageResource(R.drawable.changuillust);
                                break;
                            case R.id.middleRadioButton: //리춘희
                                imageView.setImageResource(R.drawable.chunillust);
                                break;
                            case R.id.rightRadioButton: // 영길
                                imageView.setImageResource(R.drawable.yeonggilillust);
                                break;
                        }
                    }
                    else {
                        //
                        isEng = true;
                        ((RadioButton)radioGroup.getChildAt(0)).setText("Kamila");
                        ((RadioButton)radioGroup.getChildAt(1)).setText("Juila");
                        ((RadioButton)radioGroup.getChildAt(2)).setText("Trump");
                        switch (radioGroup.getCheckedRadioButtonId()){
                            case R.id.leftRadioButton: //Kamila
                                imageView.setImageResource(R.drawable.kamilaillust);
                                break;
                            case R.id.middleRadioButton: //Juila
                                imageView.setImageResource(R.drawable.juliaillust);
                                break;
                            case R.id.rightRadioButton: // Trump
                                imageView.setImageResource(R.drawable.trumpillust);
                                break;
                        }
                    }
                }
            });
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            SoundPlayer.releaseSound(context);
        }

        public void refillPhrase(){

            int radioButtonId = radioGroup.getCheckedRadioButtonId();
            Random random = new Random();
            if (!isEng) {

                int randInt = random.nextInt(randomBound);
                switch (radioButtonId) {
                    case R.id.leftRadioButton:
                        SoundPlayer.playSound(context, Phrase.getIntegerArrayList_Changu().get(randInt));
                        break;
                    case R.id.middleRadioButton:
                        SoundPlayer.playSound(context, Phrase.getIntegerArrayList_Chun().get(randInt));
                        break;
                    case R.id.rightRadioButton:
                        SoundPlayer.playSound(context, Phrase.getIntegerArrayList_Moon().get(randInt));
                        break;
                }
                textView.setText(Phrase.getStringArrayList().get(randInt));
            }
            else{
                int randInt = random.nextInt(engRandomBound);
                switch (radioButtonId){
                    case R.id.leftRadioButton:
                        SoundPlayer.playSound(context, EnglishPhrase.getIntegerArrayList_Kamila().get(randInt));
                        break;
                    case R.id.middleRadioButton:
                        SoundPlayer.playSound(context, EnglishPhrase.getIntegerArrayList_Julia().get(randInt));
                        break;
                    case R.id.rightRadioButton:
                        SoundPlayer.playSound(context, EnglishPhrase.getIntegerArrayList_Trump().get(randInt));
                        break;
                }
                textView.setText(EnglishPhrase.getStringArrayList().get(randInt));
            }

        }
        private void setPhrase(){
            String jsonData = null;
            try{
                InputStream is = assetManager.open("phrase.json");

                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(isr);

                StringBuffer buffer = new StringBuffer();
                String line = reader.readLine();
                while(line!=null){
                    buffer.append(line+"\n");

                    line = reader.readLine();

                }
                jsonData = buffer.toString();

            } catch (IOException e) {
                e.printStackTrace();

            }
            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(jsonData);
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Phrase.addPhrase(jsonObject.getString("text"), jsonObject.getInt("0"), jsonObject.getInt("1"),jsonObject.getInt("2"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private void setEnglishPhrase(){
            String jsonData = null;
            try{
                InputStream is = assetManager.open("english_phrase.json");

                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(isr);

                StringBuffer buffer = new StringBuffer();
                String line = reader.readLine();
                while(line!=null){
                    buffer.append(line+"\n");

                    line = reader.readLine();

                }
                jsonData = buffer.toString();

            } catch (IOException e) {
                e.printStackTrace();

            }
            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(jsonData);
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    EnglishPhrase.addPhrase(jsonObject.getString("text"), jsonObject.getInt("0"), jsonObject.getInt("1"),jsonObject.getInt("2"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

}