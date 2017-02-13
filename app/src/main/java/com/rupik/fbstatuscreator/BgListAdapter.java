package com.rupik.fbstatuscreator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by macmin5 on 13/02/17.
 */

public class BgListAdapter extends BaseAdapter {

    Context context;
    private static LayoutInflater inflater=null;
    int bgDataSet[];

    public BgListAdapter(Context context, int bgDataSet[])
    {
        this.context = context;
        this.bgDataSet = bgDataSet;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return bgDataSet.length;
    }

    @Override
    public Object getItem(int i) {
        return bgDataSet[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class Holder
    {
        ImageView bgImageView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.bg_selection_cell, null);

        holder.bgImageView = (ImageView)rowView.findViewById(R.id.bgImageView);
        holder.bgImageView.setImageResource(bgDataSet[i]);

        return rowView;
    }
}
