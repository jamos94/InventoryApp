//****UPDATE INVENTORY ACTIVITY****//
//WHEN USER CLICKS UPDATE INVENTORY ON INVENTORY ACTIVITY
// THEY ARE PROMPTED TO THIS ACTIVITY TO ADJUST OR CREATE A NEW ENTRY


package com.cs360.warehouseinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateInventory extends AppCompatActivity {

    EditText price, quantity, item;
    Button delete, update, view_data, insert;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_inventory);

        //RELATES VARIABLES TO XML FILE BY ID
        price = findViewById(R.id.price);
        quantity = findViewById(R.id.quantity);
        item = findViewById(R.id.item);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);
        view_data = findViewById(R.id.view_data);
        insert = findViewById(R.id.insert);

//        DB = new DBHelper(this);      //TODO: DEBUG

        //INSERT NEW ENTRY
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemTXT = item.getText().toString();
                String priceTXT = price.getText().toString();
                String quantityTXT = quantity.getText().toString();


            }
        });
    }
}