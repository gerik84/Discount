package com.example.pavel.discount.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel G on 10.10.2016.
 */
abstract class BaseAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<Object> m_data;

    protected BaseAdapter() {
        setUrl();
        m_data = new ArrayList<>();
        m_data.add("asdad1");
        m_data.add("asdad2");
        m_data.add("asdad3");
        m_data.add("asdad4");
    }

    abstract protected int getResourceId();
    abstract protected VH createHolder(View view);
    abstract protected String setUrl();

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(getResourceId(), parent, false);
        return createHolder(v);
    }

    @Override
    public int getItemCount() {
        return m_data.size();
    }


}
