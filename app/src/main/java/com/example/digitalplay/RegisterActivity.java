package com.example.digitalplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {

    View contextView;

    Button btnSave;

    EditText txtName, txtEmail, txtPass, txtPassConfirmation;

    Spinner spinnerGender;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bindStuff();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validateEverything();
                //TODO: Implement register
            }
        });

    }

    private boolean validateEverything() {
        if(!validatePass()){
            Snackbar.make(contextView, R.string.checkPass, Snackbar.LENGTH_LONG).show();
            return false;
        }else{
            if(!validateFields()){
                Snackbar.make(contextView, R.string.populateAllFields, Snackbar.LENGTH_LONG).show();
                return false;
            }
        }
        //TODO: Remove next line
        Snackbar.make(contextView, R.string.everythingOK, Snackbar.LENGTH_LONG).show();
        return true;
    }

    private boolean validatePass() {
        String stringPass, stringConfirmationPass;
        stringPass = txtPass.getText().toString();
        stringConfirmationPass = txtPassConfirmation.getText().toString();

        return stringPass.equals(stringConfirmationPass);
    }

    private boolean validateFields() {
        return !txtName.getText().toString().isEmpty()
                && !txtEmail.getText().toString().isEmpty()
                && !txtPass.getText().toString().isEmpty()
                && !txtPassConfirmation.getText().toString().isEmpty();
    }

    private void bindStuff() {

        contextView = findViewById(R.id.mainLayoutId);
        
        btnSave = findViewById(R.id.btnSave);

        txtEmail = findViewById(R.id.email);
        txtName = findViewById(R.id.name);
        txtPass = findViewById(R.id.pass);
        txtPassConfirmation = findViewById(R.id.passConfirmation);

        spinnerGender = findViewById(R.id.gender);
    }
}
