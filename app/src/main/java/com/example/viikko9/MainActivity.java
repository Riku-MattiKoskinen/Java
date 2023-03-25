package com.example.viikko9;

import static com.example.viikko9.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText txtF;
    private EditText txtL;
    private EditText txtEA;
    private Spinner imageSpinner;
    private List<ImageItem> imageItemList;
    private int selectedImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        txtF = findViewById(R.id.textFirstname);
        txtL = findViewById(R.id.textLastname);
        txtEA = findViewById(R.id.inputEmail);

        imageSpinner = findViewById(R.id.image_spinner);
        initImageItemList();
        ImageSpinnerAdapter adapter = new ImageSpinnerAdapter(this, R.layout.spinner_view, imageItemList);
        imageSpinner.setAdapter(adapter);
        imageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                ImageItem selectedItem = (ImageItem) adapterView.getItemAtPosition(position);
                selectedImage = selectedItem.getImageResource();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

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
        User newUser = new User(firstName, lastName, emailAddress, degreeProgram, selectedImage);
        UserStorage.getInstance().addUser(newUser);
    }
    public void switchToListUsers(View view) {
        Intent intent = new Intent(this, ListUsersActivity.class);
        startActivity(intent);
    }
    private void initImageItemList() {
        imageItemList = new ArrayList<>();
        imageItemList.add(new ImageItem(drawable.happy, "Happy"));
        imageItemList.add(new ImageItem(drawable.neutral, "Neutral"));
        imageItemList.add(new ImageItem(drawable.sad, "Sad"));
    }

}