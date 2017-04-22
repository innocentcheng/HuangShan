package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.along.zhuanhang.R;

import java.util.Random;

public class l11text extends AppCompatActivity {

    private ListView mListView;
    int i;
    int [] atkArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l11text);

        mListView = (ListView) findViewById(R.id.l11text_lv);

        String[] nameArray = new String[15];
        atkArray = new int[15];
        nameArray[0] =  "安度因";
        nameArray[1] =  "杜隆坦";
        nameArray[2] =  "瓦里安";
        nameArray[3] =  "吉安娜";
        nameArray[4] =  "玛法里奥";
        nameArray[5] =  "萨尔";
        nameArray[6] =  "雷克萨";
        nameArray[7] =  "无比雄壮";
        nameArray[8] =  "无辜诚哥";
        nameArray[9] =  "卡德加";
        nameArray[10] = "麦迪文";
        nameArray[11] = "古尔丹";
        nameArray[12] = "阿莱克死斯塔";
        nameArray[13] = "阿尔萨斯";
        nameArray[14] = "加尔鲁什地狱咆哮";

        for(int m=0;m<15;m=m+1){
            i = new Random().nextInt(10);
            nameArray[m] = nameArray[m] + i;
            atkArray[m] = i;
        }

        ArrayAdapter nameArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,nameArray);

        mListView.setAdapter(nameArrayAdapter);

        mListView.setOnItemClickListener(new clickListener());

    }

        private class clickListener implements AdapterView.OnItemClickListener{
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //String atk = (String) adapterView.getItemAtPosition(position);
                int min = Integer.MAX_VALUE;
                for(int n=0;n<15;n=n+1){
                    if(atkArray[n]<min){
                        min = atkArray[n];
                    }else {

                    }
                }
                if( atkArray[position]==min ){
                    Toast.makeText(l11text.this,"right",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(l11text.this,"wrong",Toast.LENGTH_SHORT).show();
               }

          }
       }
}
