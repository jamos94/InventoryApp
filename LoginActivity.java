//      ****LOGIN ACTIVITY******
// THIS ACTIVITY PROMPTS THE USER TO ENTER CREDENTIALS
// AFTER CREDENTIALS ARE CONFIRMED, USER IS PROMPTED TO
// SMS MESSAGING ACTIVITY

package com.cs360.warehouseinventory;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//class extends
public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnsignin1;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnsignin1 = (Button) findViewById(R.id.btnsignin1);

        //Statement is commented out because of unresolved bug
        // i belive this is also related to
        // being unable to extend to inventoryactivity.java
        //DB = new getApplication(this);

        btnsignin1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                //check if credentials match to a data entry in DB
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);

                    // when user credentials match from database, login succeeds and sms messaging activity is prompted
                    if(checkuserpass==true){
//                        Toast.makeText(LoginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();

                        Intent intent  = new Intent(getApplicationContext(), smsActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}