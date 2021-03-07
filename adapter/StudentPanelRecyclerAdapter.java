package com.example.algorithm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.algorithm.R;
import com.example.algorithm.model.UnitsModel;

import java.util.ArrayList;
import java.util.List;

public class StudentPanelRecyclerAdapter extends RecyclerView.Adapter<StudentPanelRecyclerAdapter.MyViewHolder> {

    private List<String> units;

    private List<String> selectedUnits = new ArrayList<>();

    public StudentPanelRecyclerAdapter(List<String> units) {
        this.units = units;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.student_panel_recycler_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String unit = units.get(position);
        holder.unitCheck.setText(unit);
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return units.size();
    }

    public List<String> getSelectedUnits() {
        return selectedUnits;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        CheckBox unitCheck;
        int position;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            unitCheck = itemView.findViewById(R.id.student_panel_unit_check);

            unitCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked)
                        selectedUnits.add(units.get(position));
                    else
                        selectedUnits.remove(units.get(position));
                }
            });
        }

    }
}
