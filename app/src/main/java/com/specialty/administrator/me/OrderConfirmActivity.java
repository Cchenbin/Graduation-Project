package com.specialty.administrator.me;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.specialty.administrator.adapter.Order_confirm_Adapetr;
import com.specialty.administrator.beans.Order;
import com.specialty.administrator.specialty.R;
import com.specialty.administrator.view.MylistView;

import java.util.ArrayList;

public class OrderConfirmActivity extends Activity implements View.OnClickListener {
    private Context context;
    private ArrayList<Order> orders = new ArrayList<>();
    private Order_confirm_Adapetr confirmAdapetr;
    private MylistView listView;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.orcer_confirm);
        initView();
        confirmAdapetr = new Order_confirm_Adapetr(orders, context);
        listView.setAdapter(confirmAdapetr);
        initData();
    }

    private void initView() {
        listView = findViewById(R.id.order_colist);
        scrollView = findViewById(R.id.scro);
        TextView title = findViewById(R.id.top_all_textView1);
        title.setText("确认订单");
        TextView save = findViewById(R.id.top_all_textView2);
        save.setVisibility(View.INVISIBLE);
        ImageView arrow = findViewById(R.id.top_all_ImageView);
        arrow.setOnClickListener(this);
        ImageView confirm_larrow = findViewById(R.id.confirm_larrow);
        confirm_larrow.setOnClickListener(this);
    }

        /*订单测试数据*/
        private void initData() {
            orders.add(new Order(0, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 0, "14.5"));
            orders.add(new Order(1, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 0, "14.5"));
            orders.add(new Order(2, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 0, "14.5"));
        }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.top_all_ImageView:
                finish();
                break;
            case R.id.confirm_larrow:
                Intent change_address = new Intent(OrderConfirmActivity.this,AddressActivity.class);
                startActivity(change_address);
            default:
        }
    }
}

