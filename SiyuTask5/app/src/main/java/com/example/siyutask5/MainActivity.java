package com.example.siyutask5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.siyutask5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    // SharePreference
    SharedPreferences detailSharePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        init();
    }

    private void init() {
        // submit button click event
        mainBinding.btnSubmit.setOnClickListener(v -> {
            // validate whether the edit text fields' values are invalid
            Validation.ValidationInstance validation = Validation.MainActivityValidation(mainBinding);
            if (validation.isValid) {
                // set share preference
                detailSharePref = getSharedPreferences("details", MODE_PRIVATE);
                SharedPreferences.Editor detailEditor = detailSharePref.edit();
                detailEditor.putString("productCode", mainBinding.productCode.getText().toString());
                detailEditor.putString("productName", mainBinding.productName.getText().toString());
                detailEditor.putFloat("productPrice", Float.parseFloat(mainBinding.productPrice.getText().toString()));
                detailEditor.commit();
                // intent for jumping
                Intent detailsIntent = new Intent(this, DetailsActivity.class);
                startActivity(detailsIntent);
            } else {
                // if the input values are invalid, throw the dialog
                ErrorDialog errorDialog = new ErrorDialog("Error!", validation.message);
                errorDialog.show(getSupportFragmentManager(), "Error");
            }
        });
    }

}