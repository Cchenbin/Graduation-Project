package com.specialty.administrator.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.specialty.administrator.beans.Classify;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/2.
 */

public class ClassifyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Classify> classifyArrayList = null;
    private LayoutInflater inflater;

    public ClassifyAdapter(ArrayList<Classify> classifyArrayList, Context context) {
        this.classifyArrayList = classifyArrayList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return classifyArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return classifyArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.classify_list_item, null);
            holder = new Holder();
            holder.name = view.findViewById(R.id.list_classify_name);
            holder.line = view.findViewById(R.id.list_classify_line);
        } else {
            holder = (Holder) view.getTag();
        }
        if (classifyArrayList != null) {
            holder.name.setText(classifyArrayList.get(position).getClassify());
            if (Integer.valueOf(classifyArrayList.get(position).getIsSelected()) == 1) {
                holder.name.setTextColor(Color.rgb(255, 33, 80));
                holder.name.setBackgroundColor(Color.rgb(242, 242, 242));
                holder.line.setVisibility(View.INVISIBLE);
            } else {
                holder.name.setTextColor(Color.rgb(51, 51, 51));
                holder.name.setBackgroundColor(Color.rgb(255, 255, 255));
                holder.line.setVisibility(View.VISIBLE);
            }
            view.setTag(holder);
        }
        return view;
    }

    private class Holder {
        TextView name;
        View line;
    }
}
