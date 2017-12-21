package com.specialty.administrator.cart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.specialty.administrator.adapter.cart_listadapter;
import com.specialty.administrator.data.Data;
import com.specialty.administrator.specialty.R;

import java.util.List;
import java.util.Map;


public class Cart_F extends Fragment {
    private cart_listadapter listadapter;
    private ListView listView;
    private List<Map<String, Object>> data;
    private boolean[] is_choice;

    public Cart_F() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        is_choice=new boolean[Data.arrayList_cart.size()];
        View rootView = inflater.inflate(R.layout.cart_f, container, false);
        listView = rootView.findViewById(R.id.cart_list);
        listadapter=new cart_listadapter(getActivity(),Data.arrayList_cart);
        listView.setAdapter(listadapter);
        return rootView;
    }


}
