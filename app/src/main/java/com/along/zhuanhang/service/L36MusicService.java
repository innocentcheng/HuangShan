package com.along.zhuanhang.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;

import com.along.zhuanhang.consts.MusicActions;
import com.along.zhuanhang.utils.Tools;

import java.io.File;
import java.io.IOException;

public class L36MusicService extends Service implements MediaPlayer.OnCompletionListener {
    private MediaPlayer mMediaPlayer;
    private boolean release = true;

    public L36MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();
        switch (action){
            case MusicActions.PLAY:
                play(intent.getStringExtra("path"));
                break;
            case MusicActions.PAUSE:
                pause();
                break;
            case MusicActions.STOP:
                stop();
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void play(String path) {
        Tools.log("释放了没："+release);
        File file = new File(path);
        if (release){
            mMediaPlayer = new MediaPlayer();
            try {
                if (file.exists()){
                    mMediaPlayer.setOnCompletionListener(this);
                    mMediaPlayer.setDataSource(path);
                    mMediaPlayer.prepare();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            release=false;
        }
            mMediaPlayer.start();
    }

    private void pause() {
        if (!release){
        mMediaPlayer.pause();
        }else {
        }
    }
    private void stop() {
        if (!release){
        mMediaPlayer.reset();
        mMediaPlayer.release();
        release=true;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mMediaPlayer.stop();
    }
}
