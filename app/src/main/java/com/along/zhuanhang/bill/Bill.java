package com.along.zhuanhang.bill;

/**
 * Created by aloong on 2017/4/22.
 */

 class Bill {
    private int mIconId;
    private String mName;
    private long mTimestamp;
    private int mMoney;

    Bill(int iconId,String name,long time,int money){
        mIconId = iconId;
        mName = name;
        mTimestamp = time;
        mMoney = money;
    }
    public int getmIconId(){
        return mIconId;
    }
    public Bill setmIconId(int iconId){
        mIconId = iconId;
        return this;
    }
    public String getmName(){
        return mName;
    }
    public Bill setmName(String name){
        mName = name;
        return this;
    }
    public long getmTimestamp(){
        return mTimestamp;
    }
    public Bill setmTimestamp(long time){
        mTimestamp = time;
        return this;
    }
    public int getmMoney(){
        return mMoney;
    }
    public Bill setmMoney(int money){
        mMoney = money;
        return this;
    }

}

