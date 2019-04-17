package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kejapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LoginActivity extends AppCompatActivity {

    private static final String PREFERENCES_NAME = "myPreferences";
    private static final String PREFERENCES_TEXT_FIELD = "userEmail";
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
        setContentView(R.layout.activity_login);

        final TextView registerText = findViewById(R.id.registerText);
        final Button login = findViewById(R.id.loginButton);
        final EditText emailText = findViewById(R.id.loginEmail);
        final EditText passwordText = findViewById(R.id.loginPassword);

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                intent.putExtra("object 1", "dupa");
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = emailText.getText().toString();
                String password = passwordText.getText().toString();
                //wyslanie requesta sprawdzajacego uzytkownika

                if(password.equals("admin")) { //sprawdzenie czy uzytkownik zalogowal sie poprawnie
                    saveToSharedPreferences(mail);
                    returnToMainMap();
                }
                else{
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(LoginActivity.this);
                    builder1.setMessage("Niepoprawny email lub hasło.");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }
        });

    }

    public void saveToSharedPreferences(String mail){
        SharedPreferences.Editor preferencesEditor = preferences.edit();
        preferencesEditor.putString(PREFERENCES_TEXT_FIELD, mail);
        preferencesEditor.commit();
    }
    public void returnToMainMap() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
