package com.along.zhuanhang.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.along.zhuanhang.R;

public class l14Activity extends AppCompatActivity {

    private TextView mTv1;
    private EditText mEt1;
    private EditText mEt2;
    private EditText mEt3;
    private Button mbtn;
    String mesString;
    int sum;
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l14);

        initview();

    }


    private void initview(){
        mTv1 = (TextView)findViewById(R.id.l14_tv1);
        mEt1 = (EditText) findViewById(R.id.l14_et1);
        mEt2 = (EditText) findViewById(R.id.l14_et2);
        mEt3 = (EditText) findViewById(R.id.l14_et3);
        mbtn = (Button) findViewById(R.id.l14_btn);
    }



    public void sentMoney(View view) {
        Editable jinE = mEt1.getText();
        String jinEString = jinE.toString();
        if(jinEString.length()==0){
            Toast.makeText(this,"请塞钱进红包",Toast.LENGTH_SHORT).show();
            return;
        }
        sum = Integer.parseInt(jinEString);

        Editable person = mEt2.getText();
        String personString = person.toString();
        if(personString.length()==0){
            Toast.makeText(this,"请输入人数",Toast.LENGTH_SHORT).show();
            return;
        }
        n = Integer.parseInt(personString);
        if(n>sum){
            Toast.makeText(this,"每个人至少分到1块钱",Toast.LENGTH_SHORT).show();
            return;
        }

        Editable message = mEt3.getText();
        mesString = message.toString();
        Intent intent = new Intent();
        intent.setClass(this,l14Activity_02.class);
        intent.putExtra("putSum",sum);
        intent.putExtra("putGeShu",n);
        intent.putExtra("putLiuYan",mesString);
        startActivity(intent);
    }
}
