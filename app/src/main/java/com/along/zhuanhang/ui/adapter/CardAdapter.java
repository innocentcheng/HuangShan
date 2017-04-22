package com.along.zhuanhang.ui.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.along.zhuanhang.R;
import com.along.zhuanhang.bean.Attackable;
import com.along.zhuanhang.bean.CardL18;
import com.along.zhuanhang.bean.MinionCardL18;

import java.util.ArrayList;

public class CardAdapter extends BaseAdapter{
    private final Context mContext;
    private final ArrayList<CardL18> mdata;
    public CardAdapter(Context context, ArrayList<CardL18> CardArryList){
        mContext = context;
        mdata = CardArryList;
    }

    @Override
    public int getCount() {
        return mdata.size();
    }

    @Override
    public CardL18 getItem(int position) {
        return mdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        Holder holder;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.l20_adapter_card,parent,false);
            holder = new Holder();
            holder.mIcon = (ImageView) convertView.findViewById(R.id.l20_adapter_icon);
            holder.mTypeTag = (TextView) convertView.findViewById(R.id.l20_adapter_type);
            holder.mName = (TextView) convertView.findViewById(R.id.l20_adapter_name);
            holder.mCost = (TextView) convertView.findViewById(R.id.l20_adapter_cost);
            holder.mDamage = (TextView) convertView.findViewById(R.id.l20_adapter_damage);
            holder.mHp = (TextView) convertView.findViewById(R.id.l20_adapter_hp);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }

        CardL18 card = mdata.get(position);
        holder.mIcon.setImageResource(card.getImageView());
        holder.mName.setText(card.getName());
        holder.mCost.setText(""+card.getCost());
        holder.mTypeTag.setText(card.type());
        String cardType = card.type();
        String lastCardType;
        if(position==0){
            lastCardType = "";
        }else {
        lastCardType = mdata.get(position-1).type();
        }

        if(cardType.equals(lastCardType)){
            holder.mTypeTag.setVisibility(View.GONE);
        }else {
            holder.mTypeTag.setVisibility(View.VISIBLE);
        }

        if(card instanceof Attackable){
            Attackable attackableCard = (Attackable) card;
            holder.mDamage.setText(""+attackableCard.damage());
        }else if (card instanceof MinionCardL18){
            MinionCardL18 minion = (MinionCardL18) card;
            holder.mHp.setText(""+minion.getHp());
        }else {
            holder.mDamage.setText("");
            holder.mHp.setText("");
        }
        return convertView;
    }

    private class Holder{
        TextView mTypeTag;
        ImageView mIcon;
        TextView mName;
        TextView mCost;
        TextView mDamage;
        TextView mHp;
    }
}
