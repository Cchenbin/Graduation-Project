package com.specialty.administrator.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.specialty.administrator.specialty.R;


public class Me_F extends Fragment implements View.OnClickListener{
    private LinearLayout l1;
    public Me_F() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.me_f, container, false);
        l1=rootView.findViewById(R.id.received);
        l1.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.received:
                Intent intent= new Intent();
                intent.setClass(getActivity(),Logistics.class);
                startActivity(intent);
                break;

            default:

                break;
        }
    }
}
