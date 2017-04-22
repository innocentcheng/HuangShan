package com.along.zhuanhang.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import com.along.zhuanhang.R;

public class l5_text_01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5_text_01);
    }

    public void creatnam(View view) {
        //获取文本框
        EditText kuang = (EditText) findViewById(R.id.nam_et);
        //获取文本框内容
        Editable name = kuang.getText();
        String neirong = name.toString();
        //构建一个意图
        Intent intentzero = new Intent();
        //给意图指定一个跳转页
        intentzero.setClass(this,l5_text_02.class);
        //将需要传输的数据(文本框内容)放入intent
        intentzero.putExtra("putplayername",neirong);
        //执行跳转
        startActivity(intentzero);
    }
}
