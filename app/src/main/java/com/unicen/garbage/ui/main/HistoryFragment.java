package com.unicen.garbage.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.unicen.garbage.R;
import com.unicen.garbage.domain.RecyclingRepository;
import com.unicen.garbage.domain.entities.Recycling;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    public HistoryFragment() {
    }

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        Context context = view.getContext();
        final RecyclingAdapter adapter = new RecyclingAdapter(RecyclingRepository.getRecyclingHistory());
        RecyclerView recyclerView = view.findViewById(R.id.history_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        Button refreshButton = view.findViewById(R.id.history_refresh_button);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                ArrayList<Recycling> aux = new ArrayList<>();
                aux.add(new Recycling("hola", "hola", "hola", "hola", "hola", "hola"));
                aux.add(new Recycling("hola", "hola", "hola", "hola", "hola", "hola"));
                aux.add(new Recycling("hola", "hola", "hola", "hola", "hola", "hola"));
                aux.add(new Recycling("hola", "hola", "hola", "hola", "hola", "hola"));
                aux.add(new Recycling("hola", "hola", "hola", "hola", "hola", "hola"));
                aux.add(new Recycling("hola", "hola", "hola", "hola", "hola", "hola"));
                aux.add(new Recycling("hola", "hola", "hola", "hola", "hola", "hola"));
                aux.add(new Recycling("hola", "hola", "hola", "hola", "hola", "hola"));

                adapter.updateItems(aux);
            }
        });
        return view;
    }
}
