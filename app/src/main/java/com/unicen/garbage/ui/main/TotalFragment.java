package com.unicen.garbage.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.unicen.garbage.R;
import com.unicen.garbage.domain.RecyclingRepository;
import com.unicen.garbage.domain.entities.Recycling;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TotalFragment extends Fragment {

    private TextInputEditText bottleText;
    private TextInputEditText tetrabrikText;
    private TextInputEditText glassText;
    private TextInputEditText paperboardText;
    private TextInputEditText cansText;

    public TotalFragment() {
        // Required empty public constructor
    }

    public static TotalFragment newInstance() {
        return new TotalFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_total, container, false);
        bottleText = view.findViewById(R.id.total_bottles);
        tetrabrikText = view.findViewById(R.id.total_tetrabriks);
        glassText = view.findViewById(R.id.total_glass);
        paperboardText = view.findViewById(R.id.total_paperboard);
        cansText = view.findViewById(R.id.total_cans);
        Button refreshButton = view.findViewById(R.id.total_refresh_button);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Call<Recycling> totalRecycling = RecyclingRepository.getTotalRecycling();
                totalRecycling.enqueue(new Callback<Recycling>() {
                    @Override public void onResponse(Call<Recycling> call, Response<Recycling> response) {
                        if (response.body() != null) {
                            bottleText.setText(response.body().getBottles());
                            tetrabrikText.setText(response.body().getTetrabriks());
                            glassText.setText(response.body().getGlass());
                            paperboardText.setText(response.body().getPaperboard());
                            cansText.setText(response.body().getCans());
                        }
                    }

                    @Override public void onFailure(Call<Recycling> call, Throwable t) {
                        Toast.makeText(getContext(), "Server error. Try again later.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return view;
    }
}
