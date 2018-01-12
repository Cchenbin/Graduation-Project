package com.specialty.administrator.me;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.specialty.administrator.adapter.TraceAdapter;
import com.specialty.administrator.beans.Trace;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;

public class Logistics extends Activity implements View.OnClickListener{
    private ListView lv_trace;
    private ArrayList<Trace> tradeLists = new ArrayList<Trace>();
    private TraceAdapter ta;
    private Context context;
    private ImageView arrow_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = Logistics.this;
        setContentView(R.layout.logistics);
        initView();
        ta = new TraceAdapter(tradeLists, context);
        lv_trace.setAdapter(ta);
        initData();

    }
    private void initView(){
        lv_trace = findViewById(R.id.lv_trace);
        arrow_image = findViewById(R.id.arrow_image);
        arrow_image.setOnClickListener(this);
    }

    private void initData() {
        tradeLists.add(new Trace(true, "货物正在配送", "", "03-19 18:30"));
        tradeLists.add(new Trace(false, "货物已到达天津转运中心", "", "03-18 13:30"));
        tradeLists.add(new Trace(false, "货品已到济南货运站", "", "03-17 13:30"));
        tradeLists.add(new Trace(false, "货物已送达济南高新区站点", "", "03-16 13:30"));
        tradeLists.add(new Trace(false, "货物已送达济南高新区站点", "", "03-16 13:30"));
        tradeLists.add(new Trace(false, "货物已送达济南高新区", "", "03-15 13:30"));
        tradeLists.add(new Trace(false, "商家已发货","", "03-14 13:30"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.arrow_image:
                finish();
                break;
            default:
        }
    }
}
