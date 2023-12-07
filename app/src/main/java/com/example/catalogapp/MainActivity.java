package com.example.catalogapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView nextsignup;
    Button btnLogin,btnRetry;
    EditText username,userpassword;
    LinearLayout lnNoWifi,lnLogin;
    String url="https://roughlyandriodapp.000webhostapp.com/userLogin.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lnNoWifi = findViewById(R.id.nowifilayout);
        lnLogin = findViewById(R.id.LoginLayout);
        nextsignup = findViewById(R.id.nextsignup);
        btnLogin = findViewById(R.id.btnlogin);
        btnRetry = findViewById(R.id.retryBtn);
        username = findViewById(R.id.userloginname);
        userpassword = findViewById(R.id.userloginpass);


        if (!isConnected()) {

            lnLogin.setVisibility(View.INVISIBLE);
            lnNoWifi.setVisibility(View.VISIBLE);

        }

        btnRetry.setOnClickListener(v -> {
            if (isConnected()) {
                lnNoWifi.setVisibility(View.GONE);
                lnLogin.setVisibility(View.VISIBLE);
            }


        });


        btnLogin.setOnClickListener(view -> {

            String name = username.getText().toString();
            String pass = userpassword.getText().toString();

            if (name.isEmpty()) {
                username.requestFocus();
                username.setError("Username required");


            } else if (pass.isEmpty()) {
                userpassword.requestFocus();
                userpassword.setError("Username required");

            } else if (pass.length() >= 12) {
                    userpassword.requestFocus();
                    userpassword.setError("Invalid Password Length ");
                } else if (name.contains("* $ # ( ) "))
                {
                    username.requestFocus();
                    username.setError("Invalid Character");
                }
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
//                    alertDialog.show();   ?? Ale
            else
        {


            ProgressDialog progressDialog= new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Please wait");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();

                StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
                progressDialog.dismiss();

                if(response.equalsIgnoreCase("success"))
                {
                    Intent i= new Intent(MainActivity.this,DashBoard.class);
                    startActivity(i);
                }else
                {
                    Toast.makeText(MainActivity.this,"Invalid Username or Password" , Toast.LENGTH_SHORT).show();
                }

            }, error -> {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();

            }


            )
                {
                @Nullable
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("userLoginName", name);
                    params.put("userLoginPass", pass);
                    return params;
                }
            };

            RequestQueue rQueue = Volley.newRequestQueue(MainActivity.this);
            rQueue.add(request);


        }


        });


        nextsignup.setOnClickListener(v -> {
            Intent i=new Intent(MainActivity.this,Signup.class);
            startActivity(i);
            finish();

        });


}
    private boolean isConnected() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(this.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo()!=null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}