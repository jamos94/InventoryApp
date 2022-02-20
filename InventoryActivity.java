//****INVENTORY ACTIVITY****//
//DISPLAYS INVENTORY ON GRIDVIEW
//USER CAN CLICK TO UPDATE INVENTORY

package com.cs360.warehouseinventory;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;

//I have been trying to figure out how to extend AppComactActivity and
//SQLiteOpenHelper to resolve bug in AndroidManifest

//This class should extend AppCompactActivity
public class InventoryActivity extends SQLiteOpenHelper {

    //TODO: create another class which enables SQLiteOpenHelper

    // naming database inventory.db
    public static final String DBNAME = "Inventory.db";

    //button updates db into grid
    Button update_grid;


    public InventoryActivity(Context context) { super(context, "Inventory.db", null, 1) ;}

    // pulls data from inventory.db to display in view grid
    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table inventory(item TEXT primary key, quantity NUMBER, price NUMBER)");


   }

   // drops table if exists
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists inventory");
    }


}