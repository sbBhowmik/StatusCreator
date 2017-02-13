package com.rupik.fbstatuscreator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by macmin5 on 13/02/17.
 */

public class FontAdapter extends BaseAdapter {

    Context context;
    private static LayoutInflater inflater=null;
    ArrayList<Font> fontsArrayList;

    public FontAdapter(Context context, ArrayList<Font> fontsArrayList)
    {
        this.context = context;
        this.fontsArrayList = fontsArrayList;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return fontsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return fontsArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class Holder
    {
        TextView fontName;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.font_list_cell, null);

        holder.fontName = (TextView) rowView.findViewById(R.id.fontName);

        Font font = fontsArrayList.get(i);
        holder.fontName.setText(font.getFontName());
        holder.fontName.setTypeface(font.getFontTypeface());

        //


        //

        return rowView;
    }
}
