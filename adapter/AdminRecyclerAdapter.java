package com.example.algorithm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.algorithm.R;
import com.example.algorithm.model.UnitsModel;

import java.util.List;

public class AdminRecyclerAdapter extends RecyclerView.Adapter<AdminRecyclerAdapter.MyViewHolder> {

    private List<UnitsModel> units;

    public AdminRecyclerAdapter(List<UnitsModel> units) {
        this.units = units;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.admin_recycler_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        UnitsModel unit = units.get(position);
        holder.unitCode.setText(String.valueOf(unit.getUnitCode()));
        holder.unitName.setText(unit.getUnitName());
        holder.section2.setText(String.valueOf(unit.getSection2()));
        holder.section1.setText(String.valueOf(unit.getSection1()));

    }

    @Override
    public int getItemCount() {
        return units.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView unitName, unitCode, section1, section2;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            unitName = itemView.findViewById(R.id.unit_name);
            unitCode = itemView.findViewById(R.id.unit_code);
            section1 = itemView.findViewById(R.id.admin_recycler_section1);
            section2 = itemView.findViewById(R.id.admin_recycler_section2);
        }
    }
}
