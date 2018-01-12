package com.specialty.administrator.me;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.specialty.administrator.specialty.R;

public class FeedbackActivity extends Activity implements View.OnClickListener {
    private ImageView arrow;
    private TextView back, save;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);
        initView();
    }

    private void initView() {
        back = findViewById(R.id.top_all_textView1);
        back.setText("问题反馈");
        save = findViewById(R.id.top_all_textView2);
        save.setVisibility(View.INVISIBLE);
        arrow = findViewById(R.id.top_all_ImageView);
        arrow.setOnClickListener(this);
        submit = findViewById(R.id.back_submit);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.top_all_ImageView:
                finish();
                break;
            case R.id.back_submit:
                finish();
                break;
            default:
        }
    }
}
