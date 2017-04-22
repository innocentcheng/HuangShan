package com.along.zhuanhang.ui;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.along.zhuanhang.R;
import com.along.zhuanhang.utils.Tools;

import java.util.ArrayList;

public class l29ProgressActivity extends AppCompatActivity {
    private ProgressBar mProgressBarHor;
    private ProgressBar mProgressBarCircle;
    private int mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l29_progress);
        inintview();
    }

    private void inintview() {
        mProgressBarHor = (ProgressBar) findViewById(R.id.l29_pb_hor);
        mProgressBarCircle = (ProgressBar) findViewById(R.id.l29_pb_circle);
    }

    public void oldDownload(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgress<100){
                    sleep(1);
                    mProgress+=20;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBarHor.setProgress(mProgress);
                            mProgressBarHor.setSecondaryProgress(mProgress*2);
                        }
                    });
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Tools.ToastS(l29ProgressActivity.this,"下载完毕");
                    }
                });
            }
        }).start();
    }
    private void sleep (int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startDownload(View view) {
        AsyncTask<Integer, Integer, Integer> asyncTask = new AsyncTask<Integer, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                Tools.ToastS(l29ProgressActivity.this,"start");
            }

            @Override
            protected Integer doInBackground(Integer... params) {
                while (mProgress<100) {
                    sleep(1);
                    mProgress += 20;
                    publishProgress(mProgress);
                }
                return mProgress;
            }

            @Override
            protected void  onProgressUpdate(Integer... values){
                mProgressBarHor.setProgress(values[0]);
                mProgressBarHor.setSecondaryProgress(values[0]*2);
                }

            @Override
            protected void onPostExecute(Integer result) {
                Tools.ToastS(l29ProgressActivity.this,"OK");
            }
        };
        asyncTask.execute(666);
    }

    public void popupProgressDialogDownload(View view) {
        new AsyncTask<Integer,Integer,Integer>(){
            ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                dialog = new ProgressDialog(l29ProgressActivity.this);
                dialog.setCancelable(false);
                dialog.setTitle("纯洁的弹窗");
                dialog.setMessage("等一哈子");
                dialog.show();
            }

            @Override
            protected Integer doInBackground(Integer... params) {
                sleep(3);
                return null;
            }

            @Override
            protected void onPostExecute(Integer integer) {
                dialog.dismiss();
            }
        }.execute(888);
    }
}
