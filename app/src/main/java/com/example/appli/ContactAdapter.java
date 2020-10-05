package com.example.appli;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {

    Context context;
    ArrayList<Contact> list;

    public ContactAdapter(Context context, ArrayList<Contact> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ConstraintLayout layoutItem;
        LayoutInflater mInflater = LayoutInflater.from(context);

        if (view == null) {
            layoutItem = (ConstraintLayout) mInflater.inflate(R.layout.item_layout, viewGroup, false);
        } else {
            layoutItem = (ConstraintLayout) view;
        }

        TextView tv = (TextView)layoutItem.findViewById(R.id.textView);
        /*int res = context.getResources().getIdentifier(list.get(i).toLowerCase(), "mipmap", "com.example.appli");
        ImageView img = layoutItem.findViewById(R.id.imageView);

        if (res !=0) img.setImageResource(res);*/
        tv.setText(list.get(i).getPrenom() + " " + list.get(i).getNom());

        return layoutItem;
    }
}
