package com.example.algorithm.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.algorithm.Algorithm;
import com.example.algorithm.R;
import com.example.algorithm.adapter.AdminRecyclerAdapter;
import com.example.algorithm.adapter.StudentPanelRecyclerAdapter;
import com.example.algorithm.model.UnitsModel;
import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

public class StudentPanelActivity extends AppCompatActivity {

    RecyclerView recyclerView, takenRecycler;
    Button okBtn;
    StudentPanelRecyclerAdapter adapter;
    List<UnitsModel> selectedUnits;
    TextView chooseUnitTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_panel);

        SugarContext.init(this);

        recyclerView = findViewById(R.id.student_panel_recycler);
        okBtn = findViewById(R.id.student_panel_ok_btn);
        takenRecycler = findViewById(R.id.student_panel_taken_recycler);
        chooseUnitTv=findViewById(R.id.student_panel_choose_tv);
        selectedUnits = new ArrayList<>();

        final List<UnitsModel> unitsTmp = UnitsModel.listAll(UnitsModel.class);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> selectedUnitsString = adapter.getSelectedUnits();

                for (UnitsModel unit : unitsTmp) {
                    for (String unitString : selectedUnitsString) {
                        if (unit.getUnitName().equals(unitString))
                            selectedUnits.add(unit);
                    }
                }

                List<UnitsModel> takenUnits = new Algorithm().generateBestPlan(selectedUnits);
                AdminRecyclerAdapter adapter = new AdminRecyclerAdapter(takenUnits);
                takenRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                takenRecycler.setAdapter(adapter);
                takenRecycler.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                chooseUnitTv.setText("برنامه پیشنهادی:");
            }
        });


        List<String> units = new ArrayList<>();
        for (UnitsModel unit : unitsTmp) {
            if (!units.contains(unit.getUnitName()))
                units.add(unit.getUnitName());
        }

        adapter = new StudentPanelRecyclerAdapter(units);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
