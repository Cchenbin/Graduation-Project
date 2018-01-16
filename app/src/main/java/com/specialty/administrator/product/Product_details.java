package com.specialty.administrator.product;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.specialty.administrator.classify.ChooseTasteActivity;
import com.specialty.administrator.specialty.R;

public class Product_details extends FragmentActivity implements View.OnClickListener {
    /*界面中间分类栏*/
    private TextView[] tv_menu = new TextView[6];
    /*下划线*/
    private View[] tv_view = new View[3];
    /*分类栏ID*/
    private int[] tv_menu_id = {R.id.text_details, R.id.text_details_specification, R.id.text_evaluation, R.id.add_collection, R.id.add_cart, R.id.by_now};
    /*下划线ID*/
    private int[] tv_view_id = {R.id.view1, R.id.view2, R.id.view3};
    /* 详情界面*/
    private Details_F details_f;
    /* 参数界面*/
    private Parameter_F parameter_f;
    /* 评价界面*/
    private Evaluation_F evaluation_f;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        initView();
    }

    private void initView() {
        TextView tv1, tv2;
        for (int i = 0; i < tv_menu.length; i++) {
            tv_menu[i] = findViewById(tv_menu_id[i]);
            tv_menu[i].setOnClickListener(this);
        }
        for (int j = 0; j < tv_view.length; j++) {
            tv_view[j] = findViewById(tv_view_id[j]);
        }
        if (details_f == null) {
            details_f = new Details_F();
            addFragment(details_f);
            showFragment(details_f);
        } else {
            showFragment(details_f);
        }
        tv_menu[0].setTextColor(Color.rgb(255, 33, 80));
        tv_view[0].setBackgroundColor(Color.rgb(255, 33, 80));
        tv1 = findViewById(R.id.top_all_textView1);
        tv1.setText("商品详情");
        tv2 = findViewById(R.id.top_all_textView2);
        tv2.setVisibility(View.INVISIBLE);
        image = findViewById(R.id.top_all_ImageView);
        image.setOnClickListener(this);
        TextView specification = findViewById(R.id.specification);
        specification.setOnClickListener(this);
    }

    /*添加Fragment*/
    private void addFragment(Fragment fragment) {
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        ft.add(R.id.show_layout_product, fragment);
        ft.commit();
    }

    /*删除Fragment*/
    private void removeFragment(Fragment fragment) {
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }

    /*显示Fragment*/
    private void showFragment(Fragment fragment) {
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        if (details_f != null) {
            ft.hide(details_f);
        }
        if (parameter_f != null) {
            ft.hide(parameter_f);
        }
        if (evaluation_f != null) {
            ft.hide(evaluation_f);
        }
        ft.show(fragment);
        ft.commitAllowingStateLoss();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_details:
                if (details_f == null) {
                    details_f = new Details_F();
                    addFragment(details_f);
                    showFragment(details_f);
                } else if (details_f.isHidden()) {
                    showFragment(details_f);
                }
                break;
            case R.id.text_details_specification:
                if (parameter_f != null) {
                    removeFragment(parameter_f);
                    parameter_f = null;
                }
                parameter_f = new Parameter_F();
                addFragment(parameter_f);
                showFragment(parameter_f);
                break;
            case R.id.text_evaluation:
                if (evaluation_f != null) {
                    removeFragment(evaluation_f);
                    evaluation_f = null;
                }
                evaluation_f = new Evaluation_F();
                addFragment(evaluation_f);
                showFragment(evaluation_f);
                break;
            case R.id.top_all_ImageView:
                finish();
                break;
            case R.id.add_collection:
                Toast.makeText(this, "收藏成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_cart:
                Intent add_cart = new Intent(Product_details.this, ChooseTasteActivity.class);
                startActivity(add_cart);
                break;
            case R.id.by_now:
                Intent by = new Intent(Product_details.this, ChooseTasteActivity.class);
                startActivity(by);
                break;
            case R.id.specification:
                Intent specification = new Intent(Product_details.this, ChooseTasteActivity.class);
                startActivity(specification);
            default:
                break;
        }
        for (int i = 0; i < 3; i++) {
            tv_menu[i].setTextColor(Color.rgb(117, 117, 117));
            tv_view[i].setBackgroundColor(Color.rgb(117, 117, 117));
            if (view.getId() == tv_menu_id[i]) {
                tv_menu[i].setTextColor(Color.rgb(255, 33, 80));
                tv_view[i].setBackgroundColor(Color.rgb(255, 33, 80));
            }
        }
    }

}
