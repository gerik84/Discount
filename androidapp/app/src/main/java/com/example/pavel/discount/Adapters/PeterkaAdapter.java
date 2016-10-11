package com.example.pavel.discount.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.pavel.discount.R;

/**
 * Created by Pavel G on 11.10.2016.
 */
public class PeterkaAdapter extends BaseAdapter<PeterkaAdapter.Holder> {

    @Override
    protected int getResourceId() {
        return R.layout.cell_peterka;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.title.setText((CharSequence) m_data.get(position));
    }

    @Override
    protected Holder createHolder(View view) {
        return new Holder(view);
    }

    @Override
    protected String setUrl() {
        return null;
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView title;

        public Holder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
