package com.specialty.administrator.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.specialty.administrator.specialty.R;

public class EditNameActivity extends Activity implements View.OnClickListener {
    private EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_name);
        initView();
    }

    private void initView() {
        ImageView arrow = findViewById(R.id.top_all_ImageView);
        arrow.setOnClickListener(this);
        TextView tv1 = findViewById(R.id.top_all_textView1);
        tv1.setText("更改用户名");
        TextView tv2 = findViewById(R.id.top_all_textView2);
        tv2.setVisibility(View.INVISIBLE);
        Button btn = findViewById(R.id.edit_submit);
        btn.setOnClickListener(this);
        edittext = findViewById(R.id.edit_name);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.top_all_ImageView:
                finish();
                break;
            case R.id.edit_submit:
                String name = edittext.getText().toString();
                if (name.trim().equals("")) {
                    Toast.makeText(EditNameActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("name", name);
                    setResult(2, intent);
                    finish();
                }
                break;
            default:
        }
    }
}
