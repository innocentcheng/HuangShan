package com.along.zhuanhang.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.Closeable;
import java.io.IOException;


public class Tools {
    public static void closeStream(Closeable stream){
        try {
            if (stream!=null){
            stream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void ToastS(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
    public static void ToastL(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

    public static void log(String logMessage){
        Log.d("aloong",logMessage);
    }

}
