package com.along.zhuanhang.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.along.zhuanhang.R;

public class l5_text_03 extends AppCompatActivity {
    int daan1;
    int daan2;
    int daan3;
    int btnnanme;
    TextView jieguo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5_text_03);
        huoqushangyiye();
        bidaxiao();
        }
    public void huoqushangyiye(){
        //获取上一页的intent
        Intent l5t2data = getIntent();
        //获取intentExtra
        daan1 = l5t2data.getIntExtra("wujiang1",0);
        daan2 = l5t2data.getIntExtra("wujiang2",0);
        daan3 = l5t2data.getIntExtra("wujiang3",0);
        btnnanme = l5t2data.getIntExtra("btn",0);
        //获取tv
        jieguo = (TextView) findViewById(R.id.panduan);
    }
    public  void bidaxiao(){
        //比大小
        if (daan1>daan2 && daan1>daan3){
            switch (btnnanme){
                case 1:
                    jieguo.setText("正确");
                    break;
                case 2:
                    jieguo.setText("错误");
                    break;
                case 3:
                    jieguo.setText("错误");
                    break;
            }
        }
        if(daan2>daan1 && daan2>daan3){
            switch (btnnanme){
                case 1:
                    jieguo.setText("错误");
                    break;
                case 2:
                    jieguo.setText("正确");
                    break;
                case 3:
                    jieguo.setText("错误");
                    break;
            }
        }
        if(daan3>daan1 && daan3>daan2){
            switch (btnnanme){
                case 1:
                    jieguo.setText("错误");
                    break;
                case 2:
                    jieguo.setText("错误");
                    break;
                case 3:
                    jieguo.setText("正确");
                    break;
            }
        }
    }
    }
