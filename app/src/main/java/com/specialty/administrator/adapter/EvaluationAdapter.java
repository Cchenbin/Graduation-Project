package com.specialty.administrator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.specialty.administrator.beans.Evaluation;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;

/**
 * Created by 陈彬 on 2018/1/4.
 */

public class EvaluationAdapter extends BaseAdapter{
    private Context context;
    private LayoutInflater inflater ;
    private ArrayList<Evaluation>evaluationArrayList=new ArrayList<>();
    public  EvaluationAdapter(ArrayList<Evaluation>evaluationArrayList,Context context){
        this.evaluationArrayList = evaluationArrayList;
        this.context = context;
        this.inflater =LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return evaluationArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return evaluationArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder;
        if(view == null){
            view = inflater.inflate(R.layout.evaluation_item,null);
            holder = new Holder();
            holder.image=view.findViewById(R.id.imageView);
            holder.name=view.findViewById(R.id.evaluation_name);
            holder.content=view.findViewById(R.id.evaluation_content);
            holder.time=view.findViewById(R.id.evaluation_time);
        }else{
            holder = (Holder)view.getTag();
        }if (evaluationArrayList!=null){
            holder.image.setImageResource(evaluationArrayList.get(position).getImg());
            holder.name.setText(evaluationArrayList.get(position).getName());
            holder.content.setText(evaluationArrayList.get(position).getContent());
            holder.time.setText(evaluationArrayList.get(position).getTime());
            view.setTag(holder);
        }
        return view;
    }
    private  class Holder{
        ImageView image;
        TextView  name,content,time;
    }
}
