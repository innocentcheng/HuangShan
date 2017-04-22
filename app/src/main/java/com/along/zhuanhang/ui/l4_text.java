package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.along.zhuanhang.R;

import java.util.Random;

public class l4_text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l4_text);
    }

    public void rdnum(View view) {
        //获取文本框
        EditText kuang = (EditText) findViewById(R.id.l4text_et);
        //获取文本框内容
        Editable neirong = kuang.getText();
        String nrzifuchuan = neirong.toString();
        //把STRING变INT
        int a = Integer.parseInt(nrzifuchuan);
        //随机一个小于INT数字的数
        int b =new Random().nextInt(a);
        //把随机出来的数字展示在TV上
        TextView result = (TextView) findViewById(R.id.l4text_tv);
        result.setText("你roll出了"+b + "点范围是（0-" + a + ")");
    }
}
