package com.ehighsun.popuwindowpractice;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnPop1;
    private PopupWindow popupWindow;
    private PopuAdapter adapter;
    private List<Species> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPop1 = (Button) findViewById(R.id.btn_popu1);
        btnPop1.setOnClickListener(this);
        initDatas();
    }

    private void initDatas() {
        mList = new ArrayList<>();
        Species s1 = new Species(BitmapFactory.decodeResource(getResources(),R.drawable.pic_contract),"电子合同");
        Species s2 = new Species(BitmapFactory.decodeResource(getResources(),R.drawable.pic_repay_plan),"还款计划");
        Species s3 = new Species(BitmapFactory.decodeResource(getResources(),R.drawable.pic_repay_note),"还款记录");
        mList.add(s1);
        mList.add(s2);
        mList.add(s3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_popu1:
                showPopuWindow();
                break;
        }

    }

    private void showPopuWindow() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.popumenu, null);
        popupWindow = new PopupWindow(this);
        ListView listView = contentView.findViewById(R.id.listview);
        adapter = new PopuAdapter(mList,this);
        listView.setAdapter(adapter);
        popupWindow.setContentView(contentView);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(btnPop1,dp2px(10),dp2px(10));
        backgroundAlpha(0.5f);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,mList.get(position).getName(),Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                Resources.getSystem().getDisplayMetrics());
    }

    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }
}
