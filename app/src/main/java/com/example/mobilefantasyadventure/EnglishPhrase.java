package com.example.mobilefantasyadventure;

import java.util.ArrayList;

public class EnglishPhrase {
    private static ArrayList<String> stringArrayList = new ArrayList<>();

    private static ArrayList<Integer> integerArrayList_Kamila = new ArrayList<>();



    public static void addPhrase(String string, Integer changu_Id){
        stringArrayList.add(string);
        integerArrayList_Kamila.add(changu_Id);
    }

    public static ArrayList<String> getStringArrayList() {
        return stringArrayList;
    }

    public static void setStringArrayList(ArrayList<String> stringArrayList) {
        EnglishPhrase.stringArrayList = stringArrayList;
    }

    public static ArrayList<Integer> integerArrayList_Kamila() {
        return integerArrayList_Kamila;
    }

    public static void setIntegerArrayList_Changu(ArrayList<Integer> integerArrayList_Kamila) {
        EnglishPhrase.integerArrayList_Kamila = integerArrayList_Kamila;
    }
}
