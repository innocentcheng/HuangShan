package com.along.zhuanhang.ui;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.along.zhuanhang.R;
import com.along.zhuanhang.utils.Tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class l23FileActivity extends AppCompatActivity {
    private EditText mInputTv;
    private TextView mInfoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l23);
        inintView();
    }

    private void inintView() {
        mInputTv = (EditText) findViewById(R.id.l23_input_tv);
        mInfoTv = (TextView) findViewById(R.id.l23_info_tv);
    }

    public void save(View view) {
        //获取编辑框输入内容
        Editable editable = mInputTv.getText();
        //将获取的输入框内容转换为String型
        String content = editable.toString();
        //获取要存入的路径
        File mntCache = getExternalCacheDir();
        //新建File类型的file 放入要存的路径，文件的名字
        File file = new File(mntCache,"L23.txt");
        //创建一个new的输出流 out（相当于一个传输管道）；管道另一头填你要存放的file=你要存放的位置和文件名字
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            //把内容（转换成字节）写入
            out.write(content.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
        //关闭输出流
        Tools.closeStream(out);
    }

    public void load(View view) {
        //获取你要读取的路径
        File mntCache = getExternalCacheDir();
        //新建一个File型的file 填要读取的文件的路径和名字
        File file = new File(mntCache,"L23.txt");
        //新建一个输出流
        FileInputStream input = null;
        //新建一个字节数组 设定每次读取的字节长度
        byte[]readBytes = new byte[6];
        String content = "";
        try {
            //将file（相当于要读取文件的路径和名字）放到输出管道
            input = new FileInputStream(file);
            //这个长度等于每次实际读到的字节长度
            int length ;
            //如果读到的内容字节长度等于-1代表读完了 不等于-1的时候每次读取自己设置的长度然后通过新建一个字符串拼起来
            while ((length=input.read(readBytes)) != -1){
                //最后一次读取有可能只替代前面 设置读取偏移量 每次只取实际读到的字节长度放入字符串
                String currentContent = new String(readBytes,0,length);
                //内容拼接
                content = content + currentContent;
                Tools.log("length:"+length+"   cur:"+currentContent);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        Tools.closeStream(input);
        mInfoTv.setText(content);
    }
    public void seePath(View v) {
        File cacheDir = getCacheDir();
        File filesDir = getFilesDir();
        File extCacheDir = getExternalCacheDir();
        File extFilesDir = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        File rootDir = Environment.getRootDirectory();
        File dataDir = Environment.getDataDirectory();
        File downloadCacheDir = Environment.getDownloadCacheDirectory();
        File extStoragePublicDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        String buffer = "cacheDir: " + cacheDir.getAbsolutePath()
                + "\n\n filesDir: " + filesDir.getAbsolutePath()
                + "\n\n extCacheDir: " + extCacheDir.getAbsolutePath()
                + "\n\n extFilesDir: " + extFilesDir.getAbsolutePath()
                + "\n\n rootDir: " + rootDir.getAbsolutePath()
                + "\n\n dataDir: " + dataDir.getAbsolutePath()
                + "\n\n downloadCacheDir: " + downloadCacheDir.getAbsolutePath()
                + "\n\n extStoragePublicDir: " + extStoragePublicDir.getAbsolutePath();
        mInfoTv.setText(buffer);
    }
}

