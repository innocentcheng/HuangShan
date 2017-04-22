package com.along.zhuanhang.bean;

/**
 * Created by Yun on 2017/1/2.
 */

public class Ninja {
    private String ninjaName;
    private int attack;
    private int hp;
    private int id;

    public String getNinjaName(){
        return ninjaName;
    }
    public void setNinjaName(String newNinjaName){
        ninjaName = newNinjaName;
    }
    public int getAttack(){
        return attack;
    }
    public void setAttack(int newAttack){
        attack = newAttack;
    }
    public int getHp(){
        return hp;
    }
    public void setHp(int newHp){
        hp = newHp;
    }
    public int getId(){return id;}
    public void setId(int newId){id = newId;}
}
