package com.example.mobilefantasyadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

import java.lang.ref.PhantomReference;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
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
        setPhrase();
        randomBound = Phrase.getStringArrayList().size();
        setEnglishPhrase();
        engRandomBound = EnglishPhrase.getStringArrayList().size();
        SoundPlayer.initSound(context);

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
                            imageView.setImageResource(R.drawable.yeonggilillust);
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
                            imageView.setImageResource(R.drawable.yeonggilillust);
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
        Phrase.addPhrase("모든 단점은 장점이 될 수 있다.", R.raw.changu_01, R.raw.chun_01, R.raw.moon_01);
        Phrase.addPhrase("트위터는 인생의 낭비다", R.raw.changu_02, R.raw.chun_02, R.raw.moon_02);
        Phrase.addPhrase("못막을 공은 막지 않는다.", R.raw.changu_03, R.raw.chun_03, R.raw.moon_03);
        Phrase.addPhrase("죽으러 가는게 아니야. 내가 정말 살아 있는 지를 확인하러 가는거야.", R.raw.changu_04, R.raw.chun_04, R.raw.moon_04);
        Phrase.addPhrase("포기하면 그 순간이 바로 시합 종료다.", R.raw.changu_05, R.raw.chun_05, R.raw.moon_05);
        Phrase.addPhrase("오늘 심고 내일 자라기를 바라지 마라.", R.raw.changu_06, R.raw.chun_06, R.raw.moon_06);
        Phrase.addPhrase("인간이 5명이나 모이면 반드시 1명은 쓰레기가 있다.", R.raw.changu_07, R.raw.chun_07, R.raw.moon_07);
        Phrase.addPhrase("사람은 소중한 무언가를 지켜려고 할 때에 정말로 강해지는 법이에요.",  R.raw.changu_08, R.raw.chun_08, R.raw.moon_08);
        Phrase.addPhrase("시간은 아무도 기다려 주지 않는다.",  R.raw.changu_09, R.raw.chun_09, R.raw.moon_09);
        Phrase.addPhrase("진정한 친구는 애써 지은 미소 속에 가려진 눈물을 봐.",  R.raw.changu_10, R.raw.chun_10, R.raw.moon_10);
        Phrase.addPhrase("서로를 이해하려고 하면 할수록 서로의 차이를 더 포용하게 될 거에요.",  R.raw.changu_11, R.raw.chun_11, R.raw.moon_11);
        Phrase.addPhrase("나는 나보다 약한 녀석의 명령 따위는 듣지 않는다.",  R.raw.changu_12, R.raw.chun_12, R.raw.moon_12);
        Phrase.addPhrase("인생의 선택에 타인의 말은 필요 없어.",  R.raw.changu_13, R.raw.chun_13, R.raw.moon_13);
        Phrase.addPhrase("사고를 쳤을 때 뭘 해야 할지 모르겠으면 입 다물고 있어라 최소한 악화되지 않는다.",  R.raw.changu_14, R.raw.chun_14, R.raw.moon_14);
        Phrase.addPhrase("누구나 무엇이든 될 수 있다.",  R.raw.changu_15, R.raw.chun_15, R.raw.moon_15);
        Phrase.addPhrase("무언가를 찾고 있다면 길을 헷갈려선 안돼.한번이라도 헷갈리면 더 이상 찾을 수 없게 되니까.그치만 헷갈려도 괜찮아 다른걸 찾아질테니까.",  R.raw.changu_16, R.raw.chun_16, R.raw.moon_16);
        Phrase.addPhrase("인생은 살아만 있다면 몇번이든 새출발 할 수 있으니까.",  R.raw.changu_17, R.raw.chun_17, R.raw.moon_17);
        Phrase.addPhrase("두번째 작품은 대부분 졸작이기 마련이지.",  R.raw.changu_18, R.raw.chun_18, R.raw.moon_18);
        Phrase.addPhrase("약한 자 일수록 상대를 용서하지 못한다.용서한다는 것은 강하다는 증거다.",  R.raw.changu_19, R.raw.chun_19, R.raw.moon_19);
        Phrase.addPhrase("자신을 믿지 않는 자는 노력할 가치도 없다.",  R.raw.changu_20, R.raw.chun_20, R.raw.moon_20);
        Phrase.addPhrase("매일매일 좋을 순없어 그런데 잘 찾아보면 매일매일 좋은 일은 있다구.", R.raw.changu_21, R.raw.chun_21, R.raw.moon_21);
        Phrase.addPhrase("꿈은 도망가지 않는다.도망가는 것은 언제나 나 자신이다.",  R.raw.changu_22, R.raw.chun_22, R.raw.moon_22);
        Phrase.addPhrase("의미 없는 것을 잔뜩 하는 것이 인생이란다.", R.raw.changu_23, R.raw.chun_23, R.raw.moon_23);
        Phrase.addPhrase("누군가를 돕는 건 엄청 부자연스러운 일이야.그 부자연스러운 짓을 부모가 되면 평생 해야만 하는거야.", R.raw.changu_24 , R.raw.chun_24, R.raw.moon_24);
        Phrase.addPhrase("계획대로 되지 않는게 인생이라는거야.", R.raw.changu_25, R.raw.chun_25, R.raw.moon_25);
        Phrase.addPhrase("배는 항구에 있을 때 가장 안전하지만 그것이 존재의 이유는 아니다.",  R.raw.changu_26, R.raw.chun_26, R.raw.moon_26);
        Phrase.addPhrase("방황하는 이들 모두가 길을 잃은 것은 아니다.", R.raw.changu_27, R.raw.chun_27, R.raw.moon_27);
        Phrase.addPhrase("공포 앞에 논쟁이란 없다.", R.raw.changu_28, R.raw.chun_28, R.raw.moon_28);
        Phrase.addPhrase("호랑이는 죽어서 가죽을 남기고 사람은 죽어서 이름을 남긴다.", R.raw.changu_29, R.raw.chun_29, R.raw.moon_29);
        Phrase.addPhrase("자연이 그대를 거부하리라.",  R.raw.changu_30, R.raw.chun_30, R.raw.moon_30);
        Phrase.addPhrase("빛이 당신을 태울 것입니다.",  R.raw.changu_31, R.raw.chun_31, R.raw.moon_31);
        Phrase.addPhrase("지배계급으로 하여금 공산주의 혁명 앞에서 벌벌 떨게 하라!프롤레타리아가 혁명에서 잃을 것이라고는 쇠사슬 뿐이요, 얻을 것은 전세계다.만국의 노동자여, 단결하라!", R.raw.changu_32 , R.raw.chun_32, R.raw.moon_32);
        Phrase.addPhrase("내려갈 팀은 내려간다.",  R.raw.changu_33, R.raw.chun_33, R.raw.moon_33);
        Phrase.addPhrase("내가 천하를 등질지언정 천하가 나를 등지게는 하지 않겠소.",  R.raw.changu_34, R.raw.chun_34, R.raw.moon_34);
        Phrase.addPhrase("필사즉생, 필생즉사.", R.raw.changu_35 , R.raw.chun_35, R.raw.moon_35);
        Phrase.addPhrase("머리카락이 후퇴하는 것이 아니다. 내가 전진하는 것이다.", R.raw.changu_36, R.raw.chun_36, R.raw.moon_36);
        Phrase.addPhrase("물리학 외의 과학은 우표수집에 불과하다.", R.raw.changu_37, R.raw.chun_37, R.raw.moon_37);
        Phrase.addPhrase("나를 죽이지 못하는 시련은 날 더욱 강하게 만들뿐이야.",  R.raw.changu_38, R.raw.chun_38, R.raw.moon_38);
        Phrase.addPhrase("남자에겐 주먹이면 충분하지, 저런 무기따윈 필요없어.", R.raw.changu_39, R.raw.chun_39, R.raw.moon_39);
        Phrase.addPhrase("남자가 믿을 수 있는 신은 자기자신밖에 없는거요.", R.raw.changu_40, R.raw.chun_40, R.raw.moon_40);
        Phrase.addPhrase("남자의 결심을 욕보이지 마라.때론 논리나 이유보단 응원이 필요할 때가 있는거니까.", R.raw.changu_41, R.raw.chun_41, R.raw.moon_41);
        Phrase.addPhrase("신념의 무게 앞에 숫자따윈 무의미다.",  R.raw.changu_42, R.raw.chun_42, R.raw.moon_42);
        Phrase.addPhrase("도망친곳에 낙원은 없다.", R.raw.changu_43, R.raw.chun_43, R.raw.moon_43);
        Phrase.addPhrase("남자의 눈물은 슬픔에서 나오지 않아!괴로움에서 나오는거다.", R.raw.changu_44, R.raw.chun_44, R.raw.moon_44);
        Phrase.addPhrase("부딪히면 피하지 않는것, 그게 수컷 아니겠어?",  R.raw.changu_45, R.raw.chun_45, R.raw.moon_45);
        Phrase.addPhrase("나에대한 믿음! 그것만한 안전장치가 또 어딨어.", R.raw.changu_46, R.raw.chun_46, R.raw.moon_46);
        Phrase.addPhrase("사나이는 마음은 가슴으로 받고 위기는 등으로 받는 법.", R.raw.changu_47, R.raw.chun_47, R.raw.moon_47);
        Phrase.addPhrase("어머니는 이름만 들어도 눈물나는 존재니까...", R.raw.changu_48, R.raw.chun_48, R.raw.moon_48);
        Phrase.addPhrase("남자는 등으로 말한다.",  R.raw.changu_49, R.raw.chun_49, R.raw.moon_49);
        Phrase.addPhrase("눈물이 꼭 나쁜것만은 아니야! 인생이 요리라면 간은 눈물로 하는거니까. 그래서 지금 우는거다. 짜지 않을 정도로만 우는거야!",  R.raw.changu_50, R.raw.chun_50, R.raw.moon_50);
        Phrase.addPhrase("죽은듯이 살아갈 바에는 차라리 죽는게 나아.",  R.raw.changu_51, R.raw.chun_51, R.raw.moon_51);
        Phrase.addPhrase("그깟 관성따위!근성이 이긴다!", R.raw.changu_52, R.raw.chun_52, R.raw.moon_52);
        Phrase.addPhrase("사람에게 받은 상처는 사람으로 치료할 수 있는거란다.",  R.raw.changu_53, R.raw.chun_53, R.raw.moon_53);
        Phrase.addPhrase("아버지는 쓰러지면 안돼.우리가 쓰러지면 남은 이들은 무너질테니 말일세.",  R.raw.changu_54, R.raw.chun_54, R.raw.moon_54);
        Phrase.addPhrase("승부를 결정 짓는건 집념과 약간의 운이다.",  R.raw.changu_55, R.raw.chun_55, R.raw.moon_55);
        Phrase.addPhrase("불가능은 불꽃 가능의 줄임말일 뿐이다.",  R.raw.changu_56, R.raw.chun_56, R.raw.moon_56);
        Phrase.addPhrase("통제할 수 없는 힘은 손잡이가 날도 된 칼일 뿐이야.", R.raw.changu_57, R.raw.chun_57, R.raw.moon_57);
        Phrase.addPhrase("남자의 피에는 로망이 흐르고 남자의 땀에는 낭만이 흐르고 남자의 눈물에는 마음이 흐른다....", R.raw.changu_58, R.raw.chun_58, R.raw.moon_58);
        Phrase.addPhrase("남자는 엎드려 살지않아, 선채로 죽는거다.", R.raw.changu_59, R.raw.chun_59, R.raw.moon_59);
        Phrase.addPhrase("죄송하지만 용기는 따로 팔지 않습니다, 용기는 우리 모두의 마음 속에 있는거니까요.",  R.raw.changu_60, R.raw.chun_60, R.raw.moon_60);
    }

    private void setEnglishPhrase(){
        EnglishPhrase.addPhrase("Think like a man of action and act like man of thought", R.raw.kamila_01, R.raw.julia_01, R.raw.trump_01);
        EnglishPhrase.addPhrase("The best things in life are free", R.raw.kamila_02, R.raw.julia_02,R.raw.trump_02);
        EnglishPhrase.addPhrase("We are in the endgame now", R.raw.kamila_03, R.raw.julia_03,R.raw.trump_03);
        EnglishPhrase.addPhrase("We are Venom", R.raw.kamila_04, R.raw.julia_04,R.raw.trump_04);
        EnglishPhrase.addPhrase("Avengers...Assemble", R.raw.kamila_05, R.raw.julia_05,R.raw.trump_05);
        EnglishPhrase.addPhrase("I am Ironman", R.raw.kamila_06, R.raw.julia_06,R.raw.trump_06);
        EnglishPhrase.addPhrase("Dormammu, I've come to bargain", R.raw.kamila_07, R.raw.julia_07,R.raw.trump_07);
        EnglishPhrase.addPhrase("I can do this all day", R.raw.kamila_08, R.raw.julia_08,R.raw.trump_08);
        EnglishPhrase.addPhrase("We are Guardians of the Galaxy", R.raw.kamila_09, R.raw.julia_09,R.raw.trump_09);
        EnglishPhrase.addPhrase("Hail Hydra", R.raw.kamila_10, R.raw.julia_10,R.raw.trump_10);
        EnglishPhrase.addPhrase("Mother...f", R.raw.kamila_11, R.raw.julia_11,R.raw.trump_11);
        EnglishPhrase.addPhrase("Puny god", R.raw.kamila_12, R.raw.julia_12,R.raw.trump_12);
        EnglishPhrase.addPhrase("We are Groot", R.raw.kamila_13, R.raw.julia_13,R.raw.trump_13);
        EnglishPhrase.addPhrase("The road to success and the road to failure are almost exactly the same.", R.raw.kamila_14, R.raw.julia_14,R.raw.trump_14);
        EnglishPhrase.addPhrase("It is better to fail in originality than to succeed in imitation.", R.raw.kamila_14, R.raw.julia_14,R.raw.trump_14);
        EnglishPhrase.addPhrase("Success is walking from failure to failure with no loss of enthusiasm.", R.raw.kamila_14, R.raw.julia_14,R.raw.trump_14);
        EnglishPhrase.addPhrase("All progress takes place outside the comfort zone.", R.raw.kamila_14, R.raw.julia_14,R.raw.trump_14);
        EnglishPhrase.addPhrase("Success usually comes to those who are too busy to be looking for it.", R.raw.kamila_14, R.raw.julia_14,R.raw.trump_14);
        EnglishPhrase.addPhrase("The way to get started is to quit talking and begin doing.", R.raw.kamila_14, R.raw.julia_14,R.raw.trump_14);
        EnglishPhrase.addPhrase("Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful.", R.raw.kamila_14, R.raw.julia_14,R.raw.trump_14);
        EnglishPhrase.addPhrase("Success seems to be connected with action. Successful people keep moving.", R.raw.kamila_14, R.raw.julia_14,R.raw.trump_14);
        EnglishPhrase.addPhrase("In order to succeed, we must first believe that we can.", R.raw.kamila_14, R.raw.julia_14,R.raw.trump_14);
        EnglishPhrase.addPhrase("The only place where success comes before work is in the dictionary.", R.raw.kamila_14, R.raw.julia_14,R.raw.trump_14);
    }

}
