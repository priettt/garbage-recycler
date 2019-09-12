package com.unicen.garbage.ui.main

import android.os.Bundle
import com.google.android.material.textfield.TextInputEditText
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import com.unicen.garbage.R
import com.unicen.garbage.domain.RecyclingRepository
import com.unicen.garbage.domain.entities.Recycling

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TotalFragment : Fragment() {

    private var bottleText: TextInputEditText? = null
    private var tetrabrikText: TextInputEditText? = null
    private var glassText: TextInputEditText? = null
    private var paperboardText: TextInputEditText? = null
    private var cansText: TextInputEditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_total, container, false)
        bottleText = view.findViewById(R.id.total_bottles)
        tetrabrikText = view.findViewById(R.id.total_tetrabriks)
        glassText = view.findViewById(R.id.total_glass)
        paperboardText = view.findViewById(R.id.total_paperboard)
        cansText = view.findViewById(R.id.total_cans)
        val refreshButton = view.findViewById<Button>(R.id.total_refresh_button)
        refreshButton.setOnClickListener {
            val totalRecycling = RecyclingRepository.getTotalRecycling()
            totalRecycling.enqueue(object : Callback<Recycling> {
                override fun onResponse(call: Call<Recycling>, response: Response<Recycling>) {
                    if (response.body() != null) {
                        bottleText!!.setText(response.body()!!.bottles!!.toString())
                        tetrabrikText!!.setText(response.body()!!.tetrabriks!!.toString())
                        glassText!!.setText(response.body()!!.glass!!.toString())
                        paperboardText!!.setText(response.body()!!.paperboard!!.toString())
                        cansText!!.setText(response.body()!!.cans!!.toString())
                    } else {
                        showError()
                    }
                }

                override fun onFailure(call: Call<Recycling>, t: Throwable) {
                    showError()
                }
            })
        }

        return view
    }

    private fun showError() {
        Toast.makeText(context, "Something went wrong, try again!", Toast.LENGTH_SHORT).show()
    }

    companion object {

        fun newInstance(): TotalFragment {
            return TotalFragment()
        }
    }
}// Required empty public constructor
