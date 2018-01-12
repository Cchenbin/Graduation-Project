package com.specialty.administrator.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.specialty.administrator.beans.Address;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;

/**
 * Created by 陈彬 on 2018/1/12.
 */

public class AddressAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Address> addresses = new ArrayList<>();
    private LayoutInflater inflater;
    private View.OnClickListener choose;
    private View.OnClickListener edit;
    private View.OnClickListener delete;


    public AddressAdapter(ArrayList<Address> addresses, Context context) {
        this.addresses = addresses;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return addresses.size();
    }

    @Override
    public Object getItem(int position) {
        return addresses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.address_list_item, null);
            holder = new Holder();
            holder.name = view.findViewById(R.id.address_name);
            holder.phone = view.findViewById(R.id.address_phone);
            holder.address = view.findViewById(R.id.address_detail);
            holder.chick = view.findViewById(R.id.select);
            holder.chick.setOnClickListener(choose);
            holder.address_edit = view.findViewById(R.id.address_edit);
            holder.address_edit.setOnClickListener(edit);
            holder.address_delete = view.findViewById(R.id.address_delete);
            holder.address_delete.setOnClickListener(delete);
            holder.address_view = view.findViewById(R.id.address_view);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        if (addresses != null) {
            holder.name.setText(addresses.get(position).getName());
            holder.phone.setText(addresses.get(position).getPhone());
            holder.address.setText(addresses.get(position).getAddress());
            if (addresses.get(position).getTag() == 0) {
                holder.chick.setBackground(context.getResources().getDrawable(R.drawable.checkboxun));
                holder.address_view.setBackgroundColor(Color.rgb(241, 241, 241));
            } else {
                holder.chick.setBackground(context.getResources().getDrawable(R.drawable.checkboxon));
                holder.address_view.setBackgroundResource(R.mipmap.addressview);
            }
            holder.chick.setTag(addresses.get(position).getId());
            holder.address_edit.setTag(addresses.get(position).getId());
            holder.address_delete.setTag(addresses.get(position).getId());
            view.setTag(holder);
        }
        return view;
    }

    public void setChoose(View.OnClickListener choose) {
        this.choose = choose;
    }

    public void setEdit(View.OnClickListener edit) {
        this.edit = edit;
    }

    public void setDelete(View.OnClickListener delete) {
        this.delete = delete;
    }

    public class Holder {
        TextView name, phone, address;
        ImageView chick;
        LinearLayout address_edit, address_delete;
        View address_view;
    }
}
