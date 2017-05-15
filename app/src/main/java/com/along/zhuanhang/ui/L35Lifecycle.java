package com.along.zhuanhang.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.along.zhuanhang.R;
import com.along.zhuanhang.bean.GameTeam;
import com.along.zhuanhang.utils.Tools;

public class L35Lifecycle extends AppCompatActivity {
    private TextView mTvBlue;
    private TextView mTvRed;
    private int a;
    private int b;
    private boolean change = false;
    private GameTeam red;
    private GameTeam blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l35_lifecycle);
        initView();
        red = new GameTeam();
        int numRed = red.getScore();
        mTvRed.setText(numRed + "");
        blue = new GameTeam();
        int numblue = blue.getScore();
        mTvBlue.setText(numblue + "");
    }

    @Override
    protected void onStart() {
        super.onStart();
        change = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!change) {
                    Tools.log("线程开启");
                    a = red.getScore();
                    b = blue.getScore();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTvRed.setText(a + "");
                            mTvBlue.setText(b + "");
                        }
                    });
                    sleep(1);
                }
                    Tools.log("线程关闭");
            }
        }).start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        change = true;
    }

    private void initView() {
        mTvBlue = (TextView) findViewById(R.id.l35_tv_blue);
        mTvRed = (TextView) findViewById(R.id.l35_tv_red);
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterL35_2(View view) {
        Intent intent = new Intent(this, L35Lifecycle2.class);
        //intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
