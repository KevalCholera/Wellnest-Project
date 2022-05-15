package com.example.wellnestproject.dao.student

import androidx.room.*
import com.example.wellnestproject.response.student.StudentData
import com.example.wellnestproject.utils.DatabaseStudentData
import com.example.wellnestproject.utils.DatabaseStudentData.COMPANY_ID
import com.example.wellnestproject.utils.DatabaseStudentData.ID
import com.example.wellnestproject.utils.DatabaseStudentData.TABLE_STUDENT_DATA

@Entity(tableName = DatabaseStudentData.TABLE_STUDENT_DATA)
@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudentDetails(studentData: StudentData)

    @Query("SELECT * FROM $TABLE_STUDENT_DATA WHERE ${COMPANY_ID}=:companyId")
    fun getStudentList(companyId: Int): List<StudentData>

    @Query("SELECT $ID FROM $TABLE_STUDENT_DATA ORDER BY $ID DESC LIMIT 1")
    fun getLastIndexId(): Int?
}