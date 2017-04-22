package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.along.zhuanhang.R;

import java.util.Timer;

public class l9text extends AppCompatActivity {

    private TextView mTv;
    private TextView mTv2;
    int a;
    boolean isStart ;
    boolean click;
    private l9text thisActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l9text);

        thisActivity = this;
        initview();
        intData();
        click = true;

    }
    private void initview(){
        mTv = (TextView) findViewById(R.id.l9text_tv);
        mTv2 = (TextView) findViewById(R.id.l9text_tv2);
    }

    private void intData(){
        mTv.setText(a+"");
        mTv2.setText("");
    }

    public void clear(View view) {
        if(click){
            //
        }else {
            a = 0;
            mTv.setText(a+"");
            click = true;
            mTv2.setText("");
            isStart = false;
        }

    }

    public void startTimer(View view) {

        if(click){
            a = a + 1;
            mTv.setText(a+"");

            if(isStart){
                //
            }else {
                Thread thread = new Thread(new timer());
                thread.start();
                isStart = true;
            }

        }
    }

    private class timer implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(3*1000);
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
            runOnUiThread(new changeUiThread());
        }
    }

    private  class changeUiThread implements Runnable{
        @Override
        public void run() {
            click = false;
            mTv2.setText("时间到！");
        }
    }
}
