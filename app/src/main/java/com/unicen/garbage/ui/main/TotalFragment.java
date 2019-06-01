package com.unicen.garbage.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unicen.garbage.R;

public class TotalFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_total, container, false);
    }
}
