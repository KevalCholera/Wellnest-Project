package com.example.wellnestproject.repository.student

import androidx.annotation.WorkerThread
import com.example.wellnestproject.database.ProjectDatabase
import com.example.wellnestproject.response.student.StudentData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StudentRepository(
    private val projectDatabase: ProjectDatabase
) {

    @WorkerThread
    suspend fun insertStudentDetails(studentData: StudentData) = withContext(Dispatchers.IO) {
        projectDatabase.studentDao().insertStudentDetails(studentData)
    }

    @WorkerThread
    suspend fun getStudentList(companyId: Int) = withContext(Dispatchers.IO) {
        projectDatabase.studentDao().getStudentList(companyId)
    }

    @WorkerThread
    suspend fun getLastIndexId() = withContext(Dispatchers.IO) {
        projectDatabase.studentDao().getLastIndexId()
    }

    @WorkerThread
    suspend fun updateCompanyDetails(totalStudents: Int, companyId: Int) = withContext(Dispatchers.IO) {
        projectDatabase.companyDao().updateCompanyDetails(totalStudents, companyId)
    }

    @WorkerThread
    suspend fun getTotalStudentCount(companyId: Int) = withContext(Dispatchers.IO) {
        projectDatabase.companyDao().getTotalStudentCount(companyId)
    }
}