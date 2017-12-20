package com.specialty.administrator.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.specialty.administrator.specialty.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_F extends Fragment {
    public Home_F() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.home_f,container, false);
        return inflater.inflate(R.layout.home_f, container, false);

    }

}
