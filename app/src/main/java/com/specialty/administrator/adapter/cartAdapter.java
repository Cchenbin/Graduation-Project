package com.specialty.administrator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.specialty.administrator.beans.Cart;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/20.
 */

public class cartAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Cart> cartArrayList = null;
    private LayoutInflater inflater ;
    private View.OnClickListener choise;
    private View.OnClickListener onAddNum;
    private View.OnClickListener onSubNum;
    private View.OnClickListener onDlete;



    public void setOnAddNum(View.OnClickListener onAddNum ){
        this.onAddNum=onAddNum;
    }
    public void setOnSubNum(View.OnClickListener onSubNum){
        this.onSubNum = onSubNum;
    }
    public void  setChoise(View.OnClickListener choise){
        this.choise=choise;
    }
    public void setOnDlete(View.OnClickListener onDlete) {
        this.onDlete = onDlete;
    }

    public cartAdapter(ArrayList<Cart>cartArrayList,Context context){
        this.cartArrayList=cartArrayList;
        this.context=context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return cartArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return cartArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view==null){
            view = inflater.inflate(R.layout.list,null);
            holder=new Holder();
            holder.img=view.findViewById(R.id.cart_img);
            holder.name=view.findViewById(R.id.cart_name);
            holder.num=view.findViewById(R.id.cart_num);
            holder.taste=view.findViewById(R.id.cart_Taste);
            holder.money= view.findViewById(R.id.cart_money);
            holder.choose=view.findViewById(R.id.cart_choose);
            holder.choose.setOnClickListener(choise);
            holder.sub=view.findViewById(R.id.cart_sub);
            holder.sub.setOnClickListener(onAddNum);
            holder.add=view.findViewById(R.id.cart_add);
            holder.add.setOnClickListener(onSubNum);
            holder.delete=view.findViewById(R.id.cart_delete);
            holder.delete.setOnClickListener(onDlete);
            view.setTag(holder);
        }else{
        holder=(Holder)view.getTag();
        }
        if (cartArrayList !=null){
            holder.name.setText(cartArrayList.get(position).getName());
            holder.num.setText(String.valueOf(cartArrayList.get(position).getNum()));
            holder.taste.setText(cartArrayList.get(position).getTaste());
            holder.money.setText(String.valueOf(cartArrayList.get(position).getMoney()));
            holder.sub.setTag(cartArrayList.get(position).getId());
            holder.add.setTag(cartArrayList.get(position).getId());
            holder.choose.setTag(cartArrayList.get(position).getId());
            if(Integer.valueOf(cartArrayList.get(position).getIsSelected())==1){
                holder.choose.setBackground(context.getResources().getDrawable(R.drawable.checkboxon));
            }else{
                holder.choose.setBackground(context.getResources().getDrawable(R.drawable.checkboxun));
            }
            holder.delete.setTag(cartArrayList.get(position).getId());
            view.setTag(holder);
        }

        return view;
    }


    private class Holder{
        TextView name,taste,money;
        EditText num;
        ImageView img,delete;
        CheckBox choose;
        Button add,sub;

    }
}
