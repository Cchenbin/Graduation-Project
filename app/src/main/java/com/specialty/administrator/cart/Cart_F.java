package com.specialty.administrator.cart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.specialty.administrator.adapter.CartAdapter;
import com.specialty.administrator.beans.Cart;
import com.specialty.administrator.me.OrderConfirmActivity;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;


public class Cart_F extends Fragment implements View.OnClickListener {
    private ListView cart_list;
    private TextView cart_all, tv_cart_buy_or_del;
    private ArrayList<Cart> cartArrayList = new ArrayList<>();
    //private List list = new ArrayList();
    private CartAdapter ca;
    private Context context;
    private CheckBox check, allcheck;
    private View rootView;
    private boolean isChecked = false;


    public Cart_F() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = this.getActivity();
        rootView = inflater.inflate(R.layout.cart_f, container, false);
        initView();
        ca = new CartAdapter(cartArrayList, context);
        cart_list.setAdapter(ca);
        ca.setOnSubNum(this);
        ca.setOnAddNum(this);
        ca.setChoise(this);
        ca.setOnDlete(this);
        initData();
        return rootView;

    }

    private void initView() {
        check = rootView.findViewById(R.id.cart_choose);
        cart_all = rootView.findViewById(R.id.cart_all);
        tv_cart_buy_or_del = rootView.findViewById(R.id.tv_cart_buy_or_del);
        tv_cart_buy_or_del.setOnClickListener(this);
        allcheck = rootView.findViewById(R.id.cart_all_choice);
        allcheck.setOnClickListener(this);
        cart_list = rootView.findViewById(R.id.cart_list);
    }

    private void initData() {
        cartArrayList.add(new Cart("1", R.mipmap.peanut, "22222222222", "3333", 1, 1, 0));
        cartArrayList.add(new Cart("2", R.mipmap.potatoes, "222222222222222222222", "3333", 1, 2, 0));
        cartArrayList.add(new Cart("3", R.mipmap.tofu, "22222222222", "3333", 1, 3, 0));
        cartArrayList.add(new Cart("4", R.mipmap.shoots, "222222222222222222222", "3333", 1, 4, 0));
        cartArrayList.add(new Cart("5", R.mipmap.meat, "222222222222222222222", "3333", 1, 4, 0));
    }

    @Override
    public void onClick(View view) {
        Object tag = view.getTag();
        switch (view.getId()) {
            case R.id.cart_add:
                if (tag != null) {
                    String position = String.valueOf(tag);
                    if (cartArrayList == null || cartArrayList.size() <= 0)
                        return;
                    for (int i = 0; i < cartArrayList.size(); i++) {
                        if ((cartArrayList.get(i).getId()).equals(position)) {
                            int num = cartArrayList.get(i).getNum();
                            num++;
                            cartArrayList.get(i).setNum(num);
                        }
                    }
                    ca.notifyDataSetChanged();
                    getTotalMoney();
                }
                break;
            case R.id.cart_sub:
                if (tag != null) {
                    String position = String.valueOf(tag);
                    if (cartArrayList == null || cartArrayList.size() <= 0)
                        return;
                    for (int i = 0; i < cartArrayList.size(); i++) {
                        if ((cartArrayList.get(i).getId()).equals(position)) {
                            int num = cartArrayList.get(i).getNum();
                            if (num > 0) {
                                num--;
                                cartArrayList.get(i).setNum(num);
                            }
                        }
                    }
                    ca.notifyDataSetChanged();
                    getTotalMoney();
                }
                break;
            case R.id.cart_choose:
                String position = String.valueOf(tag);
                boolean selectedAll = true;
                for (int i = 0; i < this.cartArrayList.size(); i++) {
                    Cart cart = cartArrayList.get(i);
                    if (position.equals(cart.getId())) {
                        int isSelected = cart.getIsSelected() == 0 ? 1 : 0;
                        cartArrayList.get(i).setIsSelected(isSelected);
                    }
                    if (cart.getIsSelected() == 0) {
                        selectedAll = false;
                    }
                }
                getTotalMoney();
                ca.notifyDataSetChanged();
                if (cartArrayList == null || cartArrayList.size() <= 0)
                    selectedAll = false;
                if (selectedAll) {
                    allcheck.setBackground(getResources().getDrawable(R.drawable.checkboxon));
                    isChecked = true;
                } else {
                    allcheck.setBackground(getResources().getDrawable(R.drawable.checkboxun));
                    isChecked = false;
                }
                break;
            case R.id.cart_all_choice:
                if (!isChecked) {
                    allcheck.setBackground(getResources().getDrawable(R.drawable.checkboxon));
                    for (int i = 0; i < this.cartArrayList.size(); i++) {
                        cartArrayList.get(i).setIsSelected(1);
                    }
                    isChecked = true;
                } else {
                    allcheck.setBackground(getResources().getDrawable(R.drawable.checkboxun));
                    for (int i = 0; i < this.cartArrayList.size(); i++) {
                        cartArrayList.get(i).setIsSelected(0);
                    }
                    isChecked = false;
                }
                getTotalMoney();
                ca.notifyDataSetChanged();
                break;
            case R.id.cart_delete:
                String po = String.valueOf(tag);
                for (int i = 0; i < this.cartArrayList.size(); i++) {
                    Cart cart = this.cartArrayList.get(i);
                    if (po.equals(cart.getId())) {
                        this.cartArrayList.remove(i);
                    }
                }
                for (int j = 0; j < this.cartArrayList.size(); j++) {
                    Cart cart = cartArrayList.get(j);
                    if (cart.getIsSelected() == 0) {
                        allcheck.setBackground(getResources().getDrawable(R.drawable.checkboxun));
                    } else {
                        allcheck.setBackground(getResources().getDrawable(R.drawable.checkboxon));
                        isChecked = true;
                    }
                }
                getTotalMoney();
                ca.notifyDataSetChanged();
                break;
            case R.id.tv_cart_buy_or_del:
                String Settlement = tv_cart_buy_or_del.getText().toString();
                if (Settlement.equals("结算(" + 0 + ")")) {
                    Toast.makeText(Cart_F.this.getActivity(), "亲，还未选定商品哦", Toast.LENGTH_SHORT).show();
                }else{
                    Intent cart_order = new Intent(Cart_F.this.getActivity(), OrderConfirmActivity.class);
                    startActivity(cart_order);
                }
                break;
            default:
        }
    }

    //计算数量和总价
    private void getTotalMoney() {
        double total = 0.0;
        int num = 0;
        for (int i = 0; i < this.cartArrayList.size(); i++) {
            Cart cart = this.cartArrayList.get(i);
            if (cart.getIsSelected() == 1) {
                total += cart.getMoney() * cart.getNum();
                num += cart.getNum();
            }
        }
        cart_all.setText("合计 ：¥" + total+"");
        tv_cart_buy_or_del.setText("结算(" + num + ")");
    }
}

