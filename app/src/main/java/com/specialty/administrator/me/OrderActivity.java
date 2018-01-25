package com.specialty.administrator.me;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.specialty.administrator.adapter.Order_list_Adapter;
import com.specialty.administrator.beans.Order;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;

public class OrderActivity extends Activity implements View.OnClickListener {
    private String Order1;
    private TextView tv1;
    private ListView order_list;
    int orderss;
    private Order_list_Adapter order_list_adapter;
    private ArrayList<Order> orders = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = this;
        setContentView(R.layout.order);
        Intent intent = getIntent();
        Order1 = intent.getStringExtra("order");
        orderss = Integer.valueOf(Order1);
        initView();
        order_list_adapter = new Order_list_Adapter(orders, context);
        order_list.setAdapter(order_list_adapter);
        order_list_adapter.setTv1(this);
        order_list_adapter.setTv2(this);
    }

    private void initView() {
        ImageView arrow = findViewById(R.id.top_all_ImageView);
        arrow.setOnClickListener(this);
        tv1 = findViewById(R.id.top_all_textView1);
        TextView tv2 = findViewById(R.id.top_all_textView2);
        initOrder();
        order_list = findViewById(R.id.order_list);
        order_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String status = tv1.getText().toString();
                Intent details = new Intent(OrderActivity.this, OrderDetail.class);
                details.putExtra("status",status);
                startActivity(details);
            }
        });
        tv2.setVisibility(View.INVISIBLE);
    }
    private void initOrder() {
        switch (orderss) {
            case 0:
                tv1.setText("待付款订单");
                initData0();
                break;
            case 1:
                tv1.setText("待发货订单");
                initData1();
                break;
            case 2:
                tv1.setText("待收货订单");
                initData2();
                break;
            case 3:
                tv1.setText("待评价订单");
                initData3();
            default:
        }
    }

    /*订单测试数据*/
    private void initData() {
        orders.add(new Order(0, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 0, "14.5"));
        orders.add(new Order(1, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 1, "14.5"));
        orders.add(new Order(2, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 2, "14.5"));
        orders.add(new Order(3, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 3, "14.5"));
    }

    private void initData0() {
        orders.add(new Order(0, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 0, "14.5"));
        orders.add(new Order(1, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 0, "14.5"));
        orders.add(new Order(2, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 0, "14.5"));
        orders.add(new Order(3, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 0, "14.5"));
    }

    private void initData1() {
        orders.add(new Order(0, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 1, "14.5"));
        orders.add(new Order(1, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 1, "14.5"));
        orders.add(new Order(2, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 1, "14.5"));
        orders.add(new Order(3, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 1, "14.5"));
    }

    private void initData2() {
        orders.add(new Order(0, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 2, "14.5"));
        orders.add(new Order(1, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 2, "14.5"));
        orders.add(new Order(2, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 2, "14.5"));
        orders.add(new Order(3, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 2, "14.5"));
    }

    private void initData3() {
        orders.add(new Order(0, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 3, "14.5"));
        orders.add(new Order(1, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 3, "14.5"));
        orders.add(new Order(2, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 3, "14.5"));
        orders.add(new Order(3, R.mipmap.peanut, "新疆库尔勒香梨梨子香妃梨新疆库尔勒香梨梨子香妃梨", "14.5", "X1", 3, "14.5"));
    }

    @Override
    public void onClick(View view) {
            Object tag = view.getTag();
            String position = String.valueOf(tag);
        switch (view.getId()) {
            case R.id.top_all_ImageView:
                finish();
                break;
            case R.id.order_tv1:
                if (tag != null) {
                    if (orderss == 0) {
                        for (int i = 0; i < this.orders.size(); i++) {
                            Order order = this.orders.get(i);
                            if (position.equals((order.getId() + ""))) {
                                this.orders.remove(i);
                            }
                        }
                    } else if (orderss == 2) {
                        for (int i = 0; i < this.orders.size(); i++) {
                            Order order = this.orders.get(i);
                            if (position.equals((order.getId() + ""))) {
                                Intent logistics = new Intent(OrderActivity.this, Logistics.class);
                                startActivity(logistics);
                            }
                        }
                    } else {
                        for (int i = 0;i<this.orders.size();i++){
                            Order order = this.orders.get(i);
                            if(position.equals((order.getId()+""))){
                                Intent evaluation = new Intent(OrderActivity.this, evaluationeadit.class);
                                startActivity(evaluation);

                            }
                        }
                    }
                }
                order_list_adapter.notifyDataSetChanged();
                break;
            case R.id.order_tv2:
                if (tag != null) {
                    if (orderss == 0) {
                        Intent cart_order = new Intent(OrderActivity.this, OrderConfirmActivity.class);
                        startActivity(cart_order);
                    } else if (orderss == 1) {
                        Toast.makeText(this, "正在发货", Toast.LENGTH_SHORT).show();
                    } else if (orderss == 2) {
                        Toast.makeText(this, "确认收货", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent cart_order = new Intent(OrderActivity.this, OrderConfirmActivity.class);
                        startActivity(cart_order);
                    }
                }
                order_list_adapter.notifyDataSetChanged();
                break;
            default:
        }
    }
}
