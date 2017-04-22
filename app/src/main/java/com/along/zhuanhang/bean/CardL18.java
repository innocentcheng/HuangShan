package com.along.zhuanhang.bean;


import android.widget.ImageView;

public abstract class CardL18 {
    private String name;
    private int imageView;
    private int cost;

    public int getCost(){
        return cost;
    }
    public void setCost(int newCost){
        cost = newCost;
    }

    public int getImageView(){
        return imageView;
    }
    public void setImageView(int newImage){
        imageView = newImage;
    }
    public String getName(){
        return name;
    }
    public void setName(String newName){
        name = newName;
    }

    @Override
    public String toString() {
        return type()+"{ name: "+name+" cost: "+cost+" }";
    }

    public abstract String type();
    public abstract String play();

}
