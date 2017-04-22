package com.along.zhuanhang.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.along.zhuanhang.R;

public class l1Toast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l1);
    }

    public void display1(View view) {
        Toast.makeText(this,"点击了第一个按钮",Toast.LENGTH_SHORT).show();
    }
    public void display2(View view) {
        Toast.makeText(this,"点击了第二个按钮",Toast.LENGTH_SHORT).show();
    }
    public void display3(View view) {
        Toast.makeText(this,"点击了第三个按钮",Toast.LENGTH_SHORT).show();
    }

    public void nextLv(View view) {
        Intent intent = new Intent();
        intent.setClass(this,l2Tv.class);
        startActivity(intent);
    }
}
