package com.dmsoft.prizetech.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.dmsoft.prizetech.R;
import com.dmsoft.prizetech.activities.BaseActivity;


public abstract class BaseFragment extends Fragment {

    protected static String TAG = BaseFragment.class.getSimpleName();

    public void showProgressBar() {
        BaseActivity activity = (BaseActivity) getActivity();
        if (activity != null)
            activity.showProgressBar();
    }

    public void hideProgressBar() {
        BaseActivity activity = (BaseActivity) getActivity();
        if (activity != null)
            activity.hideProgressBar();
    }

    public void showSuccessNotificationBar(String message) {
        BaseActivity activity = (BaseActivity) getActivity();
        if (activity != null)
            activity.showSuccessNotificationBar(message);
    }

    public void showErrorNotificationBar(String message) {
        BaseActivity activity = (BaseActivity) getActivity();
        if (activity != null)
            activity.showErrorNotificationBar(message);
    }

    protected void  startFragment(int frameLayoutId, Fragment f) {
        startFragment(frameLayoutId, f, true, null);
    }

    protected void startFragment(int frameLayoutId, Fragment f, boolean addToBackStack, String tag) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameLayoutId, f);
        if(addToBackStack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }

    protected void startFragmentWithAnimation(int frameLayoutId, Fragment f, boolean addToBackStack, String tag) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.right_in, R.anim.left_out, R.anim.left_in, R.anim.right_out);
        fragmentTransaction.replace(frameLayoutId, f);
        if(addToBackStack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }
}
