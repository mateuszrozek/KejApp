package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
import com.example.kejapp.model.LoginUserRequest;
import com.example.kejapp.utils.GetDataService;
import com.example.kejapp.utils.RetrofitClientInstance;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LoginActivity extends AppCompatActivity {

    private static final String PREFERENCES_NAME = "myPreferences";
    private static final String PREFERENCES_TEXT_FIELD = "userToken";
    private SharedPreferences preferences;
    private GetDataService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
        setContentView(R.layout.activity_login);

        service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

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

                autenticateUser(mail, password);
            }
        });

    }

    public void saveToSharedPreferences(String token){
        SharedPreferences.Editor preferencesEditor = preferences.edit();
        preferencesEditor.putString(PREFERENCES_TEXT_FIELD, token);
        preferencesEditor.commit();
    }
    public void returnToMainMap() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }


    public void autenticateUser(String mail, String password){

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUsername(mail);
        loginUserRequest.setPassword(password);

        Call<Void> call = service.login(loginUserRequest);
        call.enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                int responseCode = response.code();
                if (responseCode == 200){
                    try{
                        String token = response.headers().get("Authorization").replace("Bearer ", "");
                        saveToSharedPreferences(token);
                        returnToMainMap();
                        Toast.makeText(getApplication(), "Zalogowano poprawnie!", Toast.LENGTH_LONG).show();
                    } catch (Exception ex){

                    }
                }else{
                    showAlertWindowAfterLoginFail();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplication(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }



    private void showAlertWindowAfterLoginFail(){
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
