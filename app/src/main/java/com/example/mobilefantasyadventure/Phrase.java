package com.example.mobilefantasyadventure;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Phrase {
    private static ArrayList<String> stringArrayList = new ArrayList<>();

    private static ArrayList<Integer> integerArrayList_Changu = new ArrayList<>();
    private static ArrayList<Integer> integerArrayList_Chun = new ArrayList<>();
    private static ArrayList<Integer> integerArrayList_Moon = new ArrayList<>();
    private static JSONArray jsonArray = new JSONArray();
    public static void makeJson(){
        int i = 0;
        for (String string :stringArrayList) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("text", string);
                jsonObject.put("index"+i, i);
                jsonObject.put("0", integerArrayList_Changu.get(i));
                jsonObject.put("1", integerArrayList_Chun.get(i));
                jsonObject.put("2", integerArrayList_Moon.get(i));
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
                Log.d("Json", s.substring(idx, nextIdx > len ? len : nextIdx));
                idx = nextIdx;
            }
        } else {
            Log.d("Json", s);
        }
    }

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
