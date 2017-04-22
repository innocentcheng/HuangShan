package com.along.zhuanhang.bean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MinionCardL18 extends CardL18 implements Attackable{

    private int damage;
    public int hp;
    private String type;


    public int getHp(){
        return hp;
    }
    public void setHp(int newHp){
        hp = newHp;
    }

    public MinionCardL18(String name, int damage) {
        setName(name);
        this.damage = damage;
    }
    public MinionCardL18(String name, int cost,int hp,int damage) {
        setName(name);
        setCost(cost);
        this.hp = hp;
        this.damage = damage;
    }


    @Override
    public String type() {
        return "随从牌";
    }

    @Override
    public String play() {
        return "你打出了一张"+type()+getName();
    }

    @Override
    public int damage() {
        return damage;
    }

    @Override
    public String handleDamage() {
        return "对敌人造成了"+damage()+"点伤害";
    }

    @Override
    public String toString() {
        return type()+"{ name: "+getName()+" cost: "+getCost()+" hp: "+hp+" damage: "+damage+" }";
    }

    public JSONObject toJson(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name",getName());
            jsonObject.put("cost",getCost());
            jsonObject.put("hp",hp);
            jsonObject.put("damage",damage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static MinionCardL18 parseJson(String jsonString){
        MinionCardL18 minionCardL18 = null;
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            String name = jsonObject.getString("name");
            int cost = jsonObject.getInt("cost");
            int hp = jsonObject.getInt("hp");
            int damage = jsonObject.getInt("damage");
            minionCardL18 = new MinionCardL18(name,cost,hp,damage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return minionCardL18;
    }

    public static List<MinionCardL18> parseList(String jsonString){
        ArrayList<MinionCardL18> arrayList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.optJSONObject(i);
                MinionCardL18 minionCardL18 = parseJson(jsonObject.toString());
                arrayList.add(minionCardL18);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
