package com.unicen.garbage.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.unicen.garbage.R;
import com.unicen.garbage.domain.RecyclingRepository;
import com.unicen.garbage.domain.entities.Recycling;

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
                Recycling totalRecycling = RecyclingRepository.getTotalRecycling();
                if (totalRecycling != null) {
                    bottleText.setText(totalRecycling.getBottles());
                    tetrabrikText.setText(totalRecycling.getTetrabriks());
                    glassText.setText(totalRecycling.getGlass());
                    paperboardText.setText(totalRecycling.getPaperboard());
                    cansText.setText(totalRecycling.getCans());
                }
            }
        });

        return view;
    }
}
