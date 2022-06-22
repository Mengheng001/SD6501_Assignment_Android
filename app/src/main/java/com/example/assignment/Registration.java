package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText username, password, confirmpassword;
    Button signup, signin;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        confirmpassword = (EditText) findViewById(R.id.confirmpassword);
        signin = (Button) findViewById(R.id.btnsignin);
        signup = (Button) findViewById(R.id.btnsignup);
        db = new DBHandler(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String confirmpass = confirmpassword.getText().toString();

                if(user.equals("") || pass.equals("") || confirmpass.equals(""))
                {
                    Toast.makeText(Registration.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(pass.equals(confirmpass))
                    {
                        boolean checkuser = db.checkusername(user);
                        if(checkuser == false)
                        {
                            boolean insert = db.insertDate(user,pass);
                            if(insert == true)
                            {
                                Toast.makeText(Registration.this, "Registration successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(Registration.this, "Registration failed", Toast.LENGTH_SHORT).show();

                            }
                        }
                        else
                        {
                            Toast.makeText(Registration.this, "User already exists, please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(Registration.this, "Please enter the same password", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}