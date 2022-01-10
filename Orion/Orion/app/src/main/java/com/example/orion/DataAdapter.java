package com.example.orion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends ArrayAdapter {
    ArrayList<String> peopleName = new ArrayList();

    public DataAdapter(Context context, int resource) {
        super(context, resource);
    }

    public DataAdapter(@NonNull Context context, int resource, ArrayList<String> peopleName) {
        super(context, resource);
        this.peopleName = peopleName;
    }

    @Override
    public int getCount() {
        return peopleName.size();
    }

    @Override
    public Object getItem(int position) {
        return peopleName.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        DataHolder dataHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.single_listview, parent, false);
            dataHolder = new DataHolder();
            dataHolder.usernameTV =  row.findViewById(R.id.usernameTV);
            row.setTag(dataHolder);
        } else {
            dataHolder = (DataHolder) row.getTag();
        }
        String name = peopleName.get(position);
        dataHolder.usernameTV.setText(name);
        return row;
    }

    public void filterList(ArrayList<String> filteredlist) {
        peopleName= filteredlist;
        notifyDataSetChanged();
    }

    static class DataHolder {
        TextView usernameTV;
    }
}