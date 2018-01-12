package com.specialty.administrator.adapter;

import android.content.Context;
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

public class Order_confirm_Adapetr extends BaseAdapter {
    private Context context;
    private ArrayList<Order> orders = new ArrayList<>();
    private LayoutInflater inflater;

    public Order_confirm_Adapetr(ArrayList<Order> orders, Context context) {
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
        Holder holder =null;
        if (view ==null){
            view = inflater.inflate(R.layout.order_confirm_list_item,null);
            holder = new Holder();
            holder.image = view.findViewById(R.id.order_img);
            holder.order_name = view.findViewById(R.id.order_name);
            holder.order_money=view.findViewById(R.id.order_money);
            holder.order_num = view.findViewById(R.id.order_num);
            view.setTag(holder);
        }else{
            holder =(Holder)view.getTag();
        }
        if (orders !=null){
            holder.image.setImageResource(orders.get(position).getImages());
            holder.order_name.setText(orders.get(position).getName());
            holder.order_money.setText(orders.get(position).getMoney());
            holder.order_num.setText(orders.get(position).getNum());
        }
        return view;
    }

    public class Holder {
        ImageView image;
        TextView order_name,order_money,order_num;
    }
}
