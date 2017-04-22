package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.along.zhuanhang.R;

import java.util.Random;

public class l6activity extends AppCompatActivity {
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l6activity);
    }

    public void changeimage(View view) {
        //将需要的图片放入数组中
        int[] array = new int[3];
        array[0] = R.mipmap.image01;
        array[1] = R.mipmap.image02;
        array[2] = R.mipmap.image03;
        // 随机一个数组中的序号
        int index = new Random().nextInt(3);
        // 获取iv
        ImageView l6FirstImg = (ImageView) findViewById(R.id.l6_iv);
        //设置一张新图
        l6FirstImg.setImageResource(array[index]);
    }
}
