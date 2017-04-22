package com.along.zhuanhang.bean;



public class HealingSpellCardL18 extends SpellCardL18{
    public HealingSpellCardL18(String name) {
        super(name);
    }

    @Override
    public String type() {
        return "治疗型法术牌";
    }

    @Override
    public String play() {
        return "你打出了一张"+type()+getName();
    }
}
