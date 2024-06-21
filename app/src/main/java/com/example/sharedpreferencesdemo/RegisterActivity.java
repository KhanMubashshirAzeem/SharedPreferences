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

public class RegisterActivity extends AppCompatActivity {

    EditText regName, regEmail, regPass, regPhno;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sessionManager = new SessionManager(getApplicationContext());

        regName = findViewById(R.id.reg_name);
        regEmail = findViewById(R.id.reg_email);
        regPass = findViewById(R.id.reg_password);
        regPhno = findViewById(R.id.reg_phone);


    }

    public void register(View view) {
        // Get all values
        String name = regName.getText().toString();
        String email = regEmail.getText().toString();
        String phone = regPhno.getText().toString();
        String password = regPass.getText().toString();

        sessionManager.createSession(name, email, phone);

        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);

    }

    public void gotoLogin(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}