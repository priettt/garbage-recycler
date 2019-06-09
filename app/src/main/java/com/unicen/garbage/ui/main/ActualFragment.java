package com.unicen.garbage.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.unicen.garbage.R;
import com.unicen.garbage.domain.RecyclingRepository;
import com.unicen.garbage.domain.entities.Recycling;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                    glassPicker.getValue(), paperboardPicker.getValue(), cansPicker.getValue(), null,
                    null));
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
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Call<Recycling> recyclingCall = RecyclingRepository.submitRecyclingToServer(new Recycling(bottlePicker.getValue(),
                        tetrabrikPicker.getValue(), glassPicker.getValue(), paperboardPicker.getValue(), cansPicker.getValue(),
                        null, format.format(new Date())), getContext());
                recyclingCall.enqueue(new Callback<Recycling>() {
                    @Override public void onResponse(Call<Recycling> call, Response<Recycling> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            bottlePicker.setValue(0);
                            tetrabrikPicker.setValue(0);
                            glassPicker.setValue(0);
                            paperboardPicker.setValue(0);
                            cansPicker.setValue(0);
                        } else {
                            showError();
                        }
                    }

                    @Override public void onFailure(Call<Recycling> call, Throwable t) {
                        showError();
                    }
                });
            }
        });
        return view;
    }

    private void showError() {
        Toast.makeText(getContext(), "Something went wrong, try again!", Toast.LENGTH_SHORT).show();
    }
}
