package com.example.siyutask5;

import com.example.siyutask5.databinding.ActivityMainBinding;

public class Validation {

    public static ValidationInstance MainActivityValidation(ActivityMainBinding mainBinding) {
        ValidationInstance validationInstance = new ValidationInstance();
        String productCode = String.valueOf(mainBinding.productCode.getText());
        String productName = String.valueOf(mainBinding.productName.getText());
        String productPrice = String.valueOf(mainBinding.productPrice.getText());
        // back to initial states
        mainBinding.productCodeLayout.setError(null);
        mainBinding.productNameLayout.setError(null);
        mainBinding.productPrice.setError(null);

        // product code
        if (productCode.trim().equals("")) {
            mainBinding.productCodeLayout.setError("Product Code should not be empty");
            validationInstance.message = "Product Code should not be empty";
            return validationInstance;
        }
        // product name
        if (productName.trim().equals("")) {
            mainBinding.productNameLayout.setError("Product Name should not be empty");
            validationInstance.message = "Product Name should not be empty";
            return validationInstance;
        }
        // product price
        try {
            Double.parseDouble(productPrice);
        } catch (Exception e) {
            mainBinding.productPrice.setError("Product Price should be number");
            validationInstance.message = "Product Price should be number";
            return validationInstance;
        }

        validationInstance.isValid = true;
        return validationInstance;
    }

    public static class ValidationInstance {
        public boolean isValid = false;
        public String message = "";
    }
}
