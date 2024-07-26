package com.geeks.hw1_6m

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.hw_1_6.Counter

class CounterViewModel : ViewModel(){

    private val counter = Counter()
    private val counterData = MutableLiveData<Int>()
    val counterLD : LiveData<Int>
        get() = counterData

    fun updateCounterData(isInc : Boolean){
        if (isInc) counter.inc() else counter.dec()
        counterData.value=counter.getCountResult()
    }
    //fun counterData(): LiveData<Int> = counterData
}