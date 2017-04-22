package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.along.zhuanhang.R;

public class l17Activity extends AppCompatActivity {

    private EditText met;
    private TextView mtv;
    private Button mbtn;
    private int daxie;
    private int xiaoxie;
    private int qita=0;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l17);
        initView();
    }

    private void initView() {
        met = (EditText) findViewById(R.id.l17_et);
        mtv = (TextView) findViewById(R.id.l17_tv);
        mbtn = (Button) findViewById(R.id.l17_btn);


    }

    public void resolution(View view) {
        Editable neirong = met.getText();
        String str = neirong.toString();
        char[] nameArray = str.toCharArray();
        for(int i=0;i<nameArray.length;i++){
            if(nameArray[i]>='A'&nameArray[i]<='Z'){
                daxie = daxie + 1;
            }else if(nameArray[i]>='a'&nameArray[i]<='z'){
                xiaoxie = xiaoxie + 1;
            }else if(nameArray[i]>='0'&nameArray[i]<='9'){
                num = num +1;
            }else {
                qita = qita +1;
            }
        }
        mtv.setText("大写字母："+daxie+"\n"+"小写字母："+xiaoxie+"\n"+"数字："+num+"\n"+"其他字符："+qita+"\n");
        daxie=0;
        xiaoxie=0;
        qita=0;
        num=0;
    }
}
