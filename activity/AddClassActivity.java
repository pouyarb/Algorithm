package com.example.algorithm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.algorithm.R;
import com.example.algorithm.SetTimeDialog;
import com.example.algorithm.model.UnitsModel;

public class AddClassActivity extends AppCompatActivity implements SetTimeDialog.SetTimeOnClickListener {

    EditText unitNameInput, unitCodeInput;
    CheckBox saturday, sunday, monday, tuesday, thursday;
    int section1 = 0, section2 = 0;
    String sectionDay, unitName;
    int sectionTime, unitCode, sectionCode;
    Button setButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        unitCodeInput = findViewById(R.id.add_class_code);
        unitNameInput = findViewById(R.id.add_class_name);
        saturday = findViewById(R.id.saturday_check);
        sunday = findViewById(R.id.sunday_check);
        monday = findViewById(R.id.monday_check);
        tuesday = findViewById(R.id.tuesday_check);
        thursday = findViewById(R.id.thursday_check);
        setButton = findViewById(R.id.add_class_ok_btn);

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                unitName = unitNameInput.getText().toString();
                unitCode = Integer.parseInt(unitCodeInput.getText().toString());

                UnitsModel unit = new UnitsModel(unitName, unitCode, section1, section2);
                unit.save();

                Toast.makeText(AddClassActivity.this, "درس با موفقیت اضافه شد", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), AdminPanelActivity.class);
                startActivity(intent);
            }
        });

        saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (saturday.isChecked()) {

                    sectionDay = "saturday";
                    if (section1 == 0)
                        section1 = 10;
                    else if (section2 == 0)
                        section2 = 10;
                    openSetTimeDialog();
                } else {
                    if (section1 / 10 == 1)
                        section1 = 0;
                    if (section2 / 10 == 1)
                        section2 = 0;
                }
            }
        });

        sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sunday.isChecked()) {

                    sectionDay = "sunday";
                    if (section1 == 0)
                        section1 = 20;
                    else if (section2 == 0)
                        section2 = 20;
                    openSetTimeDialog();
                } else {
                    if (section1 / 10 == 2)
                        section1 = 0;
                    if (section2 / 10 == 2)
                        section2 = 0;
                }
            }
        });

        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (monday.isChecked()) {

                    sectionDay = "monday";
                    if (section1 == 0)
                        section1 = 30;
                    else if (section2 == 0)
                        section2 = 30;
                    openSetTimeDialog();
                } else {
                    if (section1 / 10 == 3)
                        section1 = 0;
                    if (section2 / 10 == 3)
                        section2 = 0;
                }
            }
        });

        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tuesday.isChecked()) {

                    sectionDay = "tuesday";
                    if (section1 == 0)
                        section1 = 40;
                    else if (section2 == 0)
                        section2 = 40;
                    openSetTimeDialog();
                } else {
                    if (section1 / 10 == 4)
                        section1 = 0;
                    if (section2 / 10 == 4)
                        section2 = 0;
                }
            }
        });

        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thursday.isChecked()) {

                    sectionDay = "thursday";
                    if (section1 == 0)
                        section1 = 50;
                    else if (section2 == 0)
                        section2 = 50;
                    openSetTimeDialog();
                } else {
                    if (section1 / 10 == 5)
                        section1 = 0;
                    if (section2 / 10 == 5)
                        section2 = 0;
                }
            }
        });

    }

    public void openSetTimeDialog() {
        SetTimeDialog dialog = new SetTimeDialog();
        dialog.show(getSupportFragmentManager(), "set time");
    }

    @Override
    public void applyTime(int time) {
        sectionTime = time;
        sectionCode += time;

        if (section1 % 10 == 0)
            section1 += time;
        else if (section2 % 10 == 0)
            section2 += time;
    }
}
