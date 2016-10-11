package com.example.pavel.discount.fragments;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pavel.discount.Tools;

/**
 * Created by Pavel G on 10.10.2016.
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(getResourceId(), null);
        Tools.checkNullPoint(root, "View not found");
        return root;
    }

    @Override
    public final void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        setupUI(view, savedInstanceState);
    }

    protected abstract @LayoutRes int getResourceId();

    protected abstract void setupUI(View root, Bundle savedInstanceState);
}
