package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.along.zhuanhang.R;

public class l11ListViewActivity extends AppCompatActivity {

    //ListView
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l11_list_view);
        //1.从布局中加载 LV
        mListView = (ListView)findViewById(R.id.l11_lv);
        //2.准备需要展示的数据
        String[] lessionArray = new String[16];
        for (int i=0;i<16;i=i+1){
            lessionArray[i] = "第"+ (i + 1) +"节课";
        }
        //3.将数据指定到Adapter上
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, lessionArray);
        //4.为LV设置Adapter
        mListView.setAdapter(arrayAdapter);
        //5.为LV添加点击事件
        mListView.setOnItemClickListener(new onItemClickListener());
    }
        //创建点击事件
        private class onItemClickListener implements AdapterView.OnItemClickListener{
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String lession = (String) adapterView.getItemAtPosition(position);
                String content = lession + "-" + position;
                Toast.makeText(l11ListViewActivity.this,content,Toast.LENGTH_SHORT).show();
            }
        }
}
