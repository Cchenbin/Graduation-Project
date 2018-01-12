package com.specialty.administrator.me;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.specialty.administrator.specialty.R;

import static com.specialty.administrator.specialty.R.id.top_all_textView2;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddAddress extends Activity implements View.OnClickListener {
    private ImageView arrow;
    private CheckBox chech;
    private TextView save,title;
    private EditText[] ed_text  = new EditText[3];
    private int[] ed_text_id = {R.id.Receiver, R.id.address_phone, R.id.editText};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_address);
        initView();
    }

    private void initView() {

        for (int i = 0; i < ed_text.length; i++) {
            ed_text[i] = findViewById(ed_text_id[i]);
        }

        save = findViewById(R.id.top_all_textView2);
        save.setOnClickListener(this);
        title = findViewById(R.id.top_all_textView1);
        title.setText("添加新地址");
        arrow = findViewById(R.id.top_all_ImageView);
        arrow.setOnClickListener(this);
        chech = findViewById(R.id.checkbox);
        chech.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            private boolean check = false ;
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!check ){
                chech.setBackground(getResources().getDrawable(R.drawable.checkboxon));
                    check = true;
            }else {
                    chech.setBackground(getResources().getDrawable(R.drawable.checkboxun));
                    check = false;
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.top_all_ImageView:
                finish();
                break;
            case top_all_textView2:
                Intent address = new Intent(AddAddress.this,AddressActivity.class);
                startActivity(address);
                finish();
            default:
        }

    }
}
