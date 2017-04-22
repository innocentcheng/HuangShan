package com.along.zhuanhang.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.along.zhuanhang.R;

public class l5_a extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5_a);
    }

    public void enternext(View view) {
        //构建一个意图
        Intent intent = new Intent();
        //给意图指定一个跳转页
        intent.setClass(this,l5_b.class);
        //将需要传输的数据放入intent
        intent.putExtra("putintnam",619);
        intent.putExtra("putstrnam","撸咬揪");
        //执行跳转
        startActivity(intent);
    }
}
