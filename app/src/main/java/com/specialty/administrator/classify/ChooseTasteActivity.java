package com.specialty.administrator.classify;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.specialty.administrator.specialty.R;

public class ChooseTasteActivity extends Activity implements View.OnClickListener {
    private TextView[] tv_menu = new TextView[14];
    private int[] tv_menu_id = {R.id.money, R.id.inventory, R.id.weight_menu, R.id.weight_menu1, R.id.weight_menu2, R.id.weight_menu3, R.id.weight_menu4,
            R.id.taste_menu, R.id.taste_menu1, R.id.taste_menu2, R.id.taste_menu3, R.id.taste_menu4};
    private TextView number;
    private int num, inventory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_taste);
        Window window = getWindow();
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        wl.y = getWindowManager().getDefaultDisplay().getHeight();
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        initView();
    }

    private void initView() {
        for (int i = 0; i < tv_menu_id.length; i++) {
            tv_menu[i] = findViewById(tv_menu_id[i]);
            tv_menu[i].setOnClickListener(this);
        }
        Button btnless = findViewById(R.id.num_less);
        btnless.setOnClickListener(this);
        Button btnadd = findViewById(R.id.num_plus);
        btnadd.setOnClickListener(this);
        Button btndetermine = findViewById(R.id.determine);
        btndetermine.setOnClickListener(this);
        ImageView exit = findViewById(R.id.exit);
        exit.setOnClickListener(this);
        ImageView productimage = findViewById(R.id.product_image);
        number = findViewById(R.id.num);
        num = Integer.valueOf(number.getText().toString());
        inventory = Integer.valueOf(tv_menu[1].getText().toString());

    }

    /*设置重量种类未未选中状态*/
    private void Unselected() {
        for (int i = 2; i < 7; i++) {
            tv_menu[i].setBackground(getResources().getDrawable(R.drawable.weight_toast));
            tv_menu[i].setTextColor(Color.rgb(51, 51, 51));
        }
    }

    /*设置口味选项为未选中状态*/
    private void tasteunselected() {
        for (int i = 7; i < 12; i++) {
            tv_menu[i].setBackground(getResources().getDrawable(R.drawable.weight_toast));
            tv_menu[i].setTextColor(Color.rgb(51, 51, 51));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.weight_menu:
                Unselected();
                tv_menu[2].setBackground(getResources().getDrawable(R.drawable.weight_text));
                tv_menu[2].setTextColor(Color.rgb(255, 255, 255));
                break;
            case R.id.weight_menu1:
                Unselected();
                tv_menu[3].setBackground(getResources().getDrawable(R.drawable.weight_text));
                tv_menu[3].setTextColor(Color.rgb(255, 255, 255));
                break;
            case R.id.weight_menu2:
                Unselected();
                tv_menu[4].setBackground(getResources().getDrawable(R.drawable.weight_text));
                tv_menu[4].setTextColor(Color.rgb(255, 255, 255));
                break;
            case R.id.weight_menu3:
                Unselected();
                tv_menu[5].setBackground(getResources().getDrawable(R.drawable.weight_text));
                tv_menu[5].setTextColor(Color.rgb(255, 255, 255));
                break;
            case R.id.weight_menu4:
                Unselected();
                tv_menu[6].setBackground(getResources().getDrawable(R.drawable.weight_text));
                tv_menu[6].setTextColor(Color.rgb(255, 255, 255));
                break;
            case R.id.taste_menu:
                tasteunselected();
                tv_menu[7].setBackground(getResources().getDrawable(R.drawable.weight_text));
                tv_menu[7].setTextColor(Color.rgb(255, 255, 255));
                break;
            case R.id.taste_menu1:
                tasteunselected();
                tv_menu[8].setBackground(getResources().getDrawable(R.drawable.weight_text));
                tv_menu[8].setTextColor(Color.rgb(255, 255, 255));
                break;
            case R.id.taste_menu2:
                tasteunselected();
                tv_menu[9].setBackground(getResources().getDrawable(R.drawable.weight_text));
                tv_menu[9].setTextColor(Color.rgb(255, 255, 255));
                break;
            case R.id.taste_menu3:
                tasteunselected();
                tv_menu[10].setBackground(getResources().getDrawable(R.drawable.weight_text));
                tv_menu[10].setTextColor(Color.rgb(255, 255, 255));
                break;
            case R.id.taste_menu4:
                tasteunselected();
                tv_menu[11].setBackground(getResources().getDrawable(R.drawable.weight_text));
                tv_menu[11].setTextColor(Color.rgb(255, 255, 255));
                break;
            case R.id.num_less:
                if (num == 1) {
                    Toast.makeText(this, "亲，不能再删减了哦", Toast.LENGTH_SHORT).show();
                } else {
                    num = num - 1;
                    number.setText(num + "");
                }
                break;
            case R.id.num_plus:
                if (num >= inventory) {
                    Toast.makeText(this, "库存不足", Toast.LENGTH_SHORT).show();
                } else {
                    num = num + 1;
                    number.setText(num + "");
                }
                break;
            case R.id.exit:
                finish();
                break;
            case R.id.determine:
                finish();
                break;
            default:
        }

    }
}
