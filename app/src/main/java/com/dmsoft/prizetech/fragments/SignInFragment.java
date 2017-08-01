package com.dmsoft.prizetech.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dmsoft.prizetech.R;

import butterknife.ButterKnife;

/**
 * Created by dev on 12/05/2017.
 */

public class SignInFragment extends BaseFragment{

    public static SignInFragment newInstance() {
        SignInFragment fragment = new SignInFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
}
