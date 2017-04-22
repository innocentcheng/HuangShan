package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.along.zhuanhang.R;
import com.along.zhuanhang.bean.AttackSpellCardL18;
import com.along.zhuanhang.bean.Attackable;
import com.along.zhuanhang.bean.CardL18;
import com.along.zhuanhang.bean.EffectSpellCardL18;
import com.along.zhuanhang.bean.HealingSpellCardL18;
import com.along.zhuanhang.bean.ItemCardL18;
import com.along.zhuanhang.bean.MinionCardL18;

public class l18Activity extends AppCompatActivity {

    private TextView mtvEnemy;
    private TextView mtvOwnCard;
    private Button mbtn;
    private TextView mtvInfo;
    private MinionCardL18 card1;
    private ItemCardL18 card2;
    private AttackSpellCardL18 card3;
    private CardL18 card4;
    private CardL18 card5;
    private int enemyHealth;
    CardL18[] ownCards=new CardL18[5];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l18);

        initView();
        initData();


    }

    private void initData() {
        enemyHealth = 100;
        mtvEnemy.setText("敌方剩余血量："+enemyHealth);
        card1 = new MinionCardL18("火车王",6);
        card2 = new ItemCardL18("血吼",7);
        card3 = new AttackSpellCardL18("火球术",6);
        card4 = new HealingSpellCardL18("治疗波");
        card5 = new EffectSpellCardL18("妖术");

        String cardsNam="";
        ownCards[0] = card4;
        ownCards[1] = card1;
        ownCards[2] = card3;
        ownCards[3] = card5;
        ownCards[4] = card2;
        for(int i =0;i<ownCards.length;i++){
            cardsNam =cardsNam +"   "+ ownCards[i].getName();
        }
        mtvOwnCard.setText(cardsNam);

    }


    private void initView() {
        mtvEnemy = (TextView) findViewById(R.id.l18_tv_enemy);
        mtvOwnCard = (TextView) findViewById(R.id.l18_tv_ownCard);
        mbtn = (Button) findViewById(R.id.l18_btn_play);
        mtvInfo = (TextView) findViewById(R.id.l18_tv_info);
    }



    public void playCard(View view) {
        String str="\n";
        int deduction=0;
        for(int i = 0;i<ownCards.length;i++){
            CardL18 card = ownCards[i];
            if( card instanceof Attackable){
                str = str+"\n"+ownCards[i].play() +"\n"+ ((Attackable) card).handleDamage()+"\n";
                deduction = deduction + ((Attackable) card).damage();
            }else {
                str = str+"\n"+ownCards[i].play()+"\n";
            }
        }
        enemyHealth = enemyHealth -deduction;
        if(enemyHealth>0){
        mtvEnemy.setText("敌方剩余血量："+enemyHealth);
        }else {
            enemyHealth = 0;
            mtvEnemy.setText("敌方已阵亡");
        }
        mtvInfo.setText(str);
    }
}
