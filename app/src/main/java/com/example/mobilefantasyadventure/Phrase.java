package com.example.mobilefantasyadventure;

import android.util.Log;

import java.util.ArrayList;

public class Phrase {
    private static ArrayList<String> stringArrayList = new ArrayList<>();

    private static ArrayList<Integer> integerArrayList_Changu = new ArrayList<>();
    private static ArrayList<Integer> integerArrayList_Chun = new ArrayList<>();
    private static ArrayList<Integer> integerArrayList_Moon = new ArrayList<>();



    public static void addPhrase(String string, Integer changu_Id, Integer chun_Id, Integer moon_Id){
        stringArrayList.add(string);
        integerArrayList_Changu.add(changu_Id);
        integerArrayList_Chun.add(chun_Id);
        integerArrayList_Moon.add(moon_Id);
    }

    public static ArrayList<String> getStringArrayList() {
        return stringArrayList;
    }

    public static void setStringArrayList(ArrayList<String> stringArrayList) {
        Phrase.stringArrayList = stringArrayList;
    }

    public static ArrayList<Integer> getIntegerArrayList_Changu() {
        return integerArrayList_Changu;
    }

    public static ArrayList<Integer> getIntegerArrayList_Chun() {
        return integerArrayList_Chun;
    }

    public static ArrayList<Integer> getIntegerArrayList_Moon() {
        return integerArrayList_Moon;
    }

    public static void setIntegerArrayList_Changu(ArrayList<Integer> integerArrayList_Changu) {
        Phrase.integerArrayList_Changu = integerArrayList_Changu;
    }
}
