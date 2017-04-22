package com.along.zhuanhang.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.along.zhuanhang.R;

import java.util.Random;

public class l3random extends AppCompatActivity {
    int a;
    int b;
    int c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l3random);
    }

    public void random(View view) {
        TextView alongnum = (TextView) findViewById(R.id.alongrd_tv);
        TextView MCnum = (TextView) findViewById(R.id.MCrd_tv);
        TextView adannum = (TextView) findViewById(R.id.adanrd_tv);
        a = new Random().nextInt(101);
        b = new Random().nextInt(101);
        c = new Random().nextInt(101);
        alongnum.setText("阿龙:"+ a);
        MCnum.setText("MC:"+ b);
        adannum.setText("啊淡:"+ c);
    }

    public void nextLv4(View view) {
        Intent intent = new Intent();
        intent.setClass(this,l4Activity.class);
        startActivity(intent);
    }
}
