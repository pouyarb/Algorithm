package com.example.algorithm;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class SetTimeDialog extends AppCompatDialogFragment {

    RadioGroup sections;
    int section;
    SetTimeOnClickListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_time_dialog, null);


        sections = view.findViewById(R.id.sections_radio_group);
        sections.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.first_section:
                        section = 1;
                        break;
                    case R.id.second_section:
                        section = 2;
                        break;
                    case R.id.third_section:
                        section = 3;
                        break;
                    case R.id.fourth_section:
                        section = 4;
                        break;
                    case R.id.fifth_section:
                        section = 5;
                        break;
                }
            }
        });

        builder.setView(view)
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        listener.applyTime(section);
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener= (SetTimeOnClickListener) context;
    }

    public interface SetTimeOnClickListener {
        public void applyTime(int time);
    }
}
