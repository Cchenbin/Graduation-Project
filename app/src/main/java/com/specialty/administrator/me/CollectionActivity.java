package com.specialty.administrator.me;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.specialty.administrator.adapter.Collection_Adapter;
import com.specialty.administrator.beans.Collection;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;

public class CollectionActivity extends Activity implements View.OnClickListener {
    private Context context;
    private ArrayList<Collection> collections = new ArrayList<>();
    private Collection_Adapter collection_adapter;
    private ListView listView;
    private TextView collection,save;
    private ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.collection_activity);
        initView();
        initData();
        collection_adapter = new Collection_Adapter(collections, context);
        listView.setAdapter(collection_adapter);
    }

    private void initView() {
        listView = findViewById(R.id.collection_list);
        collection = findViewById(R.id.top_all_textView1);
        collection.setText("我的收藏");
        save = findViewById(R.id.top_all_textView2);
        save.setVisibility(View.INVISIBLE);
        arrow = findViewById(R.id.top_all_ImageView);
        arrow.setOnClickListener(this);
    }

    private void initData() {
        collections.add(new Collection(0, R.drawable.fruit, "新疆库尔勒香梨梨子香妃梨", "¥" + 19.9));
        collections.add(new Collection(1, R.drawable.fruit, "新疆库尔勒香梨梨子香妃梨", "¥" + 19.9));
        collections.add(new Collection(2, R.drawable.fruit, "新疆库尔勒香梨梨子香妃梨", "¥" + 19.9));
        collections.add(new Collection(3, R.drawable.fruit, "新疆库尔勒香梨梨子香妃梨", "¥" + 19.9));
        collections.add(new Collection(4, R.drawable.fruit, "新疆库尔勒香梨梨子香妃梨", "¥" + 19.9));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.top_all_ImageView:
                finish();
                break;
            default:
        }
    }
}
