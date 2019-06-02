package com.unicen.garbage.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.unicen.garbage.R;
import com.unicen.garbage.domain.RecyclingRepository;
import com.unicen.garbage.domain.entities.Recycling;

import java.util.Calendar;

public class ActualFragment extends Fragment {

    private HorizontalNumberPicker bottlePicker;
    private HorizontalNumberPicker tetrabrikPicker;
    private HorizontalNumberPicker glassPicker;
    private HorizontalNumberPicker paperboardPicker;
    private HorizontalNumberPicker cansPicker;

    public ActualFragment() {
    }

    public static ActualFragment newInstance() {
        return new ActualFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override public void onStop() {
        super.onStop();
        Context context = getContext();
        if (context != null) {
            RecyclingRepository.saveRecyclingInPreferences(getContext(), new Recycling(bottlePicker.getValue(), tetrabrikPicker.getValue(),
                    glassPicker.getValue(), paperboardPicker.getValue(), cansPicker.getValue(), Calendar.getInstance().getTime().toString()));
        }
    }

    @Override public void onStart() {
        super.onStart();
        Context context = getContext();
        if (context != null) {
            Recycling savedRecycling = RecyclingRepository.getRecyclingFromPreferences(context);
            if (savedRecycling != null) {
                bottlePicker.setValue(savedRecycling.getBottles());
                tetrabrikPicker.setValue(savedRecycling.getTetrabriks());
                glassPicker.setValue(savedRecycling.getGlass());
                paperboardPicker.setValue(savedRecycling.getPaperboard());
                cansPicker.setValue(savedRecycling.getCans());
            }
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actual, container, false);
        bottlePicker = view.findViewById(R.id.actual_bottles);
        tetrabrikPicker = view.findViewById(R.id.actual_tetrabriks);
        glassPicker = view.findViewById(R.id.actual_glass);
        paperboardPicker = view.findViewById(R.id.actual_paperboard);
        cansPicker = view.findViewById(R.id.actual_cans);
        Button submitButton = view.findViewById(R.id.actual_submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                RecyclingRepository.submitRecyclingToServer(new Recycling(bottlePicker.getValue(), tetrabrikPicker.getValue(),
                        glassPicker.getValue(), paperboardPicker.getValue(), cansPicker.getValue(),
                        Calendar.getInstance().getTime().toString()));
            }
        });
        return view;
    }
}
