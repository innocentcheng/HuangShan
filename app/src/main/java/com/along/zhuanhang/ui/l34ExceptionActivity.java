package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.along.zhuanhang.R;

import java.net.ConnectException;

public class l34ExceptionActivity extends AppCompatActivity {
    private int mCost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l34_exception);
    }
    public void catchCustom(View view) {
        try {
            playCard();
        } catch (CustumException e) {
            e.printStackTrace();
        }
    }
    private int playCard() throws CustumException {
        if (mCost <= 0) {
            throw new CustumException();
        }
        int currentCardCost = 4;
        if (mCost >= currentCardCost) {
            mCost = mCost - currentCardCost;
        }
        return mCost;
    }
}
