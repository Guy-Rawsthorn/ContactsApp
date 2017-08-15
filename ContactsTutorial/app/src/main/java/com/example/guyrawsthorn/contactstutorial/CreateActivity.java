package com.example.guyrawsthorn.contactstutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {

    EditText etName, etSurname, etNumber, etEmail;

    Button btn;

    private databaseHelper db = new databaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        btn = (Button) findViewById(R.id.btn);
        etName = (EditText) findViewById(R.id.etName);
        etSurname = (EditText) findViewById(R.id.etSurname);
        etNumber = (EditText) findViewById(R.id.etNumber);
        etEmail = (EditText) findViewById(R.id.etEmail);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData();
            }
        });
    }
    public void AddData() {

        boolean isInserted = db.addContact(new Contacts (etName.getText().toString(),
                etSurname.getText().toString(),
                etNumber.getText().toString(),
                etEmail.getText().toString()));

        if(isInserted ==true)
            Toast.makeText(CreateActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(CreateActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();

    }
}
