package com.specialty.administrator.me;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.specialty.administrator.adapter.Order_confirm_Adapetr;
import com.specialty.administrator.beans.Order;
import com.specialty.administrator.specialty.R;
import com.specialty.administrator.view.MylistView;

import java.util.ArrayList;

public class OrderDetail extends Activity implements View.OnClickListener {
    private MylistView mylistView;
    private ArrayList<Order> orders = new ArrayList<>();
    private String status;
    private Order_confirm_Adapetr confirm_adapetr;
    private TextView[] tv_text =new  TextView[16];
    private int[] tv_text_id = {R.id.top_all_textView1,R.id.top_all_textView2,R.id.detail_Receiver,R.id.detail_phone,R.id.detail_address,R.id.detail_discount,R.id.detail_deliverys,R.id.detail_actually,R.id.detail_status,
            R.id.detail_numbering, R.id.detail_transaction,R.id.detail_create,R.id.detail_payment_time,R.id.detail_carry,R.id.detail_tv1,R.id.detail_tv2};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail);
        Intent intent = getIntent();
        status = intent.getStringExtra("status");
        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
        initView();
        Context context = this;
        confirm_adapetr = new Order_confirm_Adapetr(orders, context);
        mylistView.setAdapter(confirm_adapetr);
        initData();
    }

    private void initView() {
        mylistView = findViewById(R.id.order_colist);
        for (int i = 0;i<tv_text.length;i++){
            tv_text[i] = findViewById(tv_text_id[i]);
        }
        tv_text[14].setOnClickListener(this);
        tv_text[15].setOnClickListener(this);
        tv_text[0].setText("订单详情");
        tv_text[1].setVisibility(View.INVISIBLE);
        ImageView arrowL = findViewById(R.id.top_all_ImageView);
        arrowL.setOnClickListener(this);
        ImageView arrowR = findViewById(R.id.confirm_larrow);
        arrowR.setOnClickListener(this);
        initSet();
    }

    /*订单测试数据*/
    private void initData() {
        orders.add(new Order(0, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 0, "14.5"));
        orders.add(new Order(1, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 0, "14.5"));
        orders.add(new Order(2, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 0, "14.5"));
    }
    private void initSet(){
        if (status.equals("待付款订单")){
            tv_text[8].setText("未付款");
            tv_text[14].setText("取消订单");
            tv_text[14].setBackgroundResource(R.drawable.order_shape);
            tv_text[15].setText("去付款");
            tv_text[15].setTextColor(Color.rgb(255,0,0));
            tv_text[15].setBackgroundResource(R.drawable.order_shape_pay);
        }else if(status.equals("待发货订单")){
            tv_text[8].setText("待发货");
            tv_text[15].setText("取消订单");
            tv_text[15].setBackgroundResource(R.drawable.order_shape);
        }else if(status.equals("待收货订单")){
            tv_text[8].setText("待收货");
            tv_text[14].setText("查看物流");
            tv_text[14].setBackgroundResource(R.drawable.order_shape);
            tv_text[15].setText("确定收货");
            tv_text[15].setBackgroundResource(R.drawable.order_shape);
        }else{
            tv_text[8].setText("交易完成");
            tv_text[8].setTextColor(Color.rgb(0,255,0));
            tv_text[14].setText("评价");
            tv_text[14].setBackgroundResource(R.drawable.order_shape);
            tv_text[15].setText("再次购买");
            tv_text[15].setBackgroundResource(R.drawable.order_shape);
        }
    }

    @Override
    public void onClick(View view) {
        Object tag = view.getTag();
        String position = String.valueOf(tag);
        switch (view.getId()){
            case R.id.top_all_ImageView:
                finish();
                break;
            case R.id.confirm_larrow:
                Intent address = new Intent(OrderDetail.this,AddressActivity.class);
                startActivity(address);
                break;
            case R.id.order_tv1:
                if (tag != null) {
                    if (status.equals("待付款订单")){
                        for (int i = 0; i < this.orders.size(); i++) {
                            Order order = this.orders.get(i);
                            if (position.equals((order.getId() + ""))) {
                                this.orders.remove(i);
                            }
                        }
                    } else if (status.equals("待收货订单")) {
                        for (int i = 0; i < this.orders.size(); i++) {
                            Order order = this.orders.get(i);
                            if (position.equals((order.getId() + ""))) {
                                Intent logistics = new Intent(OrderDetail.this, Logistics.class);
                                startActivity(logistics);
                            }
                        }
                    } else {
                        Toast.makeText(this, "去评价", Toast.LENGTH_SHORT).show();
                    }
                }
                confirm_adapetr.notifyDataSetChanged();
                break;
            case R.id.order_tv2:
                if (tag != null) {
                    if (status.equals("待付款订单")){
                        Intent cart_order = new Intent(OrderDetail.this, OrderConfirmActivity.class);
                        startActivity(cart_order);
                    } else if (status.equals("待发货订单")) {
                        Toast.makeText(this, "正在发货", Toast.LENGTH_SHORT).show();
                    } else if (status.equals("待收货订单")){
                        Toast.makeText(this, "确认收货", Toast.LENGTH_SHORT).show();
                    }else {
                        Intent cart_order = new Intent(OrderDetail.this, OrderConfirmActivity.class);
                        startActivity(cart_order);
                    }
                }
                confirm_adapetr.notifyDataSetChanged();
                break;
            default:
        }
    }

}
