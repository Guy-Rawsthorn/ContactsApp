package com.example.guyrawsthorn.contactstutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by guyrawsthorn on 14/08/2017.
 */

public class databaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "ContactsDB";
    // Table Name
    private static final String TABLE_CONTACTS = "contacts";

    public static final String KEY_ID = "_id";
    public static final String KEY_firstName = "firstName";
    public static final String KEY_surName = "surName";
    public static final String KEY_number = "number";
    public static final String KEY_email = "email";

    private static final String[] COLUMNS = {KEY_ID, KEY_firstName, KEY_surName, KEY_number, KEY_email};

    public Context context;

    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    private static final String DATABASE_CREATE = "CREATE TABLE if not exists " + TABLE_CONTACTS + " (" +
            KEY_ID + " integer PRIMARY KEY autoincrement," +
            KEY_firstName + "," +
            KEY_surName + "," +
            KEY_number + "," +
            KEY_email + "," +
            " UNIQUE (" + KEY_ID +"));";

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table

        // create Note table in DB
        db.execSQL(DATABASE_CREATE);
        db.execSQL(getInsertQuery(0, "Guy", "Rawsthorn", "07778565782", "guy.rawsthorn@btopenworld.com"));
        db.execSQL(getInsertQuery(1, "Oscar", "Gutierez", "0777898654", "oscarG@gmail.com"));
        db.execSQL(getInsertQuery(2, "Anwar", "Siziba", "0776878954", "Anwars@aol.co.uk"));
        db.execSQL(getInsertQuery(3, "George", "Wilks", "07776562342", "georgeJWilks@gmail.com"));
        db.execSQL(getInsertQuery(4, "Lewis", "riddell", "07564323455", "lewis@riddellfintech.com"));
        db.execSQL(getInsertQuery(5, "Oliver", "May", "076787989898", "OliverMay@idonthaveemail.com"));
        db.execSQL(getInsertQuery(6, "Calvin", "MArtin", "07778565782", "calvinMartin@iEmailLots.com"));
        db.execSQL(getInsertQuery(7, "Alister", "Clarke", "077785657822", "AlisterClark@me.com"));
    }

    public String getInsertQuery(int key, String fName, String sName,
                                 String number, String email) {
        return("INSERT INTO " + TABLE_CONTACTS + " VALUES (" + key + ", '"  + fName + "', '" + sName + "', '" + number + "', '" + email + "');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE contacts");
        db.execSQL("CREATE TABLE IF NOT EXISTS contacts ( " +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_firstName + " TEXT, " +
                KEY_surName + " TEXT " +
                KEY_number + " TEXT " +
                KEY_email + " TEXT )");
    }

    public boolean addContact(Contacts contacts) {
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_firstName, contacts.getFirstName()); // get title
        values.put(KEY_surName, contacts.getSurName()); // get
        values.put(KEY_number, contacts.getNumber()); // get title
        values.put(KEY_email, contacts.getEmail());

        // 3. insert
        Long result = db.insert(TABLE_CONTACTS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
        if (result == -1)
            return false;
        else
            return true;
    }

    public long createContact(String fName, String sName,
                              String number, String email) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_firstName, fName);
        initialValues.put(KEY_surName, sName);
        initialValues.put(KEY_number, number);
        initialValues.put(KEY_email, email);
        return db.insert(TABLE_CONTACTS, null, initialValues);
    }


    public Cursor getAllData() {
        // 1. build the query

        // 2. get reference to writable DB

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CONTACTS, null);
        return cursor;
    }
    public boolean deleteAllCountries() {
        SQLiteDatabase db = this.getWritableDatabase();
        int doneDelete = 0;
        doneDelete = db.delete(TABLE_CONTACTS, null , null);
        return doneDelete > 0;
    }


}
