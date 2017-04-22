package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.along.zhuanhang.R;
import com.along.zhuanhang.bean.Ninja;

public class l8text extends AppCompatActivity {

    private TextView mInfo;
    public TextView mBtn1;
    public TextView mBtn2;
    private Ninja ninja1;
    private Ninja ninja2;
    private int chooseNinja = 0;
    private String log = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l8text);

        ninja1 = new Ninja();
        ninja1.setNinjaName("忍者土土");
        ninja1.setAttack(2);
        ninja1.setHp(10);
        ninja2 = new Ninja();
        ninja2.setNinjaName("忍者啊淡");
        ninja2.setAttack(3);
        ninja2.setHp(30);

        initView();
        initData();
        mInfo.setText("战斗日志：\n");
    }

    private void initView() {
        mInfo = (TextView) findViewById(R.id.l8text_tv_info);
        mBtn1 = (TextView) findViewById(R.id.l8text_btn_ninja1);
        mBtn2 = (TextView) findViewById(R.id.l8text_btn_ninja2);
    }

    private void initData() {
        mBtn1.setText(ninja1.getNinjaName() + " (" + ninja1.getAttack() + " / " + ninja1.getHp() + ") ");
        mBtn2.setText(ninja2.getNinjaName() + " (" + ninja2.getAttack() + " / " + ninja2.getHp() + ") ");
    }


    public void onClick1(View view) {
        switch (chooseNinja) {
            case (0):
                if(ninja1.getHp()>0){
                Toast.makeText(this, "不能控制敌方", Toast.LENGTH_SHORT).show();
                }
                else {
                Toast.makeText(this, "不能控制尸体", Toast.LENGTH_SHORT).show();
                }
                break;
            case (1):
                if(ninja2.getAttack() <= ninja1.getHp()){
                    ninja1.setHp(ninja1.getHp() - ninja2.getAttack());
                    ninja2.setHp(ninja2.getHp() - ninja1.getAttack());
                    initData();
                    log = log+"\n- " + ninja2.getNinjaName() + "对" + ninja1.getNinjaName() + "造成了" + ninja2.getAttack() + "点伤害 （" + ninja1.getAttack() + "点反伤）";
                    mInfo.setText("战斗日志：" + log);
                    chooseNinja = 0;
                }
                else {
                    if(ninja1.getHp() > 0){
                        ninja1.setHp(0);
                        ninja2.setHp(ninja2.getHp() - ninja1.getAttack());
                        mBtn1.setText("忍者土土已阵亡");
                        mBtn2.setText(ninja2.getNinjaName() + " (" + ninja2.getAttack() + " / " + ninja2.getHp() + ") ");
                        log = log+"\n- " + ninja1.getNinjaName() + "已阵亡。" + ninja2.getNinjaName() + "获得了胜利" ;
                        mInfo.setText("战斗日志：" + log);
                        chooseNinja = 0;
                    }
                    else {
                        Toast.makeText(this, "不能攻击尸体", Toast.LENGTH_SHORT).show();
                        chooseNinja = 0;
                    }
                }

        }
    }

    public void onClick2(View view) {


        switch (chooseNinja) {
            case (1):
                Toast.makeText(this, "不能攻击自己", Toast.LENGTH_SHORT).show();
                break;
            case (0):
                chooseNinja = 1;
        }
    }
}

