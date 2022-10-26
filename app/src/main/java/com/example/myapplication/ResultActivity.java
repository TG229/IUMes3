package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class ResultActivity extends AppCompatActivity {
    Person person;
    TextView resultName, resultSurname, resultBirthDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultName = findViewById(R.id.resultName);
        resultSurname = findViewById(R.id.resultSurname);
        resultBirthDate = findViewById(R.id.resultDate);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(
                FormActivity.PERSON_EXTRA);

        if(obj instanceof Person){
            person = (Person) obj;
        }
        else{
            person = new Person();
        }
        updateTextViews();
    }

    void updateTextViews(){
        resultName.setText(person.getName());
        resultSurname.setText(person.getSurname());
        resultBirthDate.setText(person.getBirthDate());
    }
}