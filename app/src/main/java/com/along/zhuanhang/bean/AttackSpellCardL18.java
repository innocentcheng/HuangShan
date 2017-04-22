package com.along.zhuanhang.bean;


import org.json.JSONException;
import org.json.JSONObject;

public class  AttackSpellCardL18 extends SpellCardL18 implements Attackable{
    private int damage;




    public AttackSpellCardL18(String name, int cost,int damage) {
        super(name);
        setCost(cost);
        this.damage = damage;
    }
    public AttackSpellCardL18(String name,int damage) {
        super(name);
        this.damage = damage;
    }

    @Override
    public int damage() {
        return damage;
    }

    @Override
    public String handleDamage() {
        return ("对敌人造成了"+damage()+"点伤害");
    }

    @Override
    public String type() {
        return "攻击型法术牌";
    }

    @Override
    public String play() {
        return "你打出了一张"+type()+getName();
    }

    @Override
    public String toString() {
        return type()+"{ name: "+getName()+" cost: "+getCost()+" damage: "+damage+" }";
    }

    public String toJson(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name",getName());
            jsonObject.put("cost",getCost());
            jsonObject.put("damage",damage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
