package com.example.wellnestproject.design.student.add

import androidx.lifecycle.ViewModel
import com.example.wellnestproject.repository.student.StudentRepository
import com.example.wellnestproject.response.student.StudentData
import kotlinx.coroutines.runBlocking

class StudentAddViewModel constructor(private val studentRepository: StudentRepository) :
    ViewModel() {

    fun insertStudentList(studentData: StudentData, companyId: Int) = runBlocking {
        studentRepository.insertStudentDetails(studentData)
        val totalStudentsData = (studentRepository.getTotalStudentCount(studentData.companyId) ?: 0) + 1
        studentRepository.updateCompanyDetails(totalStudentsData, companyId)

    }

    fun getLastIndexId() = runBlocking { studentRepository.getLastIndexId() }

}