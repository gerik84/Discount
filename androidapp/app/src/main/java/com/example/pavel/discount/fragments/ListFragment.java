package com.example.pavel.discount.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.pavel.discount.adapters.AdaptorFabric;
import com.example.pavel.discount.adapters.PeterkaAdapter;
import com.example.pavel.discount.R;
import com.example.pavel.discount.Tools;

/**
 * Created by Pavel G on 10.10.2016.
 */
public class ListFragment extends  BaseFragment {

    protected RecyclerView mList;

    @Override
    protected int getResourceId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void setupUI(View root, Bundle savedInstanceState) {
        mList = (RecyclerView) root.findViewById(R.id.rv_list);
        Tools.checkNullPoint(mList);
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        mList.setAdapter(AdaptorFabric.getInstance(PeterkaAdapter.class));
    }
}
