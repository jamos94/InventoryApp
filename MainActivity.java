//****REGISTER/MAIN ACTIVITY****///
//PROMPTS USER TO CREATE ACCOUNT OR SIGN IN TO EXISTING ACCOUNT

package com.cs360.warehouseinventory;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //variables used to create a new user
    //buttons used to create user/ move to login activity

    EditText username, password, repassword;
    Button signup, signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //restate variables from xml and
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsignup);
        signin = (Button) findViewById(R.id.btnsignin);
        DB = new DBHelper(this);

        //OnClickListener listens for user touch on the register button
        signup.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String repass = repassword.getText().toString();


            // ****if/else statements ensure the date entered match the given requirements****//
            //check password and repassword are identical
            if(user.equals("")||pass.equals("")||repass.equals(""))
                Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

            //check database to ensure user doesn't already exist
            else{
                if(pass.equals(repass)){
                    Boolean checkuser = DB.checkusername(user);
                    if(!checkuser){
                        Boolean insert = DB.insertData(user, pass);
                        if(insert){
                            Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    //when user already exists in DB, user is prompted to login
                    else{
                        Toast.makeText(MainActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                }
            } });

        // when user clicks sign-in button, login activity is prompted
        signin.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });
    }
}