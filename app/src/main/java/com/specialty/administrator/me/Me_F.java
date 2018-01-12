package com.specialty.administrator.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.specialty.administrator.adapter.Me_GridView_Adapter;
import com.specialty.administrator.specialty.R;
import com.specialty.administrator.view.MyGridView;


public class Me_F extends Fragment implements View.OnClickListener {
    private LinearLayout[] ll_menu = new LinearLayout[5];
    private int[] ll_menu_id = {R.id.ll_menu1, R.id.ll_menu2, R.id.ll_menu3, R.id.ll_menu4, R.id.my_set};
    private View rootView;
    private MyGridView gridView;
    private TextView user_name;
    private String titles[] = {"待付款", "待发货", "待收货", "待评价", "我的收藏", "收货地址", "问题反馈", "关于"};
    private Integer images[] = {R.mipmap.user_3, R.mipmap.user_4, R.mipmap.user_5, R.mipmap.user_6, R.mipmap.like, R.mipmap.address, R.mipmap.porblem, R.mipmap.about};

    public Me_F() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Context context = this.getActivity();
        rootView = inflater.inflate(R.layout.me_f, container, false);
        initView();
        Me_GridView_Adapter meGridViewAdapter = new Me_GridView_Adapter(titles, images, context);
        gridView.setAdapter(meGridViewAdapter);
        return rootView;
    }

    private void initView() {
        for (int j = 0; j < ll_menu.length; j++) {
            ll_menu[j] = rootView.findViewById(ll_menu_id[j]);
            ll_menu[j].setOnClickListener(this);
        }
        ImageView edit_name = rootView.findViewById(R.id.user_edit);
        edit_name.setOnClickListener(this);
        user_name = rootView.findViewById(R.id.user_name);
        gridView = rootView.findViewById(R.id.me_gridView);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                GrindViewOnclick(position);
            }
        });

    }

    private void GrindViewOnclick(int position) {
        if (position == 0) {
            Intent payment = new Intent(Me_F.this.getActivity(), OrderActivity.class);
            payment.putExtra("order", "0");
            startActivity(payment);
        } else if (position == 1) {
            Intent ship = new Intent(Me_F.this.getActivity(), OrderActivity.class);
            ship.putExtra("order", "1");
            startActivity(ship);
        } else if (position == 2) {
            Intent Receiving = new Intent(Me_F.this.getActivity(), OrderActivity.class);
            Receiving.putExtra("order", "2");
            startActivity(Receiving);
        } else if (position == 3) {
            Intent evaluation = new Intent(Me_F.this.getActivity(), OrderActivity.class);
            evaluation.putExtra("order", "3");
            startActivity(evaluation);
        } else if (position == 4) {
            Intent Collection = new Intent(Me_F.this.getActivity(), CollectionActivity.class);
            startActivity(Collection);
        } else if (position == 5) {
            Intent address = new Intent(Me_F.this.getActivity(), AddressActivity.class);
            startActivity(address);
        } else if (position == 6) {
            Intent back = new Intent(Me_F.this.getActivity(), FeedbackActivity.class);
            startActivity(back);
        } else if (position == 7) {
            Intent about = new Intent(Me_F.this.getActivity(), AboutActivity.class);
            startActivity(about);
        }
    }
    @Override
    public   void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (2 == requestCode && data!=null) {
            String name = data.getStringExtra("name");
            user_name.setText(name);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_menu2:
                Intent help = new Intent(Me_F.this.getActivity(), WebViewActivity.class);
                help.putExtra("sever", "3");
                startActivity(help);
                break;
            case R.id.my_set:
                Intent set = new Intent(Me_F.this.getActivity(), PersonalCenter.class);
                startActivity(set);
                break;
            case R.id.user_edit:
                Intent edit = new Intent(Me_F.this.getActivity(),EditNameActivity.class);
                startActivityForResult(edit,2);
                break;
            default:
        }
    }
}
