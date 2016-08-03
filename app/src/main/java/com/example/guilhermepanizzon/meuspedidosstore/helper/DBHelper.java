package com.example.guilhermepanizzon.meuspedidosstore.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.guilhermepanizzon.meuspedidosstore.Model.FavItems;

import java.util.ArrayList;

/**
 * Created by guilhermepanizzon on 8/2/16.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "meuspedidosdb.db";
    private static final int VERSAO_SCHEMA = 3;
    private static final String FAVORITES_TABLE = "favorite";
    private static final String KEY_ID = "id";
    private static final String KEY_ID_PRODUCT = "idProduct";
    private static final String KEY_PRODUCT_NAME = "nameProduct";
    private static final String KEY_ID_FAVORITE_VALUE = "favoriteValue";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSAO_SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FAVORITES_TABLE = "CREATE TABLE " + FAVORITES_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_PRODUCT_NAME + " TEXT,"
                + KEY_ID_FAVORITE_VALUE + " INTEGER" + ")";
        db.execSQL(CREATE_FAVORITES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //  sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FAVORITES_TABLE);
        // onCreate(sqLiteDatabase);
    }

    public void insertFavorites(String productName, Integer favoriteValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID_PRODUCT, productName);
        contentValues.put(KEY_ID_FAVORITE_VALUE, favoriteValue);
        db.insert(FAVORITES_TABLE, null, contentValues);
        db.close();


    }

    public String getFavorite(String prouductName) {

        String result;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(FAVORITES_TABLE, new String[]{
                        KEY_ID_FAVORITE_VALUE}, KEY_PRODUCT_NAME + "=?",
                new String[]{prouductName}, null, null, null, null);
        Log.d("Count", String.valueOf(cursor.getCount()));
        if (cursor.getCount() > 0) {
            result = cursor.getString(0);
        } else {
            return null;
        }
        db.close();
        return result;
    }

    public ArrayList<FavItems> getAllFavoritesFromDB() {
        ArrayList<FavItems> favoriteList = new ArrayList<FavItems>();
        String selectQuery = "SELECT * FROM " + FAVORITES_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                FavItems valueItem = new FavItems();
                valueItem.setProductName(cursor.getString(1));
                valueItem.setIsFavoriteValue(cursor.getInt(2));
                favoriteList.add(valueItem);
            } while (cursor.moveToNext());
        }

        db.close();
        return favoriteList;
    }

    public void removeFavorites(Integer idProduct) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(FAVORITES_TABLE, KEY_ID + " = ?",
                new String[]{String.valueOf(idProduct)});
        db.close();
    }


}



