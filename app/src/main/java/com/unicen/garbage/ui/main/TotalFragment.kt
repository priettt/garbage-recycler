package com.unicen.garbage.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText
import com.unicen.garbage.R
import com.unicen.garbage.domain.entities.Recycling
import com.unicen.garbage.viewmodel.Resource
import com.unicen.garbage.viewmodel.TotalViewModel

class TotalFragment : Fragment() {

    private var bottleText: TextInputEditText? = null
    private var tetrabrikText: TextInputEditText? = null
    private var glassText: TextInputEditText? = null
    private var paperboardText: TextInputEditText? = null
    private var cansText: TextInputEditText? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_total, container, false)
        val viewModel = ViewModelProviders.of(this)[TotalViewModel::class.java]
        bottleText = view.findViewById(R.id.total_bottles)
        tetrabrikText = view.findViewById(R.id.total_tetrabriks)
        glassText = view.findViewById(R.id.total_glass)
        paperboardText = view.findViewById(R.id.total_paperboard)
        cansText = view.findViewById(R.id.total_cans)

        viewModel.getTotalRecycling().observe(this, Observer<Resource<Recycling>> { recycling ->
            showRecycling(recycling)
        })

        val refreshButton = view.findViewById<Button>(R.id.total_refresh_button)
        refreshButton.setOnClickListener {
            viewModel.refreshButtonClicked()
        }

        return view
    }

    private fun showRecycling(recycling: Resource<Recycling>) {
        if (recycling is Resource.Success) {
            bottleText?.setText(recycling.data?.bottles.toString())
            tetrabrikText?.setText(recycling.data?.tetrabriks.toString())
            glassText?.setText(recycling.data?.glass.toString())
            paperboardText?.setText(recycling.data?.paperboard.toString())
            cansText?.setText(recycling.data?.cans.toString())
        } else {
            showError()
        }

    }

    private fun showError() {
        Toast.makeText(context, "Something went wrong, try again!", Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance(): TotalFragment {
            return TotalFragment()
        }
    }
}
