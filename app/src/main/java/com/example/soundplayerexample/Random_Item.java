package com.example.soundplayerexample;

public class Random_Item {
    String string;
    int soundID;

    public int getSoundID() {
        return soundID;
    }

    public void setSoundID(int soundID) {
        this.soundID = soundID;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Random_Item(String string, int iValue) {
        this.string = string;
        soundID = iValue;
    }
}
