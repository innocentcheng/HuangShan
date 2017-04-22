package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.along.zhuanhang.R;
import com.along.zhuanhang.bean.AttackSpellCardL18;
import com.along.zhuanhang.bean.CardL18;
import com.along.zhuanhang.bean.MinionCardL18;
import com.along.zhuanhang.utils.Tools;

import org.json.JSONArray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class L25JsonActivity extends AppCompatActivity {
    TextView mInfo;
    MinionCardL18 adan;
    MinionCardL18 mc;
    AttackSpellCardL18 cangying;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l25_jason);

        initView();
        initData();
    }

    private void initData() {
        adan = new MinionCardL18("啊淡",5,6,7);
        mc = new MinionCardL18("MC",7,8,9);
        cangying = new AttackSpellCardL18("苍蝇",10,10);
    }

    private void initView() {
        mInfo = (TextView)findViewById(R.id.l25_info_tv);
    }

    public void toString(View view) {
        mInfo.setText(adan.toString()+"\n"+cangying.toString());
    }

    public void map(View view) {
        HashMap<String,String> cardMap = new HashMap<>();
        cardMap.put("name",adan.getName());
        cardMap.put("cost","5");
        cardMap.put("hp","6");
        cardMap.put("damage","7");
        String caraName = cardMap.get("name");
        Set<String> ketSet = cardMap.keySet();
        Iterator<String> iterator = ketSet.iterator();
        String content="\n";
        while (iterator.hasNext()){
            String key = iterator.next();
            content = content + "key: "+key+" value: "+cardMap.get(key)+"\n";
        }
        mInfo.setText("\nsize:"+cardMap.size()+"\nname:"+cardMap.get("name")+"\ntoString:"+cardMap.toString()+"\ncontent: "+content);
    }

    public void buildJson(View view) {
        jsonArray = new JSONArray();
        jsonArray.put(adan.toJson());
        jsonArray.put(mc.toJson());
        mInfo.setText(jsonArray.toString());
    }

    public void parseJson(View view) {
        String jsonString = jsonArray.toString();
        List<MinionCardL18> list = MinionCardL18.parseList(jsonString);
        mInfo.setText(Arrays.toString(list.toArray()));
    }
}
