package com.along.zhuanhang.bean;

//public:公开的
//proteced:类 子类
//无：类 同包
//private:仅此类可用
public class GuichushaCard {
    private String name;
    private String description;
    private String qulity;
    private String type;
    private int imageId;

    public String getName() {
        return name;
    }
    public void setName(String newname) {
        name = newname;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String newdescription){
        description = newdescription;
    }

    public String getQulity(){
        return  qulity;
    }
    public void setQulity(String newqulity){
        qulity = newqulity;
    }

    public String getType() {
        return type;
    }
    public void setType(String newtype) {
         type = newtype;
    }

    public int getImageId(){
        return imageId;
    }
    public void setImageId(int newImageId){
        imageId = newImageId;
    }

}