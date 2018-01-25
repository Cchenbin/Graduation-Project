package com.specialty.administrator.specialty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.specialty.administrator.me.PasswordActivity;

public class ForgetActivity extends Activity implements View.OnClickListener {
    private TextView verification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget);
        initView();
    }

    private void initView() {
        TextView tv1 = findViewById(R.id.top_all_textView1);
        tv1.setText("修改密码");
        TextView tv2 = findViewById(R.id.top_all_textView2);
        tv2.setVisibility(View.INVISIBLE);
        ImageView back = findViewById(R.id.top_all_ImageView);
        back.setOnClickListener(this);
        verification = findViewById(R.id.verification);
        verification.setOnClickListener(this);
        Button next = findViewById(R.id.next);
        next.setOnClickListener(this);
    }

    //复写倒计时
    private class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            //防止计时过程中重复点击
            verification.setClickable(false);
            verification.setText(l / 1000 + "s");

        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //重新给Button设置文字
            verification.setText("重新获取验证码");
            //设置可点击
            verification.setClickable(true);
        }
    }

    @Override
    public void onClick(View view) {
        final MyCountDownTimer myCountDownTimer = new MyCountDownTimer(60000, 1000);
        switch (view.getId()) {
            case R.id.verification:
                myCountDownTimer.start();
                break;
            case R.id.next:
                Intent next = new Intent(ForgetActivity.this, PasswordActivity.class);
                startActivity(next);
                break;
            case R.id.top_all_ImageView:
                finish();
            default:
        }
    }
}
