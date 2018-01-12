package com.specialty.administrator.me;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import com.specialty.administrator.specialty.R;

public class CommentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment);
        initView();
    }
    private void initView(){
        TextView title = findViewById(R.id.top_all_textView1);
        title.setText("发表评论");
        TextView release= findViewById(R.id.top_all_textView2);
        release.setText("发布");
    }
}
