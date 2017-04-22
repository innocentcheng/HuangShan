package com.along.zhuanhang.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.along.zhuanhang.R;

import java.util.Random;

public class l5_text_02 extends AppCompatActivity {
    int a;
    int b;
    int c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5_text_02);
        displayQuestion();
        displayAnswer();

    }
    public void chooseone(View view) {
        //创建一个意图
    Intent xuanxiang1 = new Intent();
    //给意图指定一个跳转页
    xuanxiang1.setClass(this,l5_text_03.class);
    //将需要传输的数据放入intent
        xuanxiang1.putExtra("wujiang1",a);
        xuanxiang1.putExtra("wujiang2",b);
        xuanxiang1.putExtra("wujiang3",c);
        xuanxiang1.putExtra("btn",1);
    //执行跳转
    startActivity(xuanxiang1);
}

    public void choosetwo(View view) {
        //创建一个意图
        Intent xuanxiang2 = new Intent();
        //给意图指定一个跳转页
        xuanxiang2.setClass(this,l5_text_03.class);
        //将需要传输的数据放入intent
        xuanxiang2.putExtra("wujiang1",a);
        xuanxiang2.putExtra("wujiang2",b);
        xuanxiang2.putExtra("wujiang3",c);
        xuanxiang2.putExtra("btn",2);
        //执行跳转
        startActivity(xuanxiang2);
    }

    public void choosetthree(View view) {
        //创建一个意图
        Intent xuanxiang3 = new Intent();
        //给意图指定一个跳转页
        xuanxiang3.setClass(this,l5_text_03.class);
        //将需要传输的数据放入intent
        xuanxiang3.putExtra("wujiang1",a);
        xuanxiang3.putExtra("wujiang2",b);
        xuanxiang3.putExtra("wujiang3",c);
        xuanxiang3.putExtra("btn",3);
        //执行跳转
        startActivity(xuanxiang3);
    }
    public void displayQuestion(){
        //获取上一页intent
        Intent l5text1data = getIntent();
        //获取上一页intentExtra
        String l5t1neirong = l5text1data.getStringExtra("putplayername");
        //把上一页获得的数据展示在tv上
        TextView l5texttv = (TextView) findViewById(R.id.xuanren);
        l5texttv.setText("HI! "+ l5t1neirong + "，请挑选出你的最强武将！");
    }
    public void displayAnswer(){
        //随机wj1数字
        a = new Random().nextInt(100);
        //随机数字显示在按钮上
        TextView wj1name = (TextView) findViewById(R.id.wujiang_01);
        wj1name.setText("选我我最强：" + a);
        //随机wj2数字
        b = new Random().nextInt(100);
        //随机数字显示在按钮上
        TextView wj2name = (TextView) findViewById(R.id.wujiang_02);
        wj2name.setText("选我我最屌：" + b);
        //随机wj3数字
        c = new Random().nextInt(100);
        //随机数字显示在按钮上
        TextView wj3name = (TextView) findViewById(R.id.wujiang_03);
        wj3name.setText("选我我无敌：" + c);
    }

}
