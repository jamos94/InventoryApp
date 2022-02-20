//*** SMS ACTIVITY ***///
//PROMPTS USER TO ENTER PHONE NUMBER
//TO ENABLE SMS MESSAGING REGARDING LOW INVENTORY
//THEN PROMPTS THE USER TO THE INVENTORY ACTIVITY

package com.cs360.warehouseinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class smsActivity extends AppCompatActivity {
    TextView smsmessage;
    EditText phonenumber;
    Button messagesignup, skipped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        //RELATES VARIABLES TO XML FILE BY ID
        smsmessage = (TextView) findViewById(R.id.smsmessage);
        phonenumber = (EditText) findViewById(R.id.phonenumber);
        messagesignup = (Button) findViewById(R.id.messagesignup);
        skipped = (Button) findViewById(R.id.skipped);

        //LISTENS FOR USER INTERACTION WITH SIGNUP BUTTON
        messagesignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone_number = phonenumber.getText().toString();

                if (phone_number.equals(""))
                    Toast.makeText(smsActivity.this, "Enter a correct number", Toast.LENGTH_SHORT).show();
                else {
                    //Notifications Enabled!
                    Toast.makeText(smsActivity.this, "Notifications are enabled", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),InventoryActivity.class);
                    startActivity(intent);
                }
            }
        });

        //LISTENS FOR USER INTERACTION WITH SKIP BUTTON
        skipped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),InventoryActivity.class);
                startActivity(intent);
            }
        });
    }}

