package com.specialty.administrator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.specialty.administrator.beans.Product_detail;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/5.
 */

public class Classify_details_gtidview_Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<Product_detail> product_detailses = new ArrayList<>();
    private LayoutInflater inflater;

    public Classify_details_gtidview_Adapter(ArrayList<Product_detail> product_detailses, Context context) {
        this.context = context;
        this.product_detailses = product_detailses;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return product_detailses.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.classify_details_gridview_item, null);
            holder = new Holder();
            holder.images = view.findViewById(R.id.image);
            holder.name = view.findViewById(R.id.product_name);
            holder.money = view.findViewById(R.id.product_money);
            view.setTag(holder);
        } else {
            holder = (Holder)view.getTag();
        }
        holder.images.setImageResource(product_detailses.get(position).getImage());
        holder.name.setText(product_detailses.get(position).getName());
        holder.money.setText(product_detailses.get(position).getMoney());
        return view;
    }

    private class Holder {
        ImageView images;
        TextView name, money;
    }
}
