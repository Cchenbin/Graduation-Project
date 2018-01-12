package com.specialty.administrator.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.specialty.administrator.beans.Order;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;

/**
 * Created by 陈彬 on 2018/1/11.
 */

public class Order_list_Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<Order> orders = new ArrayList<>();
    private LayoutInflater inflater;
    private View.OnClickListener tv1;
    private View.OnClickListener tv2;


    public Order_list_Adapter(ArrayList<Order> orders, Context context) {
        this.context = context;
        this.orders = orders;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int position) {
        return orders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder = null;
        if (view == null) {
            holder = new Holder();
            view = inflater.inflate(R.layout.order_list_item, null);
            holder.status = view.findViewById(R.id.order_status);
            holder.image = view.findViewById(R.id.order_image);
            holder.order_name = view.findViewById(R.id.order_name);
            holder.order_unit_price = view.findViewById(R.id.order_unit_price);
            holder.order_num = view.findViewById(R.id.order_num);
            holder.order_total = view.findViewById(R.id.order_total);
            holder.tv1 = view.findViewById(R.id.order_tv1);
            holder.tv1.setOnClickListener(tv1);
            holder.tv2 = view.findViewById(R.id.order_tv2);
            holder.tv2.setOnClickListener(tv2);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        if (orders != null) {
            if (orders.get(position).getStatus() == 0) {
                holder.status.setText("等待买家付款");
                holder.tv1.setText("取消订单");
                holder.tv1.setBackgroundResource(R.drawable.order_shape);
                holder.tv2.setText("去付款");
                holder.tv2.setBackgroundResource(R.drawable.order_shape_pay);
                holder.tv2.setTextColor(Color.rgb(255, 0, 0));
            } else if (orders.get(position).getStatus() == 1) {
                holder.status.setText("待发货");
                holder.tv2.setText("等待发货");
                holder.tv2.setBackgroundResource(R.drawable.order_shape);
            } else if (orders.get(position).getStatus() == 2) {
                holder.status.setText("待收货");
                holder.tv1.setText("查看物流");
                holder.tv1.setBackgroundResource(R.drawable.order_shape);
                holder.tv2.setText("确认收货");
                holder.tv2.setBackgroundResource(R.drawable.order_shape);
            } else {
                holder.status.setText("交易完成");
                holder.tv1.setText("去评价");
                holder.tv1.setBackgroundResource(R.drawable.order_shape);
                holder.tv2.setText("再次购买");
                holder.tv2.setBackgroundResource(R.drawable.order_shape);
            }
            holder.image.setImageResource(orders.get(position).getImages());
            holder.order_name.setText(orders.get(position).getName());
            holder.order_unit_price.setText(orders.get(position).getMoney());
            holder.order_num.setText(orders.get(position).getNum());
            holder.order_total.setText(orders.get(position).getTotal());
            holder.tv1.setTag(orders.get(position).getId());
            holder.tv2.setTag(orders.get(position).getId());
            view.setTag(holder);
        }
        return view;
    }

    public void setTv1(View.OnClickListener tv1) {
        this.tv1 = tv1;
    }

    public void setTv2(View.OnClickListener tv2) {
        this.tv2 = tv2;
    }

    public class Holder {
        TextView status, order_name, order_unit_price, order_num, order_total, tv1, tv2;
        ImageView image;
    }
}
