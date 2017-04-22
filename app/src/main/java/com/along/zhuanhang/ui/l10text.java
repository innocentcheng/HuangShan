package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.along.zhuanhang.R;

public class l10text extends AppCompatActivity {

    private Button mbtn;
    private int mtime = 10;
    public  int click = 1;
    public l10text thisActivity ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l10text);
        mbtn = (Button) findViewById(R.id.l10text_btn);
        mbtn.setText("捉五魁");

    }

    public void l10textClick(View view) {
        click =click * -1;
        Thread thread = new Thread(new thread2());
        thread.start();
    }

    private class thread2 implements Runnable{
        @Override
        public void run() {
                while (click<0){
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    if(click<0 ){
                        if(mtime>0){
                            mtime = mtime - 1;
                        }else {
                            mtime = 9;
                        }
                        runOnUiThread(new changeNumer());

                    }else{
                        runOnUiThread(new showToast());
                    }
                }
        }
    }

    private class showToast implements Runnable{
        @Override
        public void run() {
            if(mtime==5) {
                Toast.makeText(thisActivity,"成功捉到五魁",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class changeNumer implements Runnable{
        @Override
        public void run() {
                mbtn.setText(mtime+"");
        }
    }
}
