package com.example.sharedpreferencesdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SessionManager {
    // Context to access application-specific resources and classes
    Context context;
    // SharedPreferences instance to store and retrieve key-value pairs
    SharedPreferences sp;
    // SharedPreferences.Editor instance to make changes to the SharedPreferences
    SharedPreferences.Editor editor;
    // Name of the SharedPreferences file
    private final String PREF_FILE_NAME = "shopping";
    // Mode for the SharedPreferences file, PRIVATE_MODE means the file is accessible only to the calling application
    private final int PRIVATE_MODE = 0;
    // Keys for storing session details
    private final String KEY_NAME = "key_session_name";
    private final String KEY_EMAIL = "key_session_email";
    private final String KEY_PHNO = "key_session_phno";
    private final String KEY_IF_LOGGED_IN = "key_session_if_logged_in";

    // Constructor that takes a Context object as a parameter
    public SessionManager(Context context) {
        // Assigning the passed context to the context field of this class
        this.context = context;
        // Initializing the SharedPreferences with the given file name and mode
        sp = context.getSharedPreferences(PREF_FILE_NAME, PRIVATE_MODE);
        // Initializing the SharedPreferences.Editor to edit the SharedPreferences
        editor = sp.edit();
    }

    // Method to check if a session exists
    public boolean checkSession() {
        // If the SharedPreferences contains the KEY_IF_LOGGED_IN key, return true, otherwise return false
        if (sp.contains(KEY_IF_LOGGED_IN)) {
            return true;
        } else {
            return false;
        }
    }

    // Method to create a session with the given details
    public void createSession(String name, String email, String phno) {
        // Storing the name, email, and phone number in the SharedPreferences
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PHNO, phno);
        // Storing a boolean value to indicate the user is logged in
        editor.putBoolean(KEY_IF_LOGGED_IN, true);
        // Committing the changes
        editor.commit();
    }

    // Method to get session details for a given key
    public String getSessionDetails(String key) {
        // Retrieving the value associated with the given key from the SharedPreferences
        String value = sp.getString(key, null);
        return value;
    }

    // Method to log out of the session
    public void logoutSession() {
        // Clearing all the data in the SharedPreferences
        editor.clear();
        // Committing the changes
        editor.commit();
        // Creating an intent to start the LoginActivity
        Intent intent = new Intent(context, LoginActivity.class);
        // Starting the LoginActivity
        context.startActivity(intent);
    }
}
