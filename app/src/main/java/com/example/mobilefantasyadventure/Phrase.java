package com.example.mobilefantasyadventure;

import android.util.Log;

import java.util.ArrayList;

public class Phrase {
    private static ArrayList<String> stringArrayList = new ArrayList<>();

    private static ArrayList<Integer> integerArrayList_Changu = new ArrayList<>();



    public static void addPhrase(String string, Integer changu_Id){
        stringArrayList.add(string);
        integerArrayList_Changu.add(changu_Id);
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

    public static void setIntegerArrayList_Changu(ArrayList<Integer> integerArrayList_Changu) {
        Phrase.integerArrayList_Changu = integerArrayList_Changu;
    }
}
