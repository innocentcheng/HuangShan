package com.along.zhuanhang.bean;


public class ItemCardL18 extends CardL18 implements Attackable{
    private int damage;
    public ItemCardL18 (String name,int damage){
        setName(name);
        this.damage = damage;
    }

    @Override
    public String type() {
        return "装备牌";
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
}
