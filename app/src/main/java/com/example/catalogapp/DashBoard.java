package com.example.catalogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class DashBoard extends AppCompatActivity {







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
    }

    public void addCategoryCard(View view) {
        Intent i= new Intent(DashBoard.this, addCategoryActivity.class);
        startActivity(i);
    }

    public void showCategoryCard(View view) {
        Intent i= new Intent(DashBoard.this, showCategoryActivity.class);
        startActivity(i);
    }

    public void addProductCard(View view) {
        Intent i= new Intent(DashBoard.this, addProductActivity.class);
        startActivity(i);
    }

    public void showProductCard(View view) {
        Intent i= new Intent(DashBoard.this, showProductActivity.class);
        startActivity(i);
    }
}