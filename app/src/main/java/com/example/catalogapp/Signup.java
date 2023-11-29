package com.example.catalogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        TextView txt=findViewById(R.id.nextLoginText);
        Button btnSignUp=findViewById(R.id.btnSignUp);
        EditText userSpName=findViewById(R.id.userSignupName);
        EditText userSpPass=findViewById(R.id.userSignupPass);
        EditText userSpConfirmPass=findViewById(R.id.userSignupConfirmPass);




        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String name = userSpName.getText().toString();
                String pass = userSpPass.getText().toString();
                String cpass = userSpConfirmPass.getText().toString();

                if (name.isEmpty()) {
                    userSpName.requestFocus();
                    userSpName.setError("Username required");

                } else if (pass.isEmpty()) {
                    userSpPass.requestFocus();
                    userSpPass.setError("Password required");
                } else if (cpass.isEmpty()) {
                    userSpConfirmPass.requestFocus();
                    userSpConfirmPass.setError("Confirm Password  required");

                } else {

                    if(pass.equalsIgnoreCase(cpass))
                    {


                        Toast.makeText(Signup.this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();


                    }else {
                        userSpConfirmPass.setError("Password does`nt match");
                    }






                }
            }





        });



        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Signup.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}