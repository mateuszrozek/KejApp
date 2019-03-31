package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.kejapp.R;
import com.example.kejapp.ui.viewmodel.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}
