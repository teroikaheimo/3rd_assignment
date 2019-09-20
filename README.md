# listViewTehtava

Program consists of a button and a scrollable list (ListView) on same screen. The list is initially empty. Clicking on the button, the current time is added to the list. On the same row with the recorded time is a button called "Remove". Clicking on the button removes the row with the said time (including the button) from the list.

To achieve this you need to make your own Adapter class in a separate file where you extend (inherit) the ArrayAdapter<Date>-class. Then you need to set it as the adapter for the ListView. You also need a custom layout for each row of the ListView with a button and a textview in the layout.
