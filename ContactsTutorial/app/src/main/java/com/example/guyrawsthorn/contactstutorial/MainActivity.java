package com.example.guyrawsthorn.contactstutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button createContacts;
    Button viewContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createContacts = (Button) findViewById(R.id.button1);
        viewContacts = (Button) findViewById(R.id.button2);

        createContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCreate();
            }
        });

        viewContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadView();
            }
        });
    }
    public void loadCreate(){
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

    public void loadView(){
        Intent intent = new Intent(this, ListContacts.class);
        startActivity(intent);
    }
}

