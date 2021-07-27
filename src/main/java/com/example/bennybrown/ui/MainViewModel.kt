package com.example.bennybrown.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bennybrown.models.Item
import com.example.bennybrown.models.Student
import com.example.bennybrown.placeholder.RequestProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(): ViewModel() {
    val itemsLiveData = MutableLiveData<List<Item>>()
    val studentsLiveData = MutableLiveData<List<Student>>()

    fun getItems() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                itemsLiveData.postValue(RequestProvider.apiRequests.getItems())
            } catch (ex: Exception) {
            }
        }
    }

fun addStudent(newStudent: Student){
    CoroutineScope(Dispatchers.IO).launch {
   studentsLiveData.postValue(RequestProvider.apiRequests.addStudents(newStudent))
    }
}
}