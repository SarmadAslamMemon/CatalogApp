package com.example.catalogapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView nextsignup;
    Button btn;
    EditText username,userpassword;
    ProgressDialog myprogress;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextsignup=findViewById(R.id.nextsignup);
        btn=findViewById(R.id.btnlogin);
        username=findViewById(R.id.userloginname);
        userpassword=findViewById(R.id.userloginpass);
        btn.setOnClickListener(new View.OnClickListener() {

                                   @Override
                                   public void onClick(View view) {

                                       String name = username.getText().toString();
                                       String pass = userpassword.getText().toString();

                                       if (name.isEmpty()) {
                                           username.requestFocus();
                                           username.setError("Username required");

                                       } else if (pass.isEmpty()) {
                                           userpassword.requestFocus();
                                           userpassword.setError("Username required");
                                       } else {




 //Alert Dialogue box code
//                    AlertDialog.Builder alert= new AlertDialog.Builder(MainActivity.this);
//                    alert.setTitle("Login Details");
//                    alert.setMessage("My username is"+name+" and password is"+pass );
//                    alert.setCancelable(false);
//
//
//                    alert.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//
//                        }
//                    });
//
//                    AlertDialog alertDialog=alert.create();
//                    alertDialog.show();   ?? Aler

                                           String uname = "sarmadaslammemon@gmail.com";
                                           String upass = "12345";
                                           if (name.equalsIgnoreCase(uname) && pass.equalsIgnoreCase(upass)) {



                                               Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                                               Intent i = new Intent(MainActivity.this, DashBoard.class);
                                               startActivity(i);



                                           } else {





                                           }


                                       }


                                   }

                                   ;


                               });


        nextsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(MainActivity.this,Signup.class);
                startActivity(i);

            }
        });

    }


}