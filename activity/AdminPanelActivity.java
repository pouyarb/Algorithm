package com.example.algorithm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.algorithm.R;
import com.example.algorithm.adapter.AdminRecyclerAdapter;
import com.example.algorithm.model.UnitsModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.orm.SugarContext;

import java.util.List;

public class AdminPanelActivity extends AppCompatActivity {

    FloatingActionButton addClassFAB;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        SugarContext.init(this);

        addClassFAB = findViewById(R.id.admin_add_class);
        recyclerView = findViewById(R.id.admin_recycler);

        addClassFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddClassActivity.class);
                startActivity(intent);
            }
        });

        List<UnitsModel> units = UnitsModel.listAll(UnitsModel.class);

        AdminRecyclerAdapter adapter = new AdminRecyclerAdapter(units);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
