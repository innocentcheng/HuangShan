package com.along.zhuanhang.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.along.zhuanhang.R;

public class l5_b extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5_b);
        //获取intent
        Intent dataintent = getIntent();
        //获取intentExtra
        int a = dataintent.getIntExtra("putintnam",0);
        String b = dataintent.getStringExtra("putstrnam");
        //获取tv
        TextView l5_b = (TextView) findViewById(R.id.l5_b_tvnam);
        //将获取的数据展示在tv上
        l5_b.setText(a + "\n"+ b);
    }
}
