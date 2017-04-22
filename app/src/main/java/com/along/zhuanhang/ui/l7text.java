package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.along.zhuanhang.R;
import com.along.zhuanhang.bean.Item;

public class l7text extends AppCompatActivity {

    //b是剩余金钱
    int b = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l7text);
        TextView overplusMoney = (TextView) findViewById(R.id.l7text_tv1);
        overplusMoney.setText("持有金额："+b);
        ImageView iv1 = (ImageView) findViewById(R.id.l7text_iv1);
        iv1.setImageResource(R.mipmap.imagetiaodao);
        ImageView iv2 = (ImageView) findViewById(R.id.l7text_iv2);
        iv2.setImageResource(R.mipmap.imageshengjian);

    }
    public void buy1(View view){
        Item item1 = new Item();
        item1.itemName = "跳刀";
        item1.cost = 2250;
        item1.imageid = R.mipmap.imagetiaodao;
        int diff = b - item1.cost;
        TextView result = (TextView) findViewById(R.id.l7text_tv2);
        TextView overplusMoney = (TextView) findViewById(R.id.l7text_tv1);
        if (diff<0){
            diff = diff * -1;
            result.setText("你还买不起"+item1.itemName+",还差"+diff+"金。");
            }
        else {
            result.setText("你购买了"+item1.itemName+",花费了"+item1.cost+"。");
            overplusMoney.setText("持有金额："+diff);
            b = diff;
        }
    }

    public void buy2(View view) {
        Item item2 = new Item();
        item2.itemName = "圣剑";
        item2.cost = 6200;
        item2.imageid = R.mipmap.imageshengjian;
        int diff = b - item2.cost;
        TextView result = (TextView) findViewById(R.id.l7text_tv2);
        TextView overplusMoney = (TextView) findViewById(R.id.l7text_tv1);
        if (diff<0){
            diff = diff * -1;
            result.setText("你还买不起"+item2.itemName+",还差"+diff+"金。");
        }
        else {
            result.setText("你购买了"+item2.itemName+",花费了"+item2.cost+"。");
            overplusMoney.setText("持有金额："+diff);
            b = diff;
        }
    }
}
