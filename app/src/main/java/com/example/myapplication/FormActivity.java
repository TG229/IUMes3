package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormActivity extends AppCompatActivity {

    EditText editName, editSurname, editDate;
    Button saveButton;
    Person person;
    TextView error;
    public static final String PERSON_EXTRA =
            "com.example.myapplication.Person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        error = findViewById(R.id.error);
        editName = findViewById(R.id.editName);
        editSurname = findViewById(R.id.editSurname);
        editDate = findViewById(R.id.editDate);
        saveButton = findViewById(R.id.saveButton);

        person = new Person();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkInput()) {
                    updatePerson();
                    Intent showResult = new Intent(FormActivity.this,
                            ResultActivity.class);
                    showResult.putExtra(PERSON_EXTRA, person);
                    startActivity(showResult);
                }
            }
        });

        editDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    showDialog();
                }
            }
        });


    }

    void doPositiveClick(Calendar date){
        this.person.setBirthDate(date);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        editDate.setText(format.format(date.getTime()));
    }

    void showDialog() {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "dialog");
    }

    boolean checkInput(){
        int errors = 0;
        if(editName.getText().toString().length() == 0){
            errors++;
            editName.setError("Si è verificato un errore");
        }
        if(editSurname.getText().toString().length() == 0){
            errors++;
            editSurname.setError("Si è verificato un errore");
        }
        if(editDate.getText().toString().length() == 0){
            errors++;
            editDate.setError("Si è verificato un errore");
        }

        switch(errors){
            case 0:
                error.setVisibility(View.GONE);
                break;
            case 1:
                error.setVisibility(View.VISIBLE);
                error.setText("Si è verificato un errore.");
                break;
            default:
                error.setVisibility(View.VISIBLE);
                error.setText("Si sono verificati " + errors + " errori.");
        }
        return errors == 0;
    }

    void updatePerson(){
        String name = this.editName.getText().toString();
        this.person.setName(name);
        String surname = this.editSurname.getText().toString();
        this.person.setSurname(surname);
        //String date = this.editDate.getText().toString();
    }
}