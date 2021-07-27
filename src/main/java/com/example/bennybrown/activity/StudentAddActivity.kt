package com.example.bennybrown.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bennybrown.databinding.ActivityMainBinding
import com.example.bennybrown.models.Student
import com.example.bennybrown.ui.MainViewModel

class StudentAddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.studentgetId.setOnClickListener {
            addStudent()
        }
    }

    private fun addStudent(){
        val name = binding.studentsnameId.text.toString()
        val seat = binding.seatnumberId.text.toString()
        val classNames = binding.studentsClass.text.toString()

        if (name.isNotEmpty() && seat.isNotEmpty() && classNames.isNotEmpty()){
            val newStudent = Student(name, seat, classNames)
            viewModel.addStudent(newStudent)
            Toast.makeText(this, "Successfully Added", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_LONG).show()
        }
    }
}