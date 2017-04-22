package com.along.zhuanhang.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.along.zhuanhang.R;

public class l2Tv extends AppCompatActivity {
        int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l2_tv);

    }

    public void addnum(View view) {
        a = a + 1;
        TextView num = (TextView) findViewById(R.id.l2_tv);
        num.setText(a + "");
    }


    public void nextLv3(View view) {
        Intent intent = new Intent();
        intent.setClass(this,l3random.class);
        startActivity(intent);
    }
}
