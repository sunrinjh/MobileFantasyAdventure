package com.example.mobilefantasyadventure;

import java.util.ArrayList;

public class EnglishPhrase {
    private static ArrayList<String> stringArrayList = new ArrayList<>();

    private static ArrayList<Integer> integerArrayList_Kamila = new ArrayList<>();
    private static ArrayList<Integer> integerArrayList_Julia = new ArrayList<>();
    private static ArrayList<Integer> integerArrayList_Trump = new ArrayList<>();


    public static void addPhrase(String string, Integer kamila_Id, Integer julia_Id, Integer trump_Id){
        stringArrayList.add(string);
        integerArrayList_Kamila.add(kamila_Id);
        integerArrayList_Julia.add(julia_Id);
        integerArrayList_Trump.add(trump_Id);
    }

    public static ArrayList<String> getStringArrayList() {
        return stringArrayList;
    }

    public static void setStringArrayList(ArrayList<String> stringArrayList) {
        EnglishPhrase.stringArrayList = stringArrayList;
    }

    public static ArrayList<Integer> getIntegerArrayList_Kamila() {
        return integerArrayList_Kamila;
    }

    public static ArrayList<Integer> getIntegerArrayList_Julia() {
        return integerArrayList_Julia;
    }

    public static ArrayList<Integer> getIntegerArrayList_Trump() {
        return integerArrayList_Trump;
    }

}
