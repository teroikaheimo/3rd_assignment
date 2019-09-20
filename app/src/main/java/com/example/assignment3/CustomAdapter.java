package com.example.assignment3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<RowItem> {
    private Context context;
    private List<RowItem> rowItems;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<RowItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.rowItems = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // TODO varmista että view päivitetään vain tarvittaessa
        // Get the item to be displayed
        RowItem rowItem = rowItems.get(position);

        // Get inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // Get the custom layout for list items
        View view = inflater.inflate(R.layout.list_item_layout, null);

        return view;
    }
}
