package com.example.mobilefantasyadventure;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EnglishPhrase {

    private static ArrayList<String> stringArrayList = new ArrayList<>();

    private static ArrayList<Integer> integerArrayList_Kamila = new ArrayList<>();
    private static ArrayList<Integer> integerArrayList_Julia = new ArrayList<>();
    private static ArrayList<Integer> integerArrayList_Trump = new ArrayList<>();
    private static JSONArray jsonArray = new JSONArray();
    public static void makeJson(){
        int i = 0;
        for (String string :stringArrayList) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("text", string);
                jsonObject.put("0", integerArrayList_Kamila.get(i));
                jsonObject.put("1", integerArrayList_Julia.get(i));
                jsonObject.put("2", integerArrayList_Trump.get(i));
                jsonArray.put(jsonObject);
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            i = i+1;
        }
        String s = jsonArray.toString();
        final int MAX_LEN = 2000; // 2000 bytes 마다 끊어서 출력
        int len = s.length();
        if(len > MAX_LEN) {
            int idx = 0, nextIdx = 0;
            while(idx < len) {
                nextIdx += MAX_LEN;
                Log.e("Json", s.substring(idx, nextIdx > len ? len : nextIdx));
                idx = nextIdx;
            }
        } else {
            Log.e("Json", s);
        }
    }
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
