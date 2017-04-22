package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.along.zhuanhang.R;
import com.along.zhuanhang.bean.GuichushaCard;

public class l7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l7);
    }

    public void getCard(View view) {
        GuichushaCard card1 = new GuichushaCard();
        card1.setName("元首");
        String card1Name = card1.getName();
        card1.setDescription("搞比利（当比利海灵顿在场上时，获得冲锋。)");
        String card1Description = card1.getDescription();
        card1.setQulity("紫");
        card1.setType("明星卡");
        card1.setImageId(R.mipmap.l7image);
        Toast.makeText(this,"卡牌名："+card1Name+
                "\n描述："+card1Description
                +"\n品质:"+card1.getQulity()
                +"\n类型:"+card1.getType(),Toast.LENGTH_LONG).show();
        ImageView ivCard = (ImageView) findViewById(R.id.l7_iv);
        ivCard.setImageResource(card1.getImageId());
    }
}
