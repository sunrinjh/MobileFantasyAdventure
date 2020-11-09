package com.example.mobilefantasyadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Context context;
    int randomBound;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        setPhrase();
        randomBound = Phrase.getStringArrayList().size();
        SoundPlayer.initSound(context);

        findViewById(R.id.view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refillPhrase();
            }
        });
        textView = findViewById(R.id.text);
    }
    public void refillPhrase(){
        Random random = new Random();
        int randInt = random.nextInt(randomBound);
        SoundPlayer.playSound(context,Phrase.getIntegerArrayList_Changu().get(randInt));
        textView.setText(Phrase.getStringArrayList().get(randInt));
    }
    private void setPhrase(){
        Phrase.addPhrase("모든 단점은 장점이 될 수 있다.", R.raw.changu_01);
        Phrase.addPhrase("못막을 공은 막지 않는다.", R.raw.changu_03);
        Phrase.addPhrase("트위터는 인생의 낭비다", R.raw.changu_02);
        Phrase.addPhrase("죽으러 가는게 아니야. 내가 정말 살아 있는 지를 확인하러 가는거야.", R.raw.changu_04);
        Phrase.addPhrase("포기하면 그 순간이 바로 시합 종료다.", R.raw.changu_05);
        Phrase.addPhrase("오늘 심고 내일 자라기를 바라지 마라.", R.raw.changu_06);
        Phrase.addPhrase("인간이 5명이나 모이면 반드시 1명은 쓰레기가 있다.", R.raw.changu_07);
        Phrase.addPhrase("사람은 소중한 무언가를 지켜려고 할 때에 정말로 강해지는 법이에요.",  R.raw.changu_08);
        Phrase.addPhrase("시간은 아무도 기다려 주지 않는다.",  R.raw.changu_09);
        Phrase.addPhrase("진정한 친구는 애써 지은 미소 속에 가려진 눈물을 봐.",  R.raw.changu_10);
        Phrase.addPhrase("서로를 이해하려고 하면 할수록 서로의 차이를 더 포용하게 될 거에요.",  R.raw.changu_11);
        Phrase.addPhrase("나는 나보다 약한 녀석의 명령 따위는 듣지 않는다.",  R.raw.changu_12);
        Phrase.addPhrase("인생의 선택에 타인의 말은 필요 없어.",  R.raw.changu_13);
        Phrase.addPhrase("사고를 쳤을 때 뭘 해야 할지 모르겠으면 입 다물고 있어라 최소한 악화되지 않는다.",  R.raw.changu_14);
        Phrase.addPhrase("누구나 무엇이든 될 수 있다.",  R.raw.changu_15);
        Phrase.addPhrase("무언가를 찾고 있다면 길을 헷갈려선 안돼.한번이라도 헷갈리면 더 이상 찾을 수 없게 되니까.그치만 헷갈려도 괜찮아 다른걸 찾아질테니까.",  R.raw.changu_16);
        Phrase.addPhrase("인생은 살아만 있다면 몇번이든 새출발 할 수 있으니까.",  R.raw.changu_17);
        Phrase.addPhrase("두번째 작품은 대부분 졸작이기 마련이지.",  R.raw.changu_18);
        Phrase.addPhrase("약한 자 일수록 상대를 용서하지 못한다.용서한다는 것은 강하다는 증거다.",  R.raw.changu_19);
        Phrase.addPhrase("자신을 믿지 않는 자는 노력할 가치도 없다.",  R.raw.changu_20);
        Phrase.addPhrase("매일매일 좋을 순없어 그런데 잘 찾아보면 매일매일 좋은 일은 있다구.", R.raw.changu_21 );
        Phrase.addPhrase("꿈은 도망가지 않는다.도망가는 것은 언제나 나 자신이다.",  R.raw.changu_22);
        Phrase.addPhrase("의미 없는 것을 잔뜩 하는 것이 인생이란다.", R.raw.changu_23 );
        Phrase.addPhrase("누군가를 돕는 건 엄청 부자연스러운 일이야.그 부자연스러운 짓을 부모가 되면 평생 해야만 하는거야.", R.raw.changu_24 );
        Phrase.addPhrase("계획대로 되지 않는게 인생이라는거야.", R.raw.changu_25 );
        Phrase.addPhrase("배는 항구에 있을 때 가장 안전하지만 그것이 존재의 이유는 아니다.",  R.raw.changu_26);
        Phrase.addPhrase("방황하는 이들 모두가 길을 잃은 것은 아니다.", R.raw.changu_27 );
        Phrase.addPhrase("공포 앞에 논쟁이란 없다.", R.raw.changu_28 );
        Phrase.addPhrase("호랑이는 죽어서 가죽을 남기고 사람은 죽어서 이름을 남긴다.", R.raw.changu_29 );
        Phrase.addPhrase("자연이 그대를 거부하리라.",  R.raw.changu_30);
        Phrase.addPhrase("빛이 당신을 태울 것입니다.",  R.raw.changu_31);
        Phrase.addPhrase("지배계급으로 하여금 공산주의 혁명 앞에서 벌벌 떨게 하라!프롤레타리아가 혁명에서 잃을 것이라고는 쇠사슬 뿐이요, 얻을 것은 전세계다.만국의 노동자여, 단결하라!", R.raw.changu_32 );
        Phrase.addPhrase("내려갈 팀은 내려간다.",  R.raw.changu_33);
        Phrase.addPhrase("내가 천하를 등질지언정 천하가 나를 등지게는 하지 않겠소.",  R.raw.changu_34);
        Phrase.addPhrase("필사즉생, 필생즉사.", R.raw.changu_35 );
        Phrase.addPhrase("머리카락이 후퇴하는 것이 아니다. 내가 전진하는 것이다.", R.raw.changu_36 );
        Phrase.addPhrase("물리학 외의 과학은 우표수집에 불과하다.", R.raw.changu_37 );
        Phrase.addPhrase("나를 죽이지 못하는 시련은 날 더욱 강하게 만들뿐이야.",  R.raw.changu_38);
        Phrase.addPhrase("남자에겐 주먹이면 충분하지, 저런 무기따윈 필요없어.", R.raw.changu_39 );
        Phrase.addPhrase("남자가 믿을 수 있는 신은 자기자신밖에 없는거요.", R.raw.changu_40 );
        Phrase.addPhrase("남자의 결심을 욕보이지 마라.때론 논리나 이유보단 응원이 필요할 때가 있는거니까.", R.raw.changu_41 );
        Phrase.addPhrase("신념의 무게 앞에 숫자따윈 무의미다.",  R.raw.changu_42);
        Phrase.addPhrase("도망친곳에 낙원은 없다.", R.raw.changu_43 );
        Phrase.addPhrase("남자의 눈물은 슬픔에서 나오지 않아!괴로움에서 나오는거다.", R.raw.changu_44 );
        Phrase.addPhrase("부딪히면 피하지 않는것, 그게 수컷 아니겠어?",  R.raw.changu_45);
        Phrase.addPhrase("나에대한 믿음! 그것만한 안전장치가 또 어딨어.", R.raw.changu_46);
        Phrase.addPhrase("사나이는 마음은 가슴으로 받고 위기는 등으로 받는 법.", R.raw.changu_47 );
        Phrase.addPhrase("어머니는 이름만 들어도 눈물나는 존재니까...", R.raw.changu_48 );
        Phrase.addPhrase("남자는 등으로 말한다.",  R.raw.changu_49);
        Phrase.addPhrase("눈물이 꼭 나쁜것만은 아니야! 인생이 요리라면 간은 눈물로 하는거니까. 그래서 지금 우는거다. 짜지 않을 정도로만 우는거야!",  R.raw.changu_50);
        Phrase.addPhrase("죽은듯이 살아갈 바에는 차라리 죽는게 나아.",  R.raw.changu_51);
        Phrase.addPhrase("그깟 관성따위!근성이 이긴다!", R.raw.changu_52 );
        Phrase.addPhrase("사람에게 받은 상처는 사람으로 치료할 수 있는거란다.",  R.raw.changu_53);
        Phrase.addPhrase("아버지는 쓰러지면 안돼.우리가 쓰러지면 남은 이들은 무너질테니 말일세.",  R.raw.changu_54);
        Phrase.addPhrase("승부를 결정 짓는건 집념과 약간의 운이다.",  R.raw.changu_55);
        Phrase.addPhrase("불가능은 불꽃 가능의 줄임말일 뿐이다.",  R.raw.changu_56);
        Phrase.addPhrase("통제할 수 없는 힘은 손잡이가 날도 된 칼일 뿐이야.", R.raw.changu_57 );
        Phrase.addPhrase("남자의 피에는 로망이 흐르고 남자의 땀에는 낭만이 흐르고 남자의 눈물에는 마음이 흐른다....", R.raw.changu_58 );
        Phrase.addPhrase("남자는 엎드려 살지않아, 선채로 죽는거다.", R.raw.changu_59 );
        Phrase.addPhrase("죄송하지만 용기는 따로 팔지 않습니다, 용기는 우리 모두의 마음 속에 있는거니까요.",  R.raw.changu_60);
    }

}