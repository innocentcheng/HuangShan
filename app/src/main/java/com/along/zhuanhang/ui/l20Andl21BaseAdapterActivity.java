package com.along.zhuanhang.ui;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.along.zhuanhang.R;
import com.along.zhuanhang.bean.AttackSpellCardL18;
import com.along.zhuanhang.bean.CardL18;
import com.along.zhuanhang.bean.EffectSpellCardL18;
import com.along.zhuanhang.bean.HealingSpellCardL18;
import com.along.zhuanhang.bean.ItemCardL18;
import com.along.zhuanhang.bean.MinionCardL18;
import com.along.zhuanhang.ui.adapter.CardAdapter;

import java.util.ArrayList;
import java.util.Iterator;

public class l20Andl21BaseAdapterActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {
    private ListView mListView;
    private EditText mEt;
    private CardL18 mCard;
    private ImageView mIvSearch;
    private CardAdapter mCardAdapter;
    private ArrayList<CardL18> mCardArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l20_base_adapter);

        initView();
        initData();
    }

    private void initData() {
        MinionCardL18 siwangzhiyi = new MinionCardL18("死亡之翼", 12);
        siwangzhiyi.setHp(12);
        siwangzhiyi.setCost(10);
        siwangzhiyi.setImageView(R.mipmap.l20_deathwings);
        MinionCardL18 fuding = new MinionCardL18("提里奥·弗丁", 6);
        fuding.setHp(6);
        fuding.setCost(8);
        fuding.setImageView(R.mipmap.l20_foding);
        MinionCardL18 zhaomocunmin = new MinionCardL18("着魔村民", 1);
        zhaomocunmin.setHp(1);
        zhaomocunmin.setCost(1);
        zhaomocunmin.setImageView(R.mipmap.l20_zhaomocunmin);
        AttackSpellCardL18 shandianjian = new AttackSpellCardL18("闪电箭", 3);
        shandianjian.setCost(1);
        shandianjian.setImageView(R.mipmap.l20_shandianjian);
        ItemCardL18 xuehou = new ItemCardL18("血吼", 7);
        xuehou.setCost(7);
        xuehou.setImageView(R.mipmap.l20_xuehou);
        HealingSpellCardL18 kuaisuzhiliao = new HealingSpellCardL18("快速治疗");
        kuaisuzhiliao.setCost(1);
        kuaisuzhiliao.setImageView(R.mipmap.l20_kuaisuzhiliao);
        EffectSpellCardL18 liliangdedaijia = new EffectSpellCardL18("力量的代价");
        liliangdedaijia.setCost(1);
        liliangdedaijia.setImageView(R.mipmap.l20_liliangdedaijia);

        mCardArrayList = new ArrayList<>();
        mCardArrayList.add(siwangzhiyi);
        mCardArrayList.add(shandianjian);
        mCardArrayList.add(xuehou);
        mCardArrayList.add(liliangdedaijia);
        mCardArrayList.add(kuaisuzhiliao);
        mCardArrayList.add(fuding);
        mCardArrayList.add(zhaomocunmin);
        sort();

        mCardAdapter = new CardAdapter(this, mCardArrayList);
        mListView.setAdapter(mCardAdapter);
        mListView.setOnItemClickListener(this);
        mListView.setOnItemLongClickListener(this);
    }

    private void sort() {
        ArrayList<CardL18> cards = new ArrayList<>();
        Class[] calsses = new Class[5];
        calsses[0] = MinionCardL18.class;
        calsses[1] = ItemCardL18.class;
        calsses[2] = AttackSpellCardL18.class;
        calsses[3] = HealingSpellCardL18.class;
        calsses[4] = EffectSpellCardL18.class;
        for (int i = 0; i < calsses.length; i++) {
            Iterator<CardL18> iterator = mCardArrayList.iterator();
            while (iterator.hasNext()) {
                CardL18 card = iterator.next();
                if (calsses[i] == MinionCardL18.class && card instanceof MinionCardL18) {
                    cards.add(card);
                    iterator.remove();
                }
                if (calsses[i] == ItemCardL18.class && card instanceof ItemCardL18) {
                    cards.add(card);
                    iterator.remove();
                }
                if (calsses[i] == AttackSpellCardL18.class && card instanceof AttackSpellCardL18) {
                    cards.add(card);
                    iterator.remove();
                }
                if (calsses[i] == HealingSpellCardL18.class && card instanceof HealingSpellCardL18) {
                    cards.add(card);
                    iterator.remove();
                }
                if (calsses[i] == EffectSpellCardL18.class && card instanceof EffectSpellCardL18) {
                    cards.add(card);
                    iterator.remove();
                }
            }
        }
        mCardArrayList = cards;
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.l20_lv_hearthstone);
        mEt = (EditText) findViewById(R.id.l20_et_search);
        mIvSearch = (ImageView) findViewById(R.id.l20_iv_search);
    }

    public void search(View view) {
        Editable searchCard = mEt.getText();
        String searchName = searchCard.toString();
        if (searchName.equals("")) {
            mCardAdapter = new CardAdapter(this, mCardArrayList);
            mListView.setAdapter(mCardAdapter);
            return;
        }

        ArrayList<CardL18> searchArrayList = new ArrayList<>();
        for (int i = 0; i < mCardArrayList.size(); i++) {
            mCard = mCardArrayList.get(i);
            if (searchName.equals(mCard.getName())) {
                searchArrayList.add(mCard);
                CardAdapter searchAdapter = new CardAdapter(this, searchArrayList);
                mListView.setAdapter(searchAdapter);
            }
        }
    }

    @Override
    public boolean onItemLongClick(final AdapterView<?> adapterView, View view, final int position, long id) {
        CardL18 card = (CardL18) adapterView.getItemAtPosition(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(card.getName());
        String[] items = "添加到收藏 删除卡牌".split(" ");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Toast.makeText(l20Andl21BaseAdapterActivity.this, "已添加入收藏", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        mCardArrayList.remove(position);
                        mCardAdapter.notifyDataSetChanged();
                        break;
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        CardL18 clickCard = (CardL18) adapterView.getItemAtPosition(position);
        //Toast.makeText(this,clickCard.getName(),Toast.LENGTH_SHORT).show();
        LayoutInflater inflater = LayoutInflater.from(this);
        LinearLayout root = new LinearLayout(this);
        root.setClickable(true);
        final View popupWd = inflater.inflate(R.layout.l20_22_popupwindow,root);
        ImageView iv = (ImageView) popupWd.findViewById(R.id.l20_22_popupWindow_iv);
        iv.setImageResource(clickCard.getImageView());
        int match = LinearLayout.LayoutParams.MATCH_PARENT;
        final PopupWindow popupWindow = new PopupWindow(popupWd,match,match);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        int wrap = LinearLayout.LayoutParams.WRAP_CONTENT;
        popupWindow.setOutsideTouchable(false);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
    }
}
