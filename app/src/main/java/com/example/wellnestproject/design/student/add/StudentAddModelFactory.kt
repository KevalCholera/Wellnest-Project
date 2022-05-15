package com.example.wellnestproject.design.student.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wellnestproject.repository.student.StudentRepository


class StudentAddModelFactory constructor(private val repository: StudentRepository
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(StudentAddViewModel::class.java)) {
            StudentAddViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}