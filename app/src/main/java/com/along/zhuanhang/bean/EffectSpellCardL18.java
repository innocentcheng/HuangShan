package com.along.zhuanhang.bean;

/**
 * Created by Yun on 2017/3/5.
 */

public class EffectSpellCardL18 extends CardL18 {
    public EffectSpellCardL18 (String name){
        setName(name);
    }
    @Override
    public String type() {
        return "效果型法术牌";
    }

    @Override
    public String play() {
        return "你打出了一张"+type()+getName();
    }
}
