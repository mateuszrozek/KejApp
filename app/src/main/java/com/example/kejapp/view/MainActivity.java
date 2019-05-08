package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.kejapp.R;
import com.example.kejapp.ReservationsActivity;
import com.example.kejapp.ui.viewmodel.MainFragment;
import com.google.android.gms.common.util.Strings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private static final String PREFERENCES_NAME = "myPreferences";
    private static final String PREFERENCES_TEXT_FIELD = "userEmail";
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.main_activity);

        preferences = getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
        final FloatingActionButton generalButton = findViewById(R.id.mainFloatingButton);
        final FloatingActionButton settingsButton = findViewById(R.id.settingsButton);
        final FloatingActionButton loginButton = findViewById(R.id.loginButton);
        final FloatingActionButton reservationsButton = findViewById(R.id.reservationsButton);

        settingsButton.hide();
        loginButton.hide();
        reservationsButton.hide();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tokenFromSharedPreferences = preferences.getString(PREFERENCES_TEXT_FIELD, "");
                if(Strings.isEmptyOrWhitespace(tokenFromSharedPreferences)){
                    proceedToLoginLogoutActivity(LoginActivity.class);
                } else {
                    proceedToLoginLogoutActivity(LogoutActivity.class);
                }
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textFromPreferences = preferences.getString(PREFERENCES_TEXT_FIELD, "");
                Toast.makeText(getApplicationContext(), textFromPreferences, Toast.LENGTH_SHORT).show();
            }
        });

        reservationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tokenFromSharedPreferences = preferences.getString(PREFERENCES_TEXT_FIELD, "");
                if(Strings.isEmptyOrWhitespace(tokenFromSharedPreferences)){
                    Toast.makeText(getApplicationContext(), "To see reservations login first", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), ReservationsActivity.class);
                    /*TODO
                    * what to pass here?*/
                    startActivity(intent);
                }
            }
        });


        generalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(settingsButton.getVisibility() == View.VISIBLE) {
                    settingsButton.hide();
                    loginButton.hide();
                    reservationsButton.hide();
                } else {
                    settingsButton.show();
                    loginButton.show();
                    reservationsButton.show();
                }
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }

    public void proceedToLoginLogoutActivity(Class activityClass){
        Intent intent = new Intent(MainActivity.this, activityClass);
        startActivity(intent);
    }
}
