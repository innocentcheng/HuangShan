package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.along.zhuanhang.R;

public class l4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 文本框输入加显示
     */
    public void getEtNam(View view) {
        //getwenbenkuang
        EditText kuang = (EditText)findViewById(R.id.l4_et);
        //getwenbenkuangneirong
        Editable neirong = kuang.getText();
        String newnam = neirong.toString();
        //jiagongwenbenkuangneirong
        newnam = "欢迎" + newnam + "来到新世界！~~";
        //Toast dispaly wenbenkuangneirong
        Toast.makeText(this,newnam,Toast.LENGTH_LONG).show();
    }

    /**
     *
     * change String to Int
     */
    public void changestrtoint(View view) {
        EditText inputnum = (EditText) findViewById(R.id.l4_et_num);
        Editable a = inputnum.getText();
        String zifuchuan = a.toString();
        //把string解析成int
        int b = Integer.parseInt(zifuchuan);
        int c = b * 2;
        Toast.makeText(this, "double " + b + "=" + c, Toast.LENGTH_SHORT).show();
    }
}
