package com.specialty.administrator.me;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.specialty.administrator.specialty.R;


public class PersonalCenter extends Activity implements View.OnClickListener{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_center);
        initView();
    }
    private void  initView(){
        ImageView arrow = findViewById(R.id.top_all_ImageView);
        arrow.setOnClickListener(this);
        TextView tv1 = findViewById(R.id.top_all_textView1);
        tv1.setText("个人中心");
        TextView tv2 = findViewById(R.id.top_all_textView2);
        tv2.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.top_all_ImageView:
                finish();
                break;
            default:
        }
    }
}
