package com.example.wellnestproject.design.student.list

import androidx.lifecycle.ViewModel
import com.example.wellnestproject.repository.student.StudentRepository
import com.example.wellnestproject.response.student.StudentData
import kotlinx.coroutines.runBlocking

class StudentViewModel constructor(private val StudentRepository: StudentRepository) : ViewModel() {

    fun getStudentList(companyId: Int): List<StudentData> = runBlocking { StudentRepository.getStudentList(companyId) }

}