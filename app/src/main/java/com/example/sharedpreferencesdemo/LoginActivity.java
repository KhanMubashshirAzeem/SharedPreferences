package com.example.sharedpreferencesdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    // Declare EditText fields for email and password input
    EditText email, password;
    // Declare an instance of SessionManager
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display for the activity
        EdgeToEdge.enable(this);
        // Set the content view to the layout of the login activity
        setContentView(R.layout.activity_login);

        // Apply window insets listener to adjust the padding of the view to account for system bars (status bar, navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            // Get the insets for system bars
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // Set the padding of the view to match the insets of the system bars
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize the EditText fields
        email = findViewById(R.id.log_email);
        password = findViewById(R.id.log_password);

        // Initialize the SessionManager instance
        sessionManager = new SessionManager(getApplicationContext());
    }

    // Method to handle login action
    public void login(View view) {
        // Get the input email and password from the EditText fields
        String Email = email.getText().toString();
        String Password = password.getText().toString();

        // Note: Additional logic for validating and authenticating the email and password should be added here
    }

    // Method to navigate to the registration activity
    public void gotoRegister(View view) {
        // Create an Intent to start the RegisterActivity
        Intent intent = new Intent(this, RegisterActivity.class);
        // Start the RegisterActivity
        startActivity(intent);
        // Finish the current activity
        finish();
    }
}
