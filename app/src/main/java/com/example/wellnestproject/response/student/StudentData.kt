package com.example.wellnestproject.response.student

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.wellnestproject.utils.DatabaseStudentData

@Keep
@Entity(tableName = DatabaseStudentData.TABLE_STUDENT_DATA)
data class StudentData(
    @PrimaryKey
    @ColumnInfo(name = DatabaseStudentData.ID)
    val id: Int,
    @ColumnInfo(name = DatabaseStudentData.NAME)
    val name: String,
    @ColumnInfo(name = DatabaseStudentData.COMPANY_ID)
    val companyId: Int
)