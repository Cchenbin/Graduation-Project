package com.specialty.administrator.specialty;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.specialty.administrator.cart.Cart_F;
import com.specialty.administrator.classify.Classify_F;
import com.specialty.administrator.home.Home_F;
import com.specialty.administrator.me.Me_F;

import static com.specialty.administrator.specialty.R.layout.main;


public class Main extends FragmentActivity implements View.OnClickListener{
    /*界面底部菜单按钮*/
    private TextView [] tv_menu=new TextView[4];
    /*界面底部菜单区域*/
    private LinearLayout [] ll_menu= new LinearLayout[4];
    /*底部菜单栏按钮ID*/
    private int[] ll_menu_id={R.id.ll_menu_0,R.id.ll_menu_1,R.id.ll_menu_2,R.id.ll_menu_3};
    private int[] tv_menu_id={R.id.tv_menu_0,R.id.tv_menu_1,R.id.tv_menu_2,R.id.tv_menu_3};
    /*底部选中的按钮资源*/
    private  int[] select_on={R.mipmap.home_on,R.mipmap.all_on,R.mipmap.cart_on,R.mipmap.me_on};
    /*底部未选中的按钮资源*/
    private  int[] select_un={R.mipmap.home_un,R.mipmap.all_un,R.mipmap.cart_un,R.mipmap.me_un};
     /*主界面*/
    private Home_F home_f;
    /*分类界面*/
    private Classify_F classify_f;
    /*购物车界面*/
    private Cart_F cart_f;
    /*用户界面*/
    private Me_F me_f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(main);
        initView();
    }
    private void initView(){
        /*找到按钮并添加监听事件*/
        for(int i=0; i<tv_menu.length;i++){
            tv_menu[i]=findViewById(tv_menu_id[i]);
            ll_menu[i]=findViewById(ll_menu_id[i]);
            ll_menu[i].setOnClickListener(this);
        }
        /*初始化默认界面*/
        if(home_f==null){
            home_f=new Home_F();
            addFragment(home_f);
            showFragment(home_f);
        }else{
            showFragment(home_f);
        }
        /*设置默认首页按钮为点击时的图片*/
        tv_menu[0].setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,select_on[0]),null,null);
        tv_menu[0].setTextColor(ContextCompat.getColor(this, R.color.colorChecked));
    }
    /*添加Fragment*/
    public void addFragment(Fragment fragment) {
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        ft.add(R.id.show_layout, fragment);
        ft.commit();
    }
    /*删除Fragment*/
    public void removeFragment(Fragment fragment) {
        FragmentTransaction ft=this.getSupportFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }
    /*显示Fragment*/
    public void showFragment(Fragment fragment) {
        FragmentTransaction ft=this.getSupportFragmentManager().beginTransaction();
        /*判断当前页面是否创建，如果创建就隐藏掉*/
        if(home_f != null){
            ft.hide(home_f);
        } if (classify_f !=null){
            ft.hide(classify_f);
        } if (cart_f !=null){
            ft.hide(cart_f);
        } if (me_f != null){
            ft.hide(me_f);
        }
        ft.show(fragment);
        ft.commitAllowingStateLoss();
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.ll_menu_0:
                /*主界面*/
                if (home_f == null) {
                    home_f = new Home_F();
                    /*判断当前界面是否隐藏，如果隐藏就进行添加显示，false表示显示，true表示当前界面隐藏*/
                    addFragment(home_f);
                    showFragment(home_f);
                } else {
                    if (home_f.isHidden()) {
                        showFragment(home_f);
                    }
                }
                break;
            case R.id.ll_menu_1:
                /*分类界面*/
                if (classify_f == null) {
                    classify_f = new Classify_F();
                    addFragment(classify_f);
                    showFragment(classify_f);
                } else {
                    if (classify_f.isHidden()) {
                        showFragment(classify_f);
                    }
                }
                break;
            case R.id.ll_menu_2:
                /*购物车界面*/
                if (cart_f != null) {
                    removeFragment(cart_f);
                    cart_f = null;
                }
                cart_f = new Cart_F();
                addFragment(cart_f);
                showFragment(cart_f);
                break;
            case R.id.ll_menu_3:
                /*我的界面*/
                if (me_f != null) {
                    removeFragment(me_f);
                    me_f = null;
                }
                me_f = new Me_F();
                addFragment(me_f);
                showFragment(me_f);
                 default:
                break;
            }
                /*设置按钮的未选中状态资源*/
                for (int i = 0;i<tv_menu.length;i++){
                    tv_menu[i].setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,select_un[i]),null,null);
                    tv_menu[i].setTextColor(ContextCompat.getColor(this,R.color.colorUnchecked));
                    if(v.getId() == ll_menu_id[i]){
                        tv_menu[i].setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,select_on[i]),null,null);
                        tv_menu[i].setTextColor(ContextCompat.getColor(this,R.color.colorChecked));
                    }
                }
        }
    }

