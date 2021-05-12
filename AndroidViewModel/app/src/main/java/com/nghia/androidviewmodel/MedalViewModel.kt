package com.nghia.androidviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by nghia.vuong on 12,May,2021
 */
class MedalViewModel : ViewModel() {

    // LiveData for Observer
    var numberOfGoldMedal: MutableLiveData<Int> = MutableLiveData()
    var numberOfSilverMedal: MutableLiveData<Int> = MutableLiveData()
    var numberOfBronzeMedal: MutableLiveData<Int> = MutableLiveData()

    init {
        numberOfGoldMedal.value = 0
        numberOfSilverMedal.value = 0
        numberOfBronzeMedal.value = 0
    }
}