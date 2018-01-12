package com.specialty.administrator.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.specialty.administrator.specialty.R;
import com.specialty.administrator.view.ProgressWebView;

import static android.webkit.WebSettings.LayoutAlgorithm.SINGLE_COLUMN;

public class WebViewActivity extends Activity implements View.OnClickListener{
    private ProgressWebView webView;
    private String sever1;
    private TextView tv1,tv2;
    private ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);
        Intent intent = getIntent();
        sever1 = intent.getStringExtra("sever");
        initView();
    }

    private void initView() {
        tv1 =findViewById(R.id.top_all_textView1);
        tv2 = findViewById(R.id.top_all_textView2);
        tv2.setVisibility(View.INVISIBLE);
        arrow =findViewById(R.id.top_all_ImageView);
        arrow.setOnClickListener(this);
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLayoutAlgorithm(SINGLE_COLUMN);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        initWeb();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }
        finish();//结束退出程序
        return false;
    }

    private void initWeb() {
        if (sever1.equals("0")) {
            webView.loadUrl("https://zhidao.baidu.com/question/1702904154175600780.html");
            tv1.setText("服务条款");
        } else if (sever1.equals("1")){
            webView.loadUrl("https://www.baidu.com/duty/yinsiquan.html");
            tv1.setText("隐私声明");
        }else {
            webView.loadUrl("https://world.taobao.com/helper/knowledge.htm?kid=13063429");
            tv1.setText("帮助中心");
        }
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
