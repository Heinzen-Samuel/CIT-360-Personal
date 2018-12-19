package com.cit360projectmark4.pojo;

public class TempScab {
    private String name = "--Ghost--";
    private int str = 0;
    private int luck = 0;

    public TempScab(){}

    public TempScab(String new_name, int new_str, int new_luck) {
        this.name = new_name;
        this.str = new_str;
        this.luck = new_luck;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public String getName() {
        return name;
    }

    public int getStr() {
        return str;
    }

    public int getLuck() {
        return luck;
    }

    @Override
    public String toString() {
        return "Random SCAB: Name: " + name + " str: " + str + " luck: " + luck;
    }
}
