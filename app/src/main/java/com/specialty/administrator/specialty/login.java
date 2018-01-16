package com.specialty.administrator.specialty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class login extends Activity implements View.OnClickListener {
    private String account,passwoed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initView();
    }
    private void initView(){
        ImageView back = findViewById(R.id.log_back);
        back.setOnClickListener(this);
        EditText log_account = findViewById(R.id.log_account);
        account = log_account.getText().toString();
        EditText log_password = findViewById(R.id.log_password);
        passwoed = log_password.getText().toString();
        Button log_confirm = findViewById(R.id.log_confirm);
        log_confirm.setOnClickListener(this);
        TextView log_forget = findViewById(R.id.log_forget);
        log_forget.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.log_back:
                finish();
                break;
            case R.id.log_confirm:
                if (account.equals(passwoed)){
                    Intent log = new Intent(login.this,MainActivity.class);
                    startActivity(log);
                }
            default:
        }
    }
}
