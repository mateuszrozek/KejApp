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
import android.widget.Toast;

import com.example.kejapp.R;
import com.example.kejapp.model.KejappUserTO;
import com.example.kejapp.model.PierTO;
import com.example.kejapp.utils.DeckListAdapter;
import com.example.kejapp.utils.GetDataService;
import com.example.kejapp.utils.RetrofitClientInstance;
import com.google.android.gms.common.util.Strings;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private static final String PREFERENCES_NAME = "myPreferences";
    private static final String PREFERENCES_TEXT_FIELD = "userEmail";
    private SharedPreferences preferences;
    private boolean confirmed;
    String inputName ;
    String inputSurname ;
    String inputEmail;
    String inputPassword;
    String inputPasswordRepeat;

    String inputBoatName;
    String inputMemQuantity;
    String inputBoatWidth;
    String inputBoatLength;
    String inputBoatSubmersion;

    private GetDataService serviceAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        preferences = getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
        confirmed = false;

        Button createNewUserButtton = findViewById(R.id.registerButton);

        serviceAuth = RetrofitClientInstance.getRetrofitInstanceForUserAuthorization().create(GetDataService.class);


        createNewUserButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchDataFromFormular();
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

                        registerUser(newUser);
                }
            }


        });


    }

    private void registerUser(KejappUserTO newUser) {

        Call<Void> call = serviceAuth.registerUser(newUser);
        call.enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
               int reponseCode = response.code();
               if (reponseCode == 201){
                    returnToMainMap();
                    Toast.makeText(getApplication(), "Zarejestrowano! Zaloguj się!", Toast.LENGTH_SHORT).show();
                } else if (reponseCode == 409){
                   Toast.makeText(getApplication(), "Taki użytkownik już istnieje!", Toast.LENGTH_SHORT).show();
               }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplication(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void fetchDataFromFormular(){
        inputName = ((EditText)findViewById(R.id.inputSurname)).getText().toString();
        inputSurname = ((EditText)findViewById(R.id.inputEmail)).getText().toString();
        inputEmail = ((EditText)findViewById(R.id.inputName)).getText().toString();
        inputPassword = ((EditText)findViewById(R.id.inputPassword)).getText().toString();
        inputPasswordRepeat = ((EditText)findViewById(R.id.inputRepeatPassword)).getText().toString();

        inputBoatName = ((EditText)findViewById(R.id.inputBoatName)).getText().toString();
        inputMemQuantity = ((EditText)findViewById(R.id.inputPeopleQuantity)).getText().toString();
        inputBoatWidth = ((EditText)findViewById(R.id.inputBoatWidth)).getText().toString();
        inputBoatLength = ((EditText)findViewById(R.id.inputBoatLength)).getText().toString();
        inputBoatSubmersion = ((EditText)findViewById(R.id.inputBoatDepth)).getText().toString();
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
