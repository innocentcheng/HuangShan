package com.along.zhuanhang.ui;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.along.zhuanhang.R;
import com.along.zhuanhang.ui.adapter.MovieAdapter;
import com.along.zhuanhang.utils.Tools;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Objects;

public class l32Activity extends AppCompatActivity {
    private EditText mEt;
    private ListView mLv;
    private MovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l32);
        initView();
    }

    private void initView() {
        mEt = (EditText) findViewById(R.id.l32_et);
        mLv = (ListView) findViewById(R.id.l32_lv);
    }

    public void request(View view) {
        final String searchKeyword = mEt.getText().toString();
        Tools.log("拿到" + mEt.getText().toString());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Tools.log("线程开启");
                    String josn = requestIMDB(searchKeyword);
                    Tools.log("啊search:" + josn);
                    ImdbResult imdbResult = ImdbResult.fill(new JSONObject(josn));
                    final List<Movie> movies = Movie.fillList(imdbResult.getSearch());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new MovieAdapter(l32Activity.this, movies);
                            mLv.setAdapter(mAdapter);
                        }
                    });
                } catch (MalformedURLException | JSONException e) {
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

    public void requestB(View view) {
        final String searchKeyword = mEt.getText().toString();
        Tools.log("拿到" + mEt.getText().toString());
        AsyncTask<String, String, String> asyncTask = new AsyncTask<String, String, String>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected String doInBackground(String... params) {
                try {
                    Tools.log("线程开启");
                    String josn = requestIMDB(params[0]);
                    Tools.log("啊search:" + josn);
                    ImdbResult imdbResult = ImdbResult.fill(new JSONObject(josn));
                    if (Objects.equals(imdbResult.getResponse(), "True")) {
                        final List<Movie> movies = Movie.fillList(imdbResult.getSearch());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mAdapter = new MovieAdapter(l32Activity.this, movies);
                                mLv.setAdapter(mAdapter);
                            }
                        });
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                             Tools.ToastS(l32Activity.this,"未找到");
                            }
                        });
                        return null;
                    }
                } catch (MalformedURLException | JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Tools.ToastS(l32Activity.this, "111");
                        }
                    });
                }
                return null;
            }
        };
        asyncTask.execute(searchKeyword);
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
            String result;
            try {
                inputStream = urlConnection.getInputStream();
                byte[] buffer = new byte[1024];
                int len;
                result = "";
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
