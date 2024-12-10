package com.example.platformerplain.object;

public class Character {
    public int index;
    public String Name;

    public Character() {
        this.index = 0;
        this.Name = "Default Player";
    }

    public Character(int index, String name) {
        this.index = index;
        this.Name = name;
    }
}
