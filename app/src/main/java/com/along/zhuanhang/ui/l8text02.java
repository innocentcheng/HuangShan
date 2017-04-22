package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.along.zhuanhang.R;
import com.along.zhuanhang.bean.Ninja;

public class l8text02 extends AppCompatActivity {

    private TextView mInfo;
    private String mBattlelog;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Ninja ninja1;
    private Ninja ninja2;
    private Ninja ninja3;
    private int mSelectedId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l8text02);

        initView();
        initData();
    }

    private void initView() {
        mInfo = (TextView) findViewById(R.id.l8text02_tv_info);
        mBtn1 = (Button) findViewById(R.id.l8text02_btn_ninja1);
        mBtn2 = (Button) findViewById(R.id.l8text02_btn_ninja2);
        mBtn3 = (Button) findViewById(R.id.l8text02_btn_ninja3);

    }

    private void initData() {
        mBattlelog = "战斗日志：\n";
        mInfo.setText(mBattlelog);

        ninja1 = new Ninja();
        ninja1.setNinjaName("吕布");
        ninja1.setHp(200);
        ninja1.setAttack(20);
        ninja1.setId(1);

        ninja2 = new Ninja();
        ninja2.setNinjaName("关羽");
        ninja2.setHp(50);
        ninja2.setAttack(70);
        ninja2.setId(2);

        ninja3 = new Ninja();
        ninja3.setNinjaName("张飞");
        ninja3.setHp(50);
        ninja3.setAttack(60);
        ninja3.setId(3);

        mBtn1.setText(ninjaInfo(ninja1));
        mBtn2.setText(ninjaInfo(ninja2));
        mBtn3.setText(ninjaInfo(ninja3));

    }

    private String ninjaInfo(Ninja ninja) {
        if (ninja.getHp() <= 0) {
            return ninja.getNinjaName() + "（已阵亡）";
        } else {
            return ninja.getNinjaName() + " ( " + ninja.getAttack() + " / " + ninja.getHp() + " )";
        }
    }

    public void onClick1(View view) {
        if (ninja1.getHp() > 0) {
            if (mSelectedId == 0) {
                mSelectedId = ninja1.getId();
                Toast.makeText(this, "攻击", Toast.LENGTH_SHORT).show();
            } else if (mSelectedId == 1) {
                Toast.makeText(this, "不能攻击自己", Toast.LENGTH_SHORT).show();
            } else {
                //未知情况
            }
        }else {
            Toast.makeText(this, ninja1.getNinjaName()+"已阵亡无法继续战斗", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClick2(View view) {
        if (mSelectedId == 0) {
            Toast.makeText(this, "不能控制敌人", Toast.LENGTH_SHORT).show();
        } else if (mSelectedId == 1) {
            //战斗
            attack(ninja1,ninja2,mBtn1,mBtn2);
            mSelectedId = 0;
        } else {
            //其他情况
        }
    }

    public void onClick3(View view) {
        if (mSelectedId == 0) {
            Toast.makeText(this, "不能控制敌人", Toast.LENGTH_SHORT).show();
        } else if (mSelectedId == 1) {
            attack(ninja1,ninja3,mBtn1,mBtn3);
            mSelectedId = 0;
        } else {
            //其他情况
        }
    }

    private void attack(Ninja attacker, Ninja attackee, Button atkerBtn, Button atkeeBtn) {
        if (attacker.getHp() <= 0) {
            Toast.makeText(this, attacker.getNinjaName() + "已阵亡", Toast.LENGTH_SHORT).show();
        } else if (attackee.getHp() <= 0) {
            Toast.makeText(this, attackee.getNinjaName() + "已阵亡,不能鞭尸", Toast.LENGTH_SHORT).show();
        } else {
            attackee.setHp(attackee.getHp() - attacker.getAttack());
            atkeeBtn.setText(ninjaInfo(attackee));
            attacker.setHp(attacker.getHp() - attackee.getAttack());
            atkerBtn.setText(ninjaInfo(attacker));
        }
        mBattlelog = mBattlelog + newInfo(attacker, attackee);
        mInfo.setText(mBattlelog);
    }

    private String newInfo(Ninja attacker, Ninja attackee) {
        if (attacker.getHp() > 0 && attackee.getHp() > 0)
            return "\n- " + attacker.getNinjaName() + " 对 " + attackee.getNinjaName()
                    + " 造成了 " + attacker.getAttack() + " 点伤害（反伤 "
                    + attackee.getAttack() + ")";
        if (attacker.getHp()<=0 && attackee.getHp()<=0)
            return "\n- " + attacker.getNinjaName()+"已阵亡，游戏结束";
        if (attackee.getHp()>0 && attacker.getHp()<=0)
            return "\n- " + attacker.getNinjaName()+"已阵亡，游戏结束";
        if (attacker.getHp()>0 &&attackee.getHp()<=0)
            return "\n- " + attackee.getNinjaName()+"已阵亡";
        return "";
    }
}

