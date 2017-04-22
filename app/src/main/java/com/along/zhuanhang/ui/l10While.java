package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.along.zhuanhang.R;

public class l10While extends AppCompatActivity {
    private Button mBtn;
    private int mtime = 6;
    private boolean mClick = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l10_while);

        mBtn = (Button) findViewById(R.id.l10_btn);
        mBtn.setText("Start");
    }

    public void l10_onClick(View view) {
        if(mClick){
            mtime = 6;
            Thread thread = new Thread(new thread2());
            thread.start();
        }
    }

    private class thread2 implements Runnable{
        @Override
        public void run() {
            mClick = false;
            while (mtime>0){
                try {
                    Thread.sleep(1*1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                mtime = mtime - 1;
                runOnUiThread(new changeBtnNumer());
            }
            mClick = true;

        }
    }

    private class changeBtnNumer implements Runnable{
        @Override
        public void run() {
            mBtn.setText(mtime+"");
        }
    }
}
