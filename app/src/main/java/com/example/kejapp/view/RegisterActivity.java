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

import com.example.kejapp.R;
import com.example.kejapp.model.KejappUserTO;
import com.google.android.gms.common.util.Strings;

public class RegisterActivity extends AppCompatActivity {

    private static final String PREFERENCES_NAME = "myPreferences";
    private static final String PREFERENCES_TEXT_FIELD = "userEmail";
    private SharedPreferences preferences;
    private boolean confirmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        preferences = getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
        confirmed = false;

        Button createNewUserButtton = findViewById(R.id.registerButton);

        final String inputName = ((EditText)findViewById(R.id.inputSurname)).getText().toString();
        final String inputSurname = ((EditText)findViewById(R.id.inputEmail)).getText().toString();
        final String inputEmail = ((EditText)findViewById(R.id.inputName)).getText().toString();
        final String inputPassword = ((EditText)findViewById(R.id.inputPassword)).getText().toString();
        final String inputPasswordRepeat = ((EditText)findViewById(R.id.inputRepeatPassword)).getText().toString();

        final String inputBoatName = ((EditText)findViewById(R.id.inputBoatName)).getText().toString();
        final String inputMemQuantity = ((EditText)findViewById(R.id.inputPeopleQuantity)).getText().toString();
        final String inputBoatWidth = ((EditText)findViewById(R.id.inputBoatWidth)).getText().toString();
        final String inputBoatLength = ((EditText)findViewById(R.id.inputBoatLength)).getText().toString();
        final String inputBoatSubmersion = ((EditText)findViewById(R.id.inputBoatDepth)).getText().toString();


        createNewUserButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!confirmed && (Strings.isEmptyOrWhitespace(inputBoatName) || Strings.isEmptyOrWhitespace(inputMemQuantity) ||
                       Strings.isEmptyOrWhitespace(inputBoatWidth) || Strings.isEmptyOrWhitespace(inputBoatLength) ||
                        Strings.isEmptyOrWhitespace(inputBoatSubmersion))){
                    showWarning();

               } else {

                        KejappUserTO newUser = new KejappUserTO();
                        newUser.setFirstName(inputName);
                        newUser.setLastName(inputSurname);
                        newUser.setUsername(inputEmail);
                        newUser.setPassword(inputPassword);

                        newUser.setVesselName(inputBoatName);
                        try {
                            newUser.setCrewmenQuantity(new Integer(inputMemQuantity));
                            newUser.setVesselWidth(new Double(inputBoatWidth));
                            newUser.setVesselLength(new Double(inputBoatLength));
                            newUser.setVesselSubmersion(new Double(inputBoatSubmersion));
                        }catch (NumberFormatException ex){

                        }


                        saveToSharedPreferences();
                        returnToMainMap();
                }
            }


        });


    }


    public void returnToMainMap() {


        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        intent.putExtra("object 1","dupa");

        startActivity(intent);
    }


    public void saveToSharedPreferences(){
        SharedPreferences.Editor preferencesEditor = preferences.edit();
        String editTextData = "bartek1wasik@gmail.com";
        preferencesEditor.putString(PREFERENCES_TEXT_FIELD, editTextData);
        preferencesEditor.commit();
    }

    public void showWarning(){

        AlertDialog.Builder builder1 = new AlertDialog.Builder(RegisterActivity.this);
        builder1.setMessage("Niepodając pełnych danych dotyczących łodzi, nie będziesz otrzymywał spersonalizowanych wynikow rezerwacji!");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        confirmed = true;
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }


}
