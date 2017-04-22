package com.along.zhuanhang.bill;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.along.zhuanhang.R;

import java.util.ArrayList;
import java.util.List;

public class BillMainActivity extends AppCompatActivity {
    private TextView mTvRemain;
    private Button mBtnAdd;
    private ListView mLvInfo;
    private BillAdapter mAdapter;
    private LayoutInflater mInflater ;
    public List<Bill> mBills = new ArrayList<>();
    private int mRemain = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_main);
        initView();
    }

    private void initView() {
        mInflater = LayoutInflater.from(this);
        mTvRemain = (TextView) findViewById(R.id.bill_tv_remain);
        mBtnAdd = (Button) findViewById(R.id.bill_btn_add);
        mLvInfo = (ListView) findViewById(R.id.bill_lv);
        mAdapter = new BillAdapter(this,mBills);
        mLvInfo.setAdapter(mAdapter);
    }

    public void add(View view) {
        View contentview = mInflater.inflate(R.layout.bill_dialog_detail, new LinearLayout(this),false);
        final EditText editName = (EditText) contentview.findViewById(R.id.bill_et_name);
        final EditText editMoney = (EditText) contentview.findViewById(R.id.bill_et_money);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("添加一笔支出")
                .setView(contentview)
                .setCancelable(true)
                .setNegativeButton("取消",null)
                .setPositiveButton("确定",new DialogClickListener(editName,editMoney))
                .create();
        dialog.show();
    }

    private class DialogClickListener implements DialogInterface.OnClickListener {
        private final EditText etName;
        private final EditText etMoney;
        DialogClickListener(EditText etName,EditText etMoney){
            this.etName = etName;
            this.etMoney = etMoney;
        }
        @Override
        public void onClick(DialogInterface dialog, int which) {
            String name = etName.getText().toString();
            String moneyStr = etMoney.getText().toString();
            int iconId = R.mipmap.l20_hp;
            long time = System.currentTimeMillis();
            int money = Integer.parseInt(moneyStr);
            Bill bill = new Bill(iconId,name,time,money);
            mBills.add(bill);
            mAdapter.notifyDataSetChanged();
            mRemain = mRemain - money;
            mTvRemain.setText("￥"+mRemain);
        }
    }
}
