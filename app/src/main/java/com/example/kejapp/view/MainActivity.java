package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.kejapp.R;
import com.example.kejapp.ui.viewmodel.MainFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.main_activity);

        final FloatingActionButton generalButton = (FloatingActionButton) findViewById(R.id.mainFloatingButton);
        final FloatingActionButton settingsButton = (FloatingActionButton) findViewById(R.id.settingsButton);
        final FloatingActionButton loginButton = (FloatingActionButton) findViewById(R.id.loginButton);

        settingsButton.hide();
        loginButton.hide();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("object 1", "dupa");
                startActivity(intent);
            }
        });


        generalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(settingsButton.getVisibility() == View.VISIBLE) {
                    settingsButton.hide();
                    loginButton.hide();
                } else {
                    settingsButton.show();
                    loginButton.show();
                }
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}
