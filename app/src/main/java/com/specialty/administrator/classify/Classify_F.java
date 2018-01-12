package com.specialty.administrator.classify;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.specialty.administrator.adapter.ClassifyAdapter;
import com.specialty.administrator.adapter.Classify_gridView_Adapter;
import com.specialty.administrator.beans.Classify;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;


public class Classify_F extends Fragment implements View.OnClickListener {
    private ListView classify_list;
    private Context context;
    private View rootView;
    private LinearLayout foSearch;
    private ArrayList<Classify> classifyArrayList = new ArrayList<>();
    private ClassifyAdapter ClassAdapter;
    private Classify_gridView_Adapter gridView_adapter;
    private GridView gridView;
    private String[] titles = new String[]{"花生", "地瓜干", "豆腐干", "笋干", "肉干"};
    private Integer[] images = {R.mipmap.peanut, R.mipmap.potatoes, R.mipmap.tofu, R.mipmap.shoots, R.mipmap.meat};
    private String[] title = new String[]{"地瓜干", "花生", "笋干", "豆腐干", "肉干"};
    private Integer[] image = {R.mipmap.potatoes, R.mipmap.peanut, R.mipmap.shoots, R.mipmap.tofu, R.mipmap.meat};

    public Classify_F() {
        // Required empty public constructor
    }

    private String name;

    @SuppressLint("ValidFragment")
    public Classify_F(String name) {
        super();
        this.name = name;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        context = this.getActivity();
        rootView = inflater.inflate(R.layout.classify_f, container, false);
        initView();
        ClassAdapter = new ClassifyAdapter(classifyArrayList, context);
        classify_list.setAdapter(ClassAdapter);
        gridView_adapter = new Classify_gridView_Adapter(titles, images, context);
        gridView.setAdapter(gridView_adapter);
        initData();
        if (name != null) {
            for (int i = 0; i < classifyArrayList.size(); i++) {
                String type = classifyArrayList.get(i).getClassify();
                classifyArrayList.get(i).setIsSelected(0);
                if (name.equals(type)) {
                    classifyArrayList.get(i).setIsSelected(1);

                }
            }
        }
        return rootView;
    }

    private void initView() {

        classify_list = rootView.findViewById(R.id.list_classify);
        gridView = rootView.findViewById(R.id.classify_menu);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Classify_F.this.getActivity(), Classification.class);
                startActivity(intent);
            }
        });
        foSearch = rootView.findViewById(R.id.foSearch);
        foSearch.setVisibility(View.VISIBLE);
        classify_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                for (int i = 0; i < classifyArrayList.size(); i++) {
                    if (!(classifyArrayList.get(i)).equals(position)) {
                        classifyArrayList.get(i).setIsSelected(0);
                    }
                }
                classifyArrayList.get(position).setIsSelected(1);
                classify_list.setAdapter(ClassAdapter);
                if (position == 0) {
                    gridView_adapter = new Classify_gridView_Adapter(titles, images, context);
                    gridView.setAdapter(gridView_adapter);
                } else if (position == 1) {
                    gridView_adapter = new Classify_gridView_Adapter(title, image, context);
                    gridView.setAdapter(gridView_adapter);
                }
            }
        });
    }

    private void initData() {
        classifyArrayList.add(new Classify(1, "干货"));
        classifyArrayList.add(new Classify(0, "生鲜"));
        classifyArrayList.add(new Classify(0, "1111111"));
        classifyArrayList.add(new Classify(0, "1111111"));
        classifyArrayList.add(new Classify(0, "1111111"));
        classifyArrayList.add(new Classify(0, "1111111"));
    }

    @Override
    public void onClick(View view) {

    }
}
