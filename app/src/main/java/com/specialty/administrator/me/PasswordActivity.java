package com.specialty.administrator.me;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.specialty.administrator.specialty.R;

public class PasswordActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        initView();
    }
    private void initView(){
        TextView title = findViewById(R.id.top_all_textView1);
        title.setText("修改密码");
        TextView save = findViewById(R.id.top_all_textView2);
        save.setVisibility(View.INVISIBLE);
        ImageView back = findViewById(R.id.top_all_ImageView);
        back.setOnClickListener(this);
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
