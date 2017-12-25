package com.specialty.administrator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.specialty.administrator.beans.Trace;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/12/25.
 */

public class TraceAdapter  extends BaseAdapter{
    private ArrayList<Trace> traceArrayList=null;
    private LayoutInflater inflater;
    private Context context;

    public TraceAdapter (ArrayList<Trace>traceArrayList, Context context){
        this.traceArrayList=traceArrayList;
        this.context=context;
        this.inflater= LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return  traceArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return traceArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Holder holder;
        if (view ==null){
            view = inflater.inflate(R.layout.logisticsitem,null);
            holder = new Holder();
            holder.v_top_line=view.findViewById(R.id.v_top_line);
            holder.iv_state=view.findViewById(R.id.iv_state);
            holder.tv_express_text=view.findViewById(R.id.tv_express_text);
            holder.tv_express_time=view.findViewById(R.id.tv_express_time);
            holder.v_down_line=view.findViewById(R.id.v_down_line);
            view.setTag(holder);
        }else {
            holder=(Holder)view.getTag();
        }
        if (traceArrayList.get(position).isHead()){
            holder.v_top_line.setVisibility(View.INVISIBLE);
            holder.iv_state.setImageResource(R.mipmap.circlered);
            holder.tv_express_text.setText(traceArrayList.get(position).getInfo());
            holder.tv_express_time.setText(traceArrayList.get(position).getTime());
            holder.v_down_line.setVisibility(View.VISIBLE);
        }else if (traceArrayList.size()==(position+1)){
            holder.v_top_line.setVisibility(View.VISIBLE);
            holder.tv_express_text.setText(traceArrayList.get(position).getInfo());
            holder.tv_express_time.setText(traceArrayList.get(position).getTime());
            holder.iv_state.setImageResource(R.mipmap.circlearraw);
            holder.v_down_line.setVisibility(View.INVISIBLE);
        }else{
            holder.tv_express_text.setText(traceArrayList.get(position).getInfo());
            holder.tv_express_time.setText(traceArrayList.get(position).getTime());
            holder.v_down_line.setVisibility(View.VISIBLE);
        }
        return view;
    }
   private class Holder{
        View v_top_line;
        ImageView iv_state;
        TextView tv_express_text;
        TextView tv_express_time;
        View v_down_line;
    }
}

