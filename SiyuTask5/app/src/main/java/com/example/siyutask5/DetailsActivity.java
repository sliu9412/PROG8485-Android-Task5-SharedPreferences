package com.example.siyutask5;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.siyutask5.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding detailsBinding;
    SharedPreferences detailSharePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsBinding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(detailsBinding.getRoot());
        retrieveSharePref();
    }

    @SuppressLint("SetTextI18n")
    private void retrieveSharePref() {
        detailSharePref = getSharedPreferences("details", MODE_PRIVATE);
        detailsBinding.productCodeText.setText(
                "Code: " + detailSharePref.getString("productCode", "")
        );
        detailsBinding.productNameText.setText(
                "Name: " + detailSharePref.getString("productName", "")
        );
        detailsBinding.productPriceText.setText(
                "Price: $" + detailSharePref.getFloat("productPrice", 0)
        );
    }
}