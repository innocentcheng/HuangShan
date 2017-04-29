package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.along.zhuanhang.R;
import com.along.zhuanhang.utils.Tools;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class l32Activity extends AppCompatActivity {
    private EditText mEt;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l32);
        initView();
    }

    private void initView() {
        mEt = (EditText) findViewById(R.id.l32_et);
        mTv = (TextView) findViewById(R.id.l32_tv);
    }

    public void request(View view) {
        Tools.log("拿到" + mEt.getText().toString());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Tools.log("线程开启");
                    final String result = requestIMDB(mEt.getText().toString());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTv.setText(result);
                        }
                    });
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Tools.ToastS(l32Activity.this, "111");
                        }
                    });
                }
            }
        }).start();
    }

    private String requestIMDB(String keyword) throws IOException {
        String urlAdress = "http://www.omdbapi.com/?s=" + keyword;
        Tools.log("请求的 url：" + urlAdress);
        URL url = new URL(urlAdress);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setConnectTimeout(10 * 1000);
        urlConnection.setDoInput(true);
        int responsCode = urlConnection.getResponseCode();
        Tools.log("" + responsCode);
        if (responsCode == 200) {
            InputStream inputStream = null;
            String result = "";
            try {
                inputStream = urlConnection.getInputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    result += new String(buffer, 0, len);
                }
                return result;
            } catch (IOException ioep) {
                ioep.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception ioep) {
                        ioep.printStackTrace();
                    }
                }
            }
        }
                    return null;
    }
}
