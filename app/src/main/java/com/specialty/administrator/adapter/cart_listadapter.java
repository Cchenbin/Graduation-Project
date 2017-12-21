package com.specialty.administrator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.specialty.administrator.specialty.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/12/20.
 */

public class cart_listadapter  extends BaseAdapter{
    private Context context;
    private ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
    private onCheckedChanged listener;


    public cart_listadapter(Context context, ArrayList<HashMap<String, Object>> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }
        public cart_listadapter(Context context) {
        this.context = context;

    }
    @Override
    public int getCount() {
     return (arrayList != null && arrayList.size() == 0) ? 0: arrayList.size();
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        HolderView holderView=null;
        if (convertView == null) {
            holderView = new  HolderView();
            convertView = LayoutInflater.from(context).inflate(R.layout.list,null);
            holderView.cart_name=convertView.findViewById(R.id.cart_name);
            holderView.cart_Taste=convertView.findViewById(R.id.cart_Taste);
            holderView.cart_money=convertView.findViewById(R.id.cart_money);
            holderView.cart_num=convertView.findViewById(R.id.cart_num);
            holderView.cart_choose=convertView.findViewById(R.id.cart_choose);
            convertView.setTag(holderView);
        }else{
            holderView=(HolderView)convertView.getTag();
        }if(arrayList.size()!=0){
            holderView.cart_name.setText(arrayList.get(position).get("num")+"");
            holderView.cart_Taste.setText("蓝莓"+arrayList.get(position).get("tatste"));
            holderView.cart_money.setText("100"+arrayList.get(position).get("money"));
            holderView.cart_num.setText("100"+arrayList.get(position).get("num"));
            holderView.cart_choose.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean choice) {
                    listener.getChoiceData(position, choice);
                }
            });
        }

        return convertView;
    }


    public class HolderView {
        private TextView cart_name,cart_Taste,cart_money;
        private EditText cart_num;
        private CheckBox cart_choose;

    }

    public interface onCheckedChanged{

        public void getChoiceData(int position,boolean isChoice);
    }
    public void setOnCheckedChanged(onCheckedChanged listener){
        this.listener=listener;
    }
}
