package com.nghia.androidviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_control.*

class ControlFragment : Fragment(), View.OnClickListener {

    lateinit var activityMedalViewModel: MedalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TKhai bao ViewModel o requireActivity thi Share
        activityMedalViewModel = ViewModelProvider(requireActivity()).get(MedalViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_control, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayMedal()

        btnGoldMinus.setOnClickListener(this)
        btnGoldPlus.setOnClickListener(this)
        btnSilverMinus.setOnClickListener(this)
        btnSilverPlus.setOnClickListener(this)
        btnBronzeMinus.setOnClickListener(this)
        btnBronzePlus.setOnClickListener(this)
    }

    fun displayMedal() {
        tvMainGoldNumber.text = activityMedalViewModel.numberOfGoldMedal.value.toString()
        tvMainSilverNumber.text = activityMedalViewModel.numberOfSilverMedal.value.toString()
        tvMainBronzeNumber.text = activityMedalViewModel.numberOfBronzeMedal.value.toString()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            btnGoldMinus.id -> {
                activityMedalViewModel.numberOfGoldMedal.value =
                    activityMedalViewModel.numberOfGoldMedal.value?.minus(1)
                displayMedal()
            }
            btnGoldPlus.id -> {
                activityMedalViewModel.numberOfGoldMedal.value =
                    activityMedalViewModel.numberOfGoldMedal.value?.plus(1)
                displayMedal()
            }
            btnSilverMinus.id -> {
                activityMedalViewModel.numberOfSilverMedal.value =
                    activityMedalViewModel.numberOfSilverMedal.value?.minus(1)
                displayMedal()
            }
            btnSilverPlus.id -> {
                activityMedalViewModel.numberOfSilverMedal.value =
                    activityMedalViewModel.numberOfSilverMedal.value?.plus(1)
                displayMedal()
            }
            btnBronzeMinus.id -> {
                activityMedalViewModel.numberOfBronzeMedal.value =
                    activityMedalViewModel.numberOfBronzeMedal.value?.minus(1)
                displayMedal()
            }
            btnBronzePlus.id -> {
                activityMedalViewModel.numberOfBronzeMedal.value =
                    activityMedalViewModel.numberOfBronzeMedal.value?.plus(1)
                displayMedal()
            }
        }
    }
}