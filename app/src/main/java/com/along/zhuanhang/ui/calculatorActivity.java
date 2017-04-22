package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.along.zhuanhang.R;

public class calculatorActivity extends AppCompatActivity {
    private TextView mTv;
    String mNumStr = "";
    String mInfo;
    int way = 0;
    int beforComputeData =0;
    int num1=0;
    int num2=0;
    int mResult=0;
    boolean firstClick=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        mTv = (TextView) findViewById(R.id.calculator_result);
    }

    public void click_btn1(View view) {
        mNumStr = mNumStr + "1";
        mInfo = mNumStr;
        mTv.setText(mInfo);
    }

    public void click_btn2(View view) {
        mNumStr = mNumStr + "2";
        mInfo = mNumStr;
        mTv.setText(mInfo);
    }


    public void click_add(View view) {
        way = 1;
            num1 = Integer.parseInt(mNumStr);
        if(firstClick==true){
            beforComputeData = num1;
            mNumStr = "";
            mInfo = mNumStr;
            mTv.setText(mInfo);
            firstClick=false;
        }else {
            num1= beforComputeData +num1;
            beforComputeData = num1;
            mNumStr="";
            mInfo=""+ beforComputeData;
            mTv.setText(mInfo);
        }
    }
    private void add(int numBefor,int numAfter){
        numBefor=num1;
        numAfter=num2;
        mResult = numBefor+numAfter;
        Log.d("calculator",""+mResult);
    }


    public void click_reduce(View view) {
        num1 = Integer.parseInt(mNumStr);
        if(firstClick==true){
        way = 2;
        mNumStr = "";
        mInfo = mNumStr;
        mTv.setText(mInfo);
        }else {
            num1= beforComputeData -num1;
            beforComputeData = num1;
            mNumStr="";
            mInfo=""+ beforComputeData;
            mTv.setText(mInfo);
        }
    }
    private void reduce(int numBefor,int numAfter){
        numBefor=num1;
        numAfter=num2;
        mResult = numBefor-numAfter;
    }
    public void result(View view) {
        num2 = Integer.parseInt(mNumStr);
        switch (way){
            case 1:
                add(num1,num2);
                break;
            case 2:
                reduce(num1,num2);
                break;
        }
        mTv.setText(""+mResult);
        cleanData();
    }
    private void  cleanData(){
        mNumStr="";
        firstClick=true;
        mInfo=mNumStr;
        num1=0;
        num2=0;
        mResult=0;
    }

    public void clean(View view) {
        cleanData();
        mTv.setText(""+mResult);
    }
}
