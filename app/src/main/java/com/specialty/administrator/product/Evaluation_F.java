package com.specialty.administrator.product;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.specialty.administrator.adapter.EvaluationAdapter;
import com.specialty.administrator.beans.Evaluation;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Evaluation_F extends Fragment {
    private ArrayList<Evaluation>evaluationArrayList = new ArrayList<>();
    private View rootView;
    private EvaluationAdapter evaluationAdapter;
    private Context context;
    private ListView list_evaluation;

    public Evaluation_F() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = this.getActivity();
        evaluationAdapter = new EvaluationAdapter(evaluationArrayList,context);
        rootView = inflater.inflate(R.layout.evaluation_f, container, false);
        initView();
        list_evaluation.setAdapter(evaluationAdapter);
        initData();
        return rootView;
}
    private void  initView(){
        list_evaluation = rootView.findViewById(R.id.list_evaluation);
    }
    private  void initData(){
        evaluationArrayList.add(new Evaluation(0,"陈彬",R.mipmap.user,"1111111111111111111","2018-1-4"));
        evaluationArrayList.add(new Evaluation(1,"陈",R.mipmap.user,"1111111111111111111","2018-1-4"));
        evaluationArrayList.add(new Evaluation(2,"彬",R.mipmap.user,"1111111111111111111","2018-1-4"));
    }
}
