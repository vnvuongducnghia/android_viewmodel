package com.nghia.androidviewmodel

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var mCounterViewModel: CounterViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mCounterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
        displayCount()
        btnUp.setOnClickListener(this)
        btnDown.setOnClickListener(this)
    }

    fun displayCount() {
        tvCount.text = mCounterViewModel?.count.toString()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            btnUp.id -> {
                mCounterViewModel?.count = mCounterViewModel?.count!! + 1
                displayCount()
            }

            btnDown.id -> {
                mCounterViewModel?.count = mCounterViewModel?.count!! - 1
                displayCount()
            }
        }
    }
}