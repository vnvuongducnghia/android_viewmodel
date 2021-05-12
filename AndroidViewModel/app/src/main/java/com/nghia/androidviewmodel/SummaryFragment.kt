package com.nghia.androidviewmodel

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_summary.*

class SummaryFragment : Fragment() {

    lateinit var activityMedalViewModel: MedalViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityMedalViewModel = ViewModelProvider(requireActivity()).get(MedalViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityMedalViewModel.numberOfGoldMedal.observe(requireActivity(), Observer<Int> { displayMedal() })
        activityMedalViewModel.numberOfSilverMedal.observe(requireActivity(), Observer<Int> { displayMedal() })
        activityMedalViewModel.numberOfBronzeMedal.observe(requireActivity(), Observer<Int> { displayMedal() })
    }

    fun displayMedal() {
        println("SummaryFragment.displayMedal")
        val totalMedal: Int =
            activityMedalViewModel.numberOfGoldMedal.value!!.plus(activityMedalViewModel.numberOfSilverMedal.value!!)
                .plus(activityMedalViewModel.numberOfBronzeMedal.value!!)
        tvNumberOfMedal.text = "medal_label $totalMedal"
    }
}
