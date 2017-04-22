package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.along.zhuanhang.R;
import com.along.zhuanhang.bean.Item;

public class l8 extends AppCompatActivity {

    private TextView mtvmoney;
    private ImageView mivitem1;
    private ImageView mivitem2;
    private TextView mbtn1;
    private TextView mbtn2;
    private TextView mtvinfo;
    private int rem;
    private Item item1;
    private Item item2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l7text2);

        rem = 10000;
        item1 = new Item();
        item1.setItemName("跳刀");
        item1.setImageId(R.mipmap.imagetiaodao);
        item1.setCost(2250);
        item2 = new Item();
        item2.setItemName("圣剑");
        item2.setImageId(R.mipmap.imageshengjian);
        item2.setCost(6200);
        initView();
        initData();
    }
    public void initView(){
        mtvmoney = (TextView) findViewById(R.id.l8_tv_money);
        mivitem1 = (ImageView) findViewById(R.id.l8_iv1);
        mivitem2 = (ImageView) findViewById(R.id.l8_iv2);
        mbtn1 = (TextView) findViewById(R.id.l8_btn1);
        mbtn2 = (TextView) findViewById(R.id.l8_btn2);
        mtvinfo = (TextView) findViewById(R.id.l8_tv_info);
    }
    public void initData(){
        mtvmoney.setText("剩余金钱：" + rem);
        mivitem1.setImageResource(item1.getImageid());
        mivitem2.setImageResource(item2.getImageid());
        mbtn1.setText(""+item1.getCost());
        mbtn2.setText(""+item2.getCost());
        mtvinfo.setText("");
    }

    public void buy1(View view) {
        int diff = rem - item1.getCost();
        if(diff>=0){
            mtvinfo.setText("你购买了"+item1.getItemName()+"，花费了"+item1.getCost()+"金。");
            rem = diff;
            updatamtvMoney(rem);
        }
        else {
            mtvinfo.setText("你还买不起"+ item1.getItemName()+"，还差"+(-diff)+"金。");
        }
    }

    public void buy2(View view) {
        int diff = rem - item2.getCost();
        if(diff>=0){
            mtvinfo.setText("你购买了"+item2.getItemName()+"，花费了"+item2.getCost()+"金。");
            rem = diff;
            updatamtvMoney(rem);
        }
        else {
            mtvinfo.setText("你还买不起"+ item2.getItemName()+"，还差"+(-diff)+"金。");
        }
    }
    //封装剩余金钱
    public void updatamtvMoney(int newMoney){
        mtvmoney.setText("剩余金钱："+newMoney);

    }
}
