package com.example.catalogapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
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


public class addCategoryActivity extends AppCompatActivity {


    String url="https://roughlyandriodapp.000webhostapp.com/connect.php";
    EditText catagoryname;
    Button btnAddCat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
         catagoryname=findViewById(R.id.addCategoryName);
         btnAddCat=findViewById(R.id.addCategoryBtn);



        ProgressDialog progressDialog= new ProgressDialog(addCategoryActivity.this);
        progressDialog.setTitle("Please wait");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);


        btnAddCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  nametxt= catagoryname.getText().toString();

                progressDialog.show();
                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();


                        Toast.makeText(addCategoryActivity.this,nametxt+"added ", Toast.LENGTH_SHORT).show();
                        catagoryname.setText(" ");

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                         progressDialog.dismiss();
                        Toast.makeText(addCategoryActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();

                    }
                }


                ){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                      Map <String,String> params= new HashMap<>();
                      params.put("cat_name",nametxt);
                      return  params;
                    }
                };

                RequestQueue rQueue= Volley.newRequestQueue(addCategoryActivity.this);
                rQueue.add(request);



            }
        });







    }
}