package com.specialty.administrator.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.specialty.administrator.specialty.R;

import static com.specialty.administrator.specialty.R.id.sever_privacy_about;

public class AboutActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        initView();
    }

    private void initView() {
        TextView sever_about = findViewById(R.id.sever_about);
        sever_about.setOnClickListener(this);
        TextView sever_privacy_about = findViewById(R.id.sever_privacy_about);
        sever_privacy_about.setOnClickListener(this);
        TextView about = findViewById(R.id.top_all_textView1);
        about.setText("关于");
        TextView save = findViewById(R.id.top_all_textView2);
        save.setVisibility(View.INVISIBLE);
        ImageView arrow = findViewById(R.id.top_all_ImageView);
        arrow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sever_about:
                Intent sever = new Intent(AboutActivity.this, WebViewActivity.class);
                sever.putExtra("sever", "0");
                startActivity(sever);

                break;
            case sever_privacy_about:
                Intent privacy = new Intent(AboutActivity.this, WebViewActivity.class);
                privacy.putExtra("sever", "1");
                startActivity(privacy);
                break;
            case R.id.top_all_ImageView:
                finish();
                break;
            default:
        }
    }
}
