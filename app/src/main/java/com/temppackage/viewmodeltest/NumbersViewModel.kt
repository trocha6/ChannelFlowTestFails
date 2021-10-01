package com.temppackage.viewmodeltest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class NumbersViewModel: ViewModel() {
    private val _numbers: MutableLiveData<IntArray> = MutableLiveData(IntArray(0))
    val numbers: LiveData<IntArray> = _numbers
    val dataProvider = NumbersProvider()

    fun startCollecting() {
        viewModelScope.launch(Dispatchers.Main) {
            dataProvider.numbersFlow
                .onStart { println("start") }
                .onCompletion { println("end") }
                .catch { exception ->  println(exception.message.orEmpty())}
                .collect { data -> onDataRead(data) }
        }
    }

    fun onDataRead(data: Int) {
        _numbers.value = _numbers.value?.plus(data)
    }
}