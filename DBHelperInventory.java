//**** DB HELPER -> INVENTORY ****//
//HELPS INVENTORY DATABASE PLACEMENT AND ADJUSTMENTS

package com.cs360.warehouseinventory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperInventory extends SQLiteOpenHelper {

    public DBHelperInventory(Context context) {
        super(context, "Inventory.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        //CREATES INVENTORY DB
        DB.execSQL("create Table Inventory(item TEXT primary key, quantity NUMBER, price NUMBER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Inventory");

    }

    //INSERTS DATA INTO DATABASE BASED ON CONTENT VALUES
    public Boolean insertData(String item, int price, int quantity){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("item", item);
        contentValues.put("price", price);
        contentValues.put("quantity", quantity);

        long result = DB.insert("Inventory,", null, contentValues);
        return result != -1;
    }

    // UPDATING DATA
    public Boolean updateData(String item, int price, int quantity) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("item", item);
        contentValues.put("price", price);
        contentValues.put("quantity", quantity);
        Cursor cursor = DB.rawQuery("Select * from Inventory where item=?", new String[]{item});
        if (cursor.getCount() > 0) {
            long result = DB.update("Inventory,", contentValues, "item =?", new String[]{item});
            return result != -1;
            }
        else {
            return false;
        }
    }

    //DELETING DATA
    public Boolean deleteData (String item) {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from Inventory where item=?", new String[]{item});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Inventory,", "item =?", new String[]{item});
            return result != -1;
        } else {
            return false;
        }
    }

    // DISPLAY DATA
    public Cursor getdata () {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Inventory", null );
        return  cursor;
    }
}