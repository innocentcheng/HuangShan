package com.along.zhuanhang.bill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.along.zhuanhang.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by aloong on 2017/4/22.
 */

public class BillAdapter extends BaseAdapter{
    private final Context mContext;
    private List<Bill> mData;
    private LayoutInflater mInflater;
    SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 E HH:mm:ss", Locale.getDefault());
    BillAdapter(Context context,List<Bill> data){
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Bill getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.bill_adapter_item,parent,false);
            holder.mImageView = (ImageView) convertView.findViewById(R.id.bill_iv_icon);
            holder.mTextName = (TextView) convertView.findViewById(R.id.bill_tv_name);
            holder.mTextTime= (TextView) convertView.findViewById(R.id.bill_tv_time);
            holder.mTextMoney = (TextView) convertView.findViewById(R.id.bill_tv_remain);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Bill bill = mData.get(position);
        holder.mImageView.setImageResource(bill.getmIconId());
        holder.mTextName.setText(bill.getmName());
        holder.mTextMoney.setText("￥"+bill.getmMoney());
        holder.mTextTime.setText(mSimpleDateFormat.format(new Date(bill.getmTimestamp())));
        return convertView;
    }
    private class ViewHolder {
        ImageView mImageView;
        TextView mTextName;
        TextView mTextTime;
        TextView mTextMoney;
    }
}
