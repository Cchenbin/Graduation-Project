package com.specialty.administrator.me;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.specialty.administrator.specialty.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Personal_center extends Fragment {


    public Personal_center() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.personal_center, container, false);
    }

}
