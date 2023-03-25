package com.example.viikko9;

import static com.example.viikko9.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText txtF;
    private EditText txtL;
    private EditText txtEA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        txtF = findViewById(R.id.textFirstname);
        txtL = findViewById(R.id.textLastname);
        txtEA = findViewById(R.id.inputEmail);

    }
    public void addUser(View view) {
        String firstName = String.valueOf(txtF.getText());
        String lastName = String.valueOf(txtL.getText());
        String emailAddress = String.valueOf(txtEA.getText());
        String degreeProgram = null;


        RadioGroup rgDegreeProgram = findViewById(id.degreeProgram);
        switch (rgDegreeProgram.getCheckedRadioButtonId()) {
            case R.id.radioButtonLate:
                degreeProgram = "Laskennallinen tekniikka";
                break;
            case id.radioButtonTuta:
                degreeProgram = "Tuotantotalous";
                break;
            case id.radioButtonTite:
                degreeProgram = "Tietotekniikka";
                break;
        }
        User newUser = new User(firstName, lastName, emailAddress, degreeProgram);
        UserStorage.getInstance().addUser(newUser);
    }
    public void switchToListUsers(View view) {
        Intent intent = new Intent(this, ListUsersActivity.class);
        startActivity(intent);
    }
}