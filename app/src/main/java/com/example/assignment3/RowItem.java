package com.example.assignment3;

import android.widget.Button;

public class RowItem {
    String timeString;
    Button removeButton;

    public void RowItem(String time, Button remove) {
        this.timeString = time;
        this.removeButton = remove;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public Button getRemoveButton() {
        return removeButton;
    }

    public void setRemoveButton(Button removeButton) {
        this.removeButton = removeButton;
    }
}
