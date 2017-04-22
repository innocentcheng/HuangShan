package com.along.zhuanhang.bean;

/**
 * Created by Yun on 2016/12/31.
 */

public class Item {
    public int imageid;
    public int cost;
    public String itemName;

    public int getImageid(){
    return imageid;
    }
    public void setImageId(int newImageId) {
        imageid = newImageId;
    }
    public int getCost(){
        return cost;
    }
    public void setCost(int newCost){
        cost = newCost;
    }
    public String  getItemName() {
        return itemName;
    }
    public void setItemName(String newItemName){
       itemName = newItemName;
    }

}
