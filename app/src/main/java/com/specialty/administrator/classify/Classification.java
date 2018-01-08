package com.specialty.administrator.classify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.specialty.administrator.adapter.Classify_details_gtidview_Adapter;
import com.specialty.administrator.beans.Product_detail;
import com.specialty.administrator.product.Product_details;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;

public class Classification extends Activity implements View.OnClickListener{
    private Context context;
    private ArrayList<Product_detail>product_detailses = new ArrayList<>();
    private Classify_details_gtidview_Adapter cd ;
    private GridView gridView;
    private TextView[] tv_menu = new TextView[4];
    private int[] tv_menu_id = {R.id.tv_meun, R.id.tv_meun1, R.id.tv_meun2,R.id.tv_meun3};
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classification);
        context =this;
        initView();
        cd= new Classify_details_gtidview_Adapter(product_detailses,context);
        gridView.setAdapter(cd);
        initData();
    }
    private void initView(){
        for (int i = 0;i<tv_menu.length;i++){
            tv_menu[i]= findViewById(tv_menu_id[i]);
            tv_menu[i].setOnClickListener(this);
        }
        gridView=findViewById(R.id.classify_gridView);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Classification.this, Product_details.class);
                startActivity(intent);
            }
        });
        back = findViewById(R.id.larrow_back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);
    }
    private void initData(){
        product_detailses.add(new Product_detail(0,R.drawable.fruit,"新疆库尔勒香梨梨子香妃梨","¥"+19.5) );
        product_detailses.add(new Product_detail(0,R.drawable.fruit,"新疆库尔勒香梨梨子香妃梨","¥"+19.5) );
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.tv_meun:

                 break;
            case R.id.tv_meun1:

                break;
            case R.id.tv_meun2:

                break;
            case R.id.tv_meun3:

                break;
            case R.id.larrow_back:
                finish();
                break;
            default:

                break;
        }
       for (int i=0;i<tv_menu.length;i++){
           tv_menu[i].setBackgroundColor(Color.rgb(255, 33, 80));
            tv_menu[i].setTextColor(Color.rgb(255,255,255));
            if (view.getId() == tv_menu_id[i]){
                tv_menu[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.text_shape_checked));
                tv_menu[i].setTextColor(Color.rgb(255, 33, 80));
            }
       }
    }
}
