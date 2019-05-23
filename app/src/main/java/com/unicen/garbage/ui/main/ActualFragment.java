package com.unicen.garbage.ui.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unicen.garbage.R;
import com.unicen.garbage.domain.entities.Recycling;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ActualFragment.OnSubmitToServerPressedListener} interface and
 * {@link ActualFragment.OnSaveLocallyPressedListener} interface
 * to handle interaction events.
 * Use the {@link ActualFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActualFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnSubmitToServerPressedListener submitToServerListener;
    private OnSaveLocallyPressedListener saveLocallyListener;

    public ActualFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActualFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActualFragment newInstance(String param1, String param2) {
        ActualFragment fragment = new ActualFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actual, container, false);
    }

    // TODO: Call when button pressed
    public void onSubmitToServerPressed() {
        if (submitToServerListener != null) {
            submitToServerListener.onSubmitToServerPressed(new Recycling(
                    //TODO: fill with ui data
            ));
        }
    }

    // TODO: Call when button pressed
    public void onSaveLocallyPressed() {
        if (saveLocallyListener != null) {
            saveLocallyListener.onSaveLocallyPressed(new Recycling(
                    //TODO: fill with ui data
            ));
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSubmitToServerPressedListener) {
            submitToServerListener = (OnSubmitToServerPressedListener) context;
            saveLocallyListener = (OnSaveLocallyPressedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        submitToServerListener = null;
        saveLocallyListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnSubmitToServerPressedListener {
        void onSubmitToServerPressed(Recycling recycling);
    }

    public interface OnSaveLocallyPressedListener {
        void onSaveLocallyPressed(Recycling recycling);
    }
}
