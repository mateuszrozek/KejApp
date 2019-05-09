package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kejapp.R;

public class LogoutActivity extends AppCompatActivity {

    private static final String PREFERENCES_NAME = "myPreferences";
    private static final String PREFERENCES_TEXT_FIELD = "userToken";
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
        setContentView(R.layout.activity_logout);

        Button logOutButton = findViewById(R.id.logoutButton);

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeTokenFromSharedPreferences();
                returnToMainMap();
            }
        });
    }


    public void removeTokenFromSharedPreferences(){
            SharedPreferences.Editor preferencesEditor = preferences.edit();
            preferencesEditor.remove(PREFERENCES_TEXT_FIELD);
            preferencesEditor.commit();

    }

    public void returnToMainMap() {


        Intent intent = new Intent(LogoutActivity.this, MainActivity.class);
        intent.putExtra("object 1","dupa");

        startActivity(intent);
    }
}
