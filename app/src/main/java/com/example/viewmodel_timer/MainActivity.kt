package com.example.viewmodel_timer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel_timer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var vm:MainActivityVM
    lateinit var binding:ActivityMainBinding
    lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        vm=ViewModelProvider(this)[MainActivityVM::class.java]

        if(vm.counter==100){
        resetTimer()}


        vm.timerObserve.observe(this, Observer {
            binding.countDownId.text=it.toString()

        })


    }
    private fun resetTimer() {
        timer = object : CountDownTimer(100000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.countDownId.text = (vm.counter).toString()
                vm.counter--
                vm.timerObserve.value=vm.counter
            }
            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                binding.countDownId.text = "finished"
            }
        }
        timer.start()
    }
}