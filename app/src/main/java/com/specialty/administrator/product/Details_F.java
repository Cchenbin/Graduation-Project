package com.specialty.administrator.product;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.specialty.administrator.specialty.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Details_F extends Fragment {


    public Details_F() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.details_f, container, false);
    }

}
