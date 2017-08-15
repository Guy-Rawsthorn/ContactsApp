package com.example.guyrawsthorn.contactstutorial;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListContacts extends ListActivity {

    SimpleCursorAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contacts);
//        databaseHelper dbHelper = new databaseHelper(this);
//        dbHelper.deleteAllCountries();
//        dbHelper.insertData();
        displayList();
    }

    public void displayList() {
        databaseHelper dbHelper = new databaseHelper(this);
        Cursor cursor = dbHelper.getAllData();

        String[] from = new String[]{

                dbHelper.KEY_firstName,
                dbHelper.KEY_surName,
                // dbHelper.KEY_number,
                // dbHelper.KEY_email

        };


        int[] to = new int[]{
                R.id.left,
                R.id.right
        };

        dataAdapter = new SimpleCursorAdapter(this, R.layout.activity_list_view, cursor, from, to, 0);


        ListView listView = getListView();
        listView.setAdapter(dataAdapter);

        // attempted a listview click listener...

//        listView.setOnClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position,
//                                    long id) {
//                Intent intent = new Intent(this, ShowActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}