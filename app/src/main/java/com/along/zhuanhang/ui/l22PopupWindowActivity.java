package com.along.zhuanhang.ui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.along.zhuanhang.R;

import java.util.Random;

public class l22PopupWindowActivity extends AppCompatActivity {

    private int[] imageIds ={R.mipmap.imageshengjian, R.mipmap.imagetiaodao,R.mipmap.l7image,};
    private String[] nameIds={"圣剑","跳刀","元首"};
    private String[] explain="最贵既最强 神行百变，进退自如 我到河北省来！".split(" ");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l22_popup_window);

    }



    public void popup(View view) {
        LayoutInflater inflater = LayoutInflater.from(this);
        LinearLayout root = new LinearLayout(this);
        View popupWindowView = inflater.inflate(R.layout.l22_popupwindow,root);
        TextView tvName = (TextView) popupWindowView.findViewById(R.id.l22_popWindow_tv);
        ImageView iv = (ImageView) popupWindowView.findViewById(R.id.l22_popWindow_iv);
        final int randomId = new Random().nextInt(nameIds.length);
        tvName.setText(nameIds[randomId]);
        iv.setImageResource(imageIds[randomId]);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(l22PopupWindowActivity.this,nameIds[randomId],Toast.LENGTH_SHORT).show();
            }
        });
        iv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(l22PopupWindowActivity.this,explain[randomId],Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        int warp = LinearLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow = new PopupWindow(popupWindowView,warp,warp);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#993333")));
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
    }
}
