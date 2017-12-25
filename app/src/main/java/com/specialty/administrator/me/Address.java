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
public class Address extends Fragment {


    public Address() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.address, container, false);
    }

}
