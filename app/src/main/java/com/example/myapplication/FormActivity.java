package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    EditText editName, editSurname, editDate;
    Button saveButton;
    Person person;
    public static final String PERSON_EXTRA =
            "com.example.myapplication.Person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        editName = findViewById(R.id.editName);
        editSurname = findViewById(R.id.editSurname);
        editDate = findViewById(R.id.editDate);
        saveButton = findViewById(R.id.saveButton);

        person = new Person();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePerson();
                Intent showResult = new Intent(FormActivity.this,
                        ResultActivity.class);
                showResult.putExtra(PERSON_EXTRA, person);
                startActivity(showResult);
            }
        });
    }

    void updatePerson(){
        String name = this.editName.getText().toString();
        this.person.setName(name);
        String surname = this.editSurname.getText().toString();
        this.person.setSurname(surname);
        String date = this.editDate.getText().toString();
        this.person.setBirthDate(date);
    }
}