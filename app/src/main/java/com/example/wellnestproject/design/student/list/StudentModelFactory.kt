package com.example.wellnestproject.design.student.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wellnestproject.repository.student.StudentRepository

class StudentModelFactory constructor(private val repository: StudentRepository
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(StudentViewModel::class.java)) {
            StudentViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}