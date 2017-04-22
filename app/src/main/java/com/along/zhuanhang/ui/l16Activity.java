package com.along.zhuanhang.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.along.zhuanhang.R;

public class l16Activity extends AppCompatActivity {
    private Button mBtn;
    private TextView mTv;
    private EditText mEt;
    private int money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l16);
        //1.Button onClick
        //2.EditText listener
        //3.log
        initview();
    }

    private void initview() {
        mBtn = (Button) findViewById(R.id.l16_btn);
        mEt = (EditText) findViewById(R.id.l16_et);
        mTv = (TextView) findViewById(R.id.l16_tv);

        mBtn.setOnClickListener(new btnClickListener());
        mEt.addTextChangedListener(new EtWatchDog());

    }

    private class btnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(l16Activity.this,"投币续命无敌",Toast.LENGTH_SHORT).show();
        }
    }

    private class EtWatchDog implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Log.d("Debug","s:"+s+"start:"+start+"count:"+count+"after:"+after);
        }


        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Log.d("Debug","s:"+s+"start:"+start+"before:"+before+"count:"+count);
        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.d("Debug","s:"+s);

            showEtChang(s.toString());
        }
    }

    private void showEtChang(String content){
        if(content.length()==0){
            content="0";
            Toast.makeText(this,"删到头了",Toast.LENGTH_SHORT).show();
        }
        money = Integer.parseInt(content);
        if(money<200){
        mTv.setText("¥" +""+ money);
        }else{
            mTv.setText("¥" + 200);
            Toast.makeText(this,"最大不能超过200",Toast.LENGTH_SHORT).show();
        }
    }

}
