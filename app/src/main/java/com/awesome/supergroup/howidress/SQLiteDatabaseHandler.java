package com.awesome.supergroup.howidress;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alx on 26/05/2015.
 */
public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ClothesDB";
    private static final String TABLE_NAME = "ClothesTable";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SLOT = "slot";
    private static final String KEY_COLOR = "color";
    private static final String[] COLONNES = { KEY_ID, KEY_NAME, KEY_SLOT,KEY_COLOR };

    public SQLiteDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i("SQLite DB : Constructeur ", "Constructeur");

    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {

        String CREATION_TABLE_EXEMPLE = "CREATE TABLE FoodsTable ( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT, "
                + "price TEXT, " + "quantity INTEGER )";

        arg0.execSQL(CREATION_TABLE_EXEMPLE);
        Log.i("SQLite DB", "Creation");

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

        arg0.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(arg0);
        Log.i("SQLite DB", "Upgrade");


    }

    public void deleteOne(Clothe clothe) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, // table
                "id = ?", new String[]{String.valueOf(clothe.getId())});
        db.close();
        Log.i("SQLite DB : Delete : ", clothe.toString());

    }

    public Clothe showOne(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, // a. table
                COLONNES, // b. column names
                " id = ?", // c. selections
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        if (cursor != null)
            cursor.moveToFirst();
        Clothe clothe = new Clothe();
        clothe.setId(Integer.parseInt(cursor.getString(0)));
        clothe.setName(cursor.getString(1));
        clothe.setSlot(e_clothes.valueOf(cursor.getString(2)));
        clothe.setColor(Color.parseColor(cursor.getString(3)));

        // log
        Log.i("SQLite DB : Show one  : id=  "+id, clothe.toString());
        return clothe;
    }

    public List<Clothe> showAll() {

        List<Clothe> theClothes = new LinkedList<Clothe>();
        String query = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Clothe clothe = null;
        if (cursor.moveToFirst()) {
            do {
                clothe = new Clothe();
                clothe.setId(Integer.parseInt(cursor.getString(0)));
                clothe.setName(cursor.getString(1));
                clothe.setSlot(e_clothes.valueOf(cursor.getString(2)));
                clothe.setColor(Color.parseColor(cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        Log.i("SQLite DB : Show All  : ", theClothes.toString());
        return theClothes;
    }

    public void addOne(Clothe food) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, food.getName());
        values.put(KEY_SLOT, String.valueOf(food.getSlot()));
        values.put(KEY_COLOR, food.getColor());
        // insertion
        db.insert(TABLE_NAME, // table
                null, values);

        db.close();
        Log.i("SQLite DB : Add one  : id=  "+food.getId(), food.toString());
    }

    public int updateOne(Clothe p_clothe) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, p_clothe.getName());
        values.put(KEY_SLOT, String.valueOf(p_clothe.getSlot()));
        values.put(KEY_COLOR, p_clothe.getColor());

        int i = db.update(TABLE_NAME, // table
                values, // column/value
                "id = ?", // selections
                new String[] { String.valueOf(p_clothe.getId()) });

        db.close();
        Log.i("SQLite DB : Update one  : id=  "+p_clothe.getId(), p_clothe.toString());

        return i;
    }
}
