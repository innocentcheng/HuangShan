package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.along.zhuanhang.R;

import java.util.ArrayList;
import java.util.Random;

public class l19ArrayListActivity extends AppCompatActivity {
    private ListView mNamList;
    private ArrayList<String> mOldFriendsNam;
    private ArrayList<String> mNewFriendsNam;
    private ArrayAdapter<String> mAdapter;
    private boolean firstOnclick = true;
    private Random mRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l19_array_list);

        initview();
        initdata();
    }

    private void initdata() {
        mOldFriendsNam = new ArrayList<>();
        mOldFriendsNam.add("啊蛋");
        mOldFriendsNam.add("MC");
        mOldFriendsNam.add("阿迪王");
        mOldFriendsNam.add("偶尊");
        mOldFriendsNam.add("安兹");

        mAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mOldFriendsNam);
        mNamList.setAdapter(mAdapter);

        mNewFriendsNam = new ArrayList<>();
        mNewFriendsNam.add("兔兔");
        mNewFriendsNam.add("箱子");
        mNewFriendsNam.add("金哥");
        mNewFriendsNam.add("姜林");
        mNewFriendsNam.add("腿毛");

    }

    private void initview() {
        mNamList = (ListView) findViewById(R.id.l19_namList);
    }

    public void addFriend(View view) {
        if(firstOnclick){
            mOldFriendsNam.add(0,"穿越哥");
            mOldFriendsNam.add("神小虎");
            mOldFriendsNam.set(5,"安大兹");
            firstOnclick = false;
        }else if(!mNewFriendsNam.isEmpty()){
            int idex = mRandom.nextInt(mNewFriendsNam.size());
            String name = mNewFriendsNam.get(idex);
            mOldFriendsNam.add(0,name);
            mNewFriendsNam.remove(idex);
        }else {
            Toast.makeText(this,"没有备用联系人了",Toast.LENGTH_SHORT).show();
        }
        mAdapter.notifyDataSetChanged();
    }
}
