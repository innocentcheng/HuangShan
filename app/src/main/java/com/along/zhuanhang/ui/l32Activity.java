package com.along.zhuanhang.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

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
                    Tools.log("异步线程开启");
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
                }catch (UnknownHostException e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Tools.ToastS(l32Activity.this, "无网络请求");
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("along","io err..");
            }
                return null;
            }
        };
        asyncTask.execute(searchKeyword);
    }
    /**
     * AsyncTask 的三个泛型
     * 第一个对应 doInBackground 的参数，和 execute 的参数
     * 第二个对应 onProgressUpdate 的参数，和 publishProgress 的参数
     * 第三个对应 doInBackground 的返回值，和 onPostExecute 的参数
     */
    public void requestC(View view){
        String keyword = mEt.getText().toString();
        AsyncTask<String,String,List<Movie>> asyncTask = new AsyncTask<String,String,List<Movie>>() {
            @Override
            protected void onPreExecute() {
                Tools.log("异步任务开始");
            }

            @Override
            protected List<Movie> doInBackground(String... result) {
                String josnStr = null;
                try {
                    josnStr = requestIMDB(result[0]);
                }
                catch (UnknownHostException e) {
                    publishProgress("网络异常");
                    return null;
                }catch (IOException e) {
                    e.printStackTrace();
                }
                ImdbResult imdbResult = null;
                try {
                    imdbResult = ImdbResult.fill(new JSONObject(josnStr));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Tools.log("responsewaimian:" + imdbResult.getResponse());
                List<Movie> movieList = null;
                if (imdbResult.getResponse().equals("True")){
                    Tools.log("response:" + imdbResult.getResponse());
                    movieList = Movie.fillList(imdbResult.getSearch());
                    Tools.log("movelist: "+ movieList);
                }
                Tools.log("imdbR null: err.." );
                return movieList; // // TODO: 2017/5/9  ???
            }

            @Override
            protected void onProgressUpdate(String... pram) {
                String errMess = pram[0];
                Tools.ToastS(l32Activity.this,errMess);
            }

            @Override
            protected void onPostExecute(List<Movie> movies) {
                Tools.log("movies: "+ movies);
                if (movies==null){
                    Tools.log("moves: " + movies);
                    return;
                }
                try{
                mAdapter = new MovieAdapter(l32Activity.this,movies);
                mLv.setAdapter(mAdapter);
                Tools.log("异步任务结束");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        asyncTask.execute(keyword);
    }


    private String requestIMDB(String keyword) throws IOException {
        String urlAdress = "http://www.omdbapi.com/?s=" + keyword;
        Tools.log("请求的 url：" + urlAdress);
        HttpURLConnection urlConnection;
        URL url = null;
            url = new URL(urlAdress);
        try{
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(10 * 1000);
            urlConnection.setDoInput(true);
            int responsCode = urlConnection.getResponseCode();
            Tools.log("fanhui: " + responsCode);
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
                    Tools.log("result: "+ result);
                    return result;
                }
                catch(IOException e){
                    e.printStackTrace();
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }catch (ConnectException e){
            Tools.log("con err..");
        }
        return null;
    }
}
