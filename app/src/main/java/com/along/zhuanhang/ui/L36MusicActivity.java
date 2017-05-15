package com.along.zhuanhang.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.TextView;

import com.along.zhuanhang.R;
import com.along.zhuanhang.consts.MusicActions;
import com.along.zhuanhang.service.L36MusicService;
import com.along.zhuanhang.utils.Tools;

import java.io.File;
import java.io.IOException;

public class L36MusicActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private TextView mTvPath;
    private TextView mTvSize;
    private TextView mTvDuration;
    private String mFliePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l36_music);
        initview();
        initplayer();
    }

    private void initview() {
        mTvPath = (TextView) findViewById(R.id.l36_tv_path);
        mTvSize = (TextView) findViewById(R.id.l36_tv_size);
        mTvDuration = (TextView) findViewById(R.id.l36_tv_duration);
    }

    private void initplayer() {
        File parent = Environment.getExternalStoragePublicDirectory("netease");
        String parentPath = parent.getAbsolutePath()+"/cloudmusic/Music";
        Tools.log("文件夹路径："+parentPath);
        File file = new File(parentPath,"ifyou.mp3");
        mFliePath = file.getAbsolutePath();
        Tools.log("文件路径："+mFliePath);
        mTvPath.setText("路径："+mFliePath);
        mTvSize.setText("大小："+(file.length())/1024.00F+"k");
        mMediaPlayer = new MediaPlayer();
        try {
            mMediaPlayer.setDataSource(mFliePath);
            mMediaPlayer.prepare();
            mTvDuration.setText("时长："+(mMediaPlayer.getDuration())/1000.00F+"\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        mMediaPlayer.release();
    }


    public void play(View view) {
        Tools.log("向服务发出play命令");
        Intent intent = new Intent(this, L36MusicService.class);
        intent.setAction(MusicActions.PLAY);
        intent.putExtra("path",mFliePath);
        startService(intent);
    }

    public void pause(View view) {
        Tools.log("向服务发出pause命令");
        Intent intent = new Intent(this, L36MusicService.class);
        intent.setAction(MusicActions.PAUSE);
        startService(intent);
    }

    public void stop(View view) {
        Tools.log("向服务发出stop命令");
        Intent intent = new Intent(this, L36MusicService.class);
        intent.setAction(MusicActions.STOP);
        startService(intent);
    }
}
