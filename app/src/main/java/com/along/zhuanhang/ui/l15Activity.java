package com.along.zhuanhang.ui;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.along.zhuanhang.R;

public class l15Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l15);
    }

    public void yOrN(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("你棒不棒？");
        builder.setMessage("诚实点好嘛~");
        builder.setPositiveButton("那必须",new yOrNListener());
        builder.setNegativeButton("低调",new yOrNListener());
        builder.create().show();


    }

    public class yOrNListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which==-1){
            Toast.makeText(l15Activity.this,"屌屌屌！",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(l15Activity.this,"奢华！",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void whoBest(View view) {
        String[] nameArray = new String[]{"路飞","鸣人","一护","银","阿龙"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(nameArray,new whoBestListener());
        builder.create().show();

    }

    public class whoBestListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which) {
             if (which==4){
                    Toast.makeText(l15Activity.this,"有见识！",Toast.LENGTH_SHORT).show();
            }else {
                 Toast.makeText(l15Activity.this,"胡鸡吧选！",Toast.LENGTH_SHORT).show();
             }
        }
    }
}
