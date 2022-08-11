package my.tarc.sampleviewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//TODO : 2 Create ViewModel class
class CounterViewModel : ViewModel() {
    val _counter = MutableLiveData<Int>()

    init { //Initialization of ViewModel
        _counter.value = 0
        Log.d("ViewModel", "Initialise")
    }

    fun increaseCounter(){
        _counter.value = _counter.value?.plus(1)
    }

    fun decreaseCounter(){
        _counter.value = _counter.value?.minus(1)
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("ViewModel", "Cleared")
    }
}