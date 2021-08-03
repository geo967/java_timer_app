package com.example.viewmodel_timer

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodel_timer.databinding.ActivityMainBinding

class MainActivityVM:ViewModel() {

    var counter= 100


    //live data
    val timerObserve:MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }

    //connecting to db

    //connecting to view


}