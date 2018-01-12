package com.specialty.administrator.me;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.specialty.administrator.adapter.AddressAdapter;
import com.specialty.administrator.beans.Address;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddressActivity extends Activity implements View.OnClickListener {
    private Button add_address;
    private ImageView arrow;
    private TextView save;
    private ListView listView;
    private AddressAdapter addressAdapter;
    private ArrayList<Address> addresses = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address);
        initView();
        Context context = this;
        addressAdapter = new AddressAdapter(addresses, context);
        addressAdapter.setChoose(this);
        addressAdapter.setEdit(this);
        addressAdapter.setDelete(this);
        listView.setAdapter(addressAdapter);
        initData();
    }

    private void initView() {
        add_address = findViewById(R.id.Add_address);
        add_address.setOnClickListener(this);
        arrow = findViewById(R.id.top_all_ImageView);
        arrow.setOnClickListener(this);
        save = findViewById(R.id.top_all_textView2);
        save.setVisibility(View.INVISIBLE);
        listView = findViewById(R.id.address_list);
    }

    private void initData() {
        addresses.add(new Address(0, 1, "陈彬", "15892057192", "111111111111111111111"));
        addresses.add(new Address(1, 0, "陈彬", "15892057192", "222222222222222222222"));
        addresses.add(new Address(2, 0, "陈彬", "15892057192", "333333333333333333333"));
        addresses.add(new Address(3, 0, "陈彬", "15892057192", "444444444444444444444"));
    }

    @Override
    public void onClick(View view) {
        Object tag = view.getTag();
        String position = String.valueOf(tag);
        switch (view.getId()) {
            case R.id.Add_address:
                Intent address = new Intent(AddressActivity.this, AddAddress.class);
                startActivity(address);
                finish();
                break;
            case R.id.top_all_ImageView:
                finish();
                break;
            case R.id.select:
                if (tag != null) {
                    for (int i = 0; i < addresses.size(); i++) {
                        addresses.get(i).setTag(0);
                        int type = addresses.get(i).getId();
                        if (position.equals(type + "")) {
                            addresses.get(i).setTag(1);
                        }
                    }
                    addressAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.address_edit:
                Intent editAddess = new Intent(AddressActivity.this,AddAddress.class);
                startActivity(editAddess);
                break;
            case R.id.address_delete:
                if (tag!=null){
                    for (int i = 0; i < this.addresses.size(); i++) {
                        Address address1 = this.addresses.get(i);
                        if (position.equals((address1.getId() + ""))) {
                            this.addresses.remove(i);
                        }
                    }
                    addressAdapter.notifyDataSetChanged();
                }
            default:
        }
    }
}
