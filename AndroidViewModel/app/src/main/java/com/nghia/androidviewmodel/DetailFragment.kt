package com.nghia.androidviewmodel

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityMedalViewModel.numberOfGoldMedal.observe(this, { displayMedal() })
        activityMedalViewModel.numberOfSilverMedal.observe(this, { displayMedal() })
        activityMedalViewModel.numberOfBronzeMedal.observe(this, { displayMedal() })
    }

    fun displayMedal() {
        tvDetailGoldNumber.text = "gold${activityMedalViewModel.numberOfGoldMedal.value}"
        tvDetailSilverNumber.text = "silver${activityMedalViewModel.numberOfSilverMedal.value}"
        tvDetailBronzeNumber.text = "bronze${activityMedalViewModel.numberOfBronzeMedal.value}"
    }
}