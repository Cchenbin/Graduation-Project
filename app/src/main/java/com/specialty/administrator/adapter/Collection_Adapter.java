package com.specialty.administrator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.specialty.administrator.beans.Collection;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;

/**
 * Created by 陈彬 on 2018/1/8.
 */

public class Collection_Adapter extends BaseAdapter {
    private ArrayList<Collection> collections = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;
    private View.OnClickListener delete;

    public Collection_Adapter(ArrayList<Collection> collections, Context context) {
        this.collections = collections;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return collections.size();
    }

    @Override
    public Object getItem(int position) {
        return collections.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.collection_list_item, null);
            holder = new Holder();
            holder.image = view.findViewById(R.id.collection_img);
            holder.name = view.findViewById(R.id.collection_name);
            holder.money = view.findViewById(R.id.collection_money);
            holder.delete = view.findViewById(R.id.collection_delete);
            holder.delete.setOnClickListener(delete);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        holder.image.setImageResource(collections.get(position).getImage());
        holder.name.setText(collections.get(position).getName());
        holder.money.setText(collections.get(position).getMoney());
        holder.delete.setTag(collections.get(position).getId());
        view.setTag(holder);
        return view;
    }

    public void setDelete(View.OnClickListener delete) {
        this.delete = delete;
    }

    public class Holder {
        ImageView image, delete;
        TextView name, money;
    }
}
