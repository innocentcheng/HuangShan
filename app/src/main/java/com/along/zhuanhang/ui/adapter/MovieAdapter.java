package com.along.zhuanhang.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.along.zhuanhang.R;
import com.along.zhuanhang.ui.Movie;
import com.along.zhuanhang.utils.Tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by aloong on 2017/5/1.
 */

public class MovieAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<Movie> mMovieList;
    private LayoutInflater mInflater;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.mContext = context;
        this.mMovieList = movies;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mMovieList.size();
    }

    @Override
    public Movie getItem(int position) {
        return mMovieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        Movie movie = mMovieList.get(position);
        String id = movie.getmImdbId();
        id = id.substring(2, id.length());
        return Long.parseLong(id);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = mInflater.inflate(R.layout.l32_movie_adapter, parent, false);
            holder.mPosterIv = (ImageView) convertView.findViewById(R.id.l32_adapter_iv);
            holder.mTitleTv = (TextView) convertView.findViewById(R.id.l32_adapter_tv_title);
            holder.mYearTv = (TextView) convertView.findViewById(R.id.l32_adapter_tv_year);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        final Movie movie = mMovieList.get(position);
        holder.mTitleTv.setText(movie.getmTitle());
        holder.mYearTv.setText(movie.getmYear());
        handlePoster(holder.mPosterIv,movie);
        return convertView;
    }
    private void handlePoster(final ImageView imageView, final Movie movie){
        if (movie.getmPosterBitmap() == null){
            imageView.setImageResource(R.mipmap.ic_launcher);
            final  String urlAddress = movie.getmPosterUrl();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        final Bitmap bitmap = downloadPoster(urlAddress);
                        movie.setmPosterBitmap(bitmap);
                        bindBitmap(imageView,bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }else {
            imageView.setImageBitmap(movie.getmPosterBitmap());
        }
    }
    private void bindBitmap (final ImageView imageView, final Bitmap bitmap){
        if (bitmap!=null){
            if (mContext instanceof Activity){
                Activity activity = (Activity) mContext;
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }
    private Bitmap downloadPoster(String posterUrl) throws IOException {
       posterUrl = posterUrl.replace("300.jpg", "100.jpg");
        Tools.log("圖片地址"+posterUrl);
        URL url = new URL(posterUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setConnectTimeout(10 * 1000);
        urlConnection.setDoInput(true);
        int responseCode = urlConnection.getResponseCode();
        if (responseCode == 200) {
            InputStream inputStream = null;
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                inputStream = urlConnection.getInputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }
                    byte[] writeBytes = outputStream.toByteArray();
                    return BitmapFactory.decodeByteArray(writeBytes, 0, writeBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private class Holder {
        ImageView mPosterIv;
        TextView mTitleTv;
        TextView mYearTv;
    }


}
