package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.along.zhuanhang.R;

public class L9Thread extends AppCompatActivity {
    private TextView mTv;
    private Button mbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l9_thread);

        initView();
    }
    private void initView(){
        mTv = (TextView) findViewById(R.id.l9_tv);
        mbtn = (Button) findViewById(R.id.l9_btn);
    }

    public void changeTvTimer(View view) {
        Thread thread = new Thread( new secondThread());
        thread.start();
        mTv.setText("劳资最最最最最屌");
    }
    private class secondThread implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5*1000);
            }catch (InterruptedException exceptiom){
                exceptiom.printStackTrace();
            }
            runOnUiThread(new secondRunnable());

        }
    }
    private  class secondRunnable implements Runnable{
        @Override
        public void run() {
            mTv.setText("屌不过5秒");
        }
    }
}
