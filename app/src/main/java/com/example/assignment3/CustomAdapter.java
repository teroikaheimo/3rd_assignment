package com.example.assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CustomAdapter extends ArrayAdapter<Date> {
    private Context context;
    private List<Date> rowItems;

    public CustomAdapter(@NonNull Context context, ArrayList<Date> dates) {
        super(context, 0, dates);
        this.context = context;
        this.rowItems = dates;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the item to be displayed
        final Date rowItem = rowItems.get(position);

        // IF null then inflate the layout. Otherwise just update layout contents.
        if (convertView == null) {
            // Get the custom layout and inflate it
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
        }

        // Get the customLayout components
        TextView datetimeText = convertView.findViewById(R.id.datetimeText);
        Button removeButton = convertView.findViewById(R.id.removeButton);

        // Format the dateNow to string with specified format and set row text
        String currentTime = new SimpleDateFormat("HH:mm:ss dd.MM.YYYY", Locale.getDefault()).format(rowItem);
        datetimeText.setText(currentTime);

        // Set row remove button functionality
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove the item from the list
                rowItems.remove(position);
                // Call for a re-render
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
