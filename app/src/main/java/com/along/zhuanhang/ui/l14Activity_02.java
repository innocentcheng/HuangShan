package com.along.zhuanhang.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.along.zhuanhang.R;

import java.util.Random;

public class l14Activity_02 extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l14_02);
        Intent dataIntent = getIntent();
        int remMoney =dataIntent.getIntExtra("putSum",0);
        int num =dataIntent.getIntExtra("putGeShu",0);
        String words =dataIntent.getStringExtra("putLiuYan");
        if(remMoney==0||num==0){
            Toast.makeText(this,"没钱发自拔",Toast.LENGTH_SHORT).show();
            return;
        }

        TextView tv01 = (TextView) findViewById(R.id.l14act02_tv01);
        tv01.setText(words);

        TextView tv02 = (TextView) findViewById(R.id.l14act02_tv02);
        tv02.setText(num+"个红包共"+remMoney+"元");

        mListView = (ListView) findViewById(R.id.l14act02_lv);
        String[] nameArray = new String[num];
        remMoney = remMoney * 100;
        for (int remNum=num;remNum>0;remNum--){
            int getMoney;
            if(remNum==1){
                getMoney = remMoney;
            }else {
            //int x = remMoney/num;
            getMoney = new Random().nextInt(remMoney- remNum +1)+1;
            remMoney = remMoney - getMoney;
            }
                nameArray[remNum-1] = "第"+remNum+"个人                          "+getMoney/100+"元";
        }
        ArrayAdapter<String> nameArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,nameArray);
        mListView.setAdapter(nameArrayAdapter);
    }
}
