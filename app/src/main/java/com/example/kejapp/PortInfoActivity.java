package com.example.kejapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PortInfoActivity extends AppCompatActivity {

    Button portInfoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_port_info);

        portInfoButton = findViewById(R.id.portInfoButton);
        portInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PortInfoActivity.this, ChooseDeckActivity.class);
                intent.putExtra("object 1", "dupa");
                startActivity(intent);
            }
        });
    }
}
