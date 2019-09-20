package com.example.assignment3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/*
* Program consists of a button and a scrollable list (ListView) on same screen.
* The list is initially empty. Clicking on the button, the current time is added to the list.
* On the same row with the recorded time is a button called "Remove".
* Clicking on the button removes the row with the said time (including the button) from the list.

To achieve this you need to make your own Adapter class in a separate file where you extend (inherit) the ArrayAdapter<Date>-class.
* Then you need to set it as the adapter for the ListView.
* You also need a custom layout for each row of the ListView with a button and a textview in the layout.

Important functions and classes related to this assignment:

.setAdapter();

@Override
getView();

notifyDataSetChanged();

LayoutInflater.inflate()
* */
public class MainActivity extends AppCompatActivity {
    CustomAdapter customAdapter;
    ArrayList<Date> listItems = new ArrayList<>();
    ListView timeDateList;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // List that contains times and remove buttons
        this.timeDateList = findViewById(R.id.timeDateList);

        // List adapter
        customAdapter = new CustomAdapter(this, listItems);

        // Set list adapter
        this.timeDateList.setAdapter(customAdapter);


        // Button to add dates to the list
        this.buttonAdd = findViewById(R.id.buttonAdd);
        this.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTimeListItem();
            }
        });
    }

    private void addTimeListItem() {
        // Get current date and time
        Date dateNow = Calendar.getInstance().getTime();
        customAdapter.add(dateNow);
    }
}
