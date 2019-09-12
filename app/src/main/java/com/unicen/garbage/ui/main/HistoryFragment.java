package com.unicen.garbage.ui.main;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.unicen.garbage.R;
import com.unicen.garbage.domain.RecyclingRepository;
import com.unicen.garbage.domain.entities.Recycling;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        final RecyclingAdapter adapter = new RecyclingAdapter(new ArrayList<Recycling>());
        final RecyclerView recyclerView = view.findViewById(R.id.history_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        Button refreshButton = view.findViewById(R.id.history_refresh_button);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                RecyclingRepository.getRecyclingHistory(getContext()).enqueue(new Callback<List<Recycling>>() {
                    @Override public void onResponse(Call<List<Recycling>> call, Response<List<Recycling>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            adapter.updateItems(response.body());
                        } else {
                            showError();
                        }
                    }

                    @Override public void onFailure(Call<List<Recycling>> call, Throwable t) {
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
