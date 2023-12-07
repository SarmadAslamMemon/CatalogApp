package com.example.catalogapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    String url="https://roughlyandriodapp.000webhostapp.com/userSignup.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


          // Get Refrence of objects
        TextView txt=findViewById(R.id.nextLoginText);
        Button btnSignUp=findViewById(R.id.btnSignUp);
        EditText userSpName=findViewById(R.id.userSignupName);
        EditText userSpPass=findViewById(R.id.userSignupPass);
        EditText userSpConfirmPass=findViewById(R.id.userSignupConfirmPass);





        ProgressDialog progressDialog= new ProgressDialog(Signup.this);
        progressDialog.setTitle("Please wait");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);


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

                } else if(!pass.equalsIgnoreCase(cpass)){

                        userSpConfirmPass.setError("Password does`nt match");

                }
                else {

                        progressDialog.show();

                        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
                            progressDialog.dismiss();
                            Toast.makeText(Signup.this,"Successfully Sign Up", Toast.LENGTH_SHORT).show();
                            userSpName.setText("");
                            userSpPass.setText("");
                            userSpConfirmPass.setText("");

                            Intent i= new Intent(Signup.this,MainActivity.class);
                            startActivity(i);
                            finish();



                        }, error -> {
                            progressDialog.dismiss();
                            Toast.makeText(Signup.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();


                        }


                        ){
                            @Nullable
                            @Override
                            protected Map<String, String> getParams() {
                                Map <String,String> params= new HashMap<>();
                                params.put("userSignUpName",name);
                                params.put("userSignUpPass",pass);
                                return  params;
                            }
                        };

                        RequestQueue rQueue= Volley.newRequestQueue(Signup.this);
                        rQueue.add(request);


                    }





                        }






        });



        txt.setOnClickListener(v -> {
            Intent i= new Intent(Signup.this, MainActivity.class);
            startActivity(i);
            finish();
        });


    }




}

