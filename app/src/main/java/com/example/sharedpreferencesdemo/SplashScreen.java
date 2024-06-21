package com.example.sharedpreferencesdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display for the activity
        EdgeToEdge.enable(this);
        // Set the content view to the layout of the splash screen
        setContentView(R.layout.activity_splash_screen);

        // Apply window insets listener to adjust the padding of the view to account for system bars (status bar, navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            // Get the insets for system bars
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // Set the padding of the view to match the insets of the system bars
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Delay the execution of a runnable for 2000 milliseconds (2 seconds)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Call the session manager function after the delay
                sessionManagerFun();
                // Finish the splash screen activity
                finish();
            }
        }, 2000); // Delay in milliseconds
    }

    // Method to manage session checking and navigation
    public void sessionManagerFun(){
        // Create an instance of SessionManager with the application context
        SessionManager sessionManager = new SessionManager(getApplicationContext());
        // Check if a session exists
        boolean b = sessionManager.checkSession();

        // If a session exists, navigate to ProfileActivity
        if (b) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
        // If no session exists, navigate to LoginActivity
        else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

}
