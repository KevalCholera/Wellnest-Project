package com.example.wellnestproject.utils

const val DATABASE_NAME = "ProjectDatabase.db"

object DatabaseCompanyData {
    const val TABLE_COMPANY_DATA = "companyData"
    const val ID = "id"
    const val NAME = "name"
    const val TOTAL_STUDENTS = "totalStudents"
}

object DatabaseStudentData {
    const val TABLE_STUDENT_DATA = "studentData"
    const val ID = "id"
    const val NAME = "name"
    const val COMPANY_ID = "companyId"
}