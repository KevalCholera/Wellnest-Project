package com.example.wellnestproject.dao.company

import androidx.room.*
import com.example.wellnestproject.response.company.CompanyData
import com.example.wellnestproject.utils.DatabaseCompanyData.ID
import com.example.wellnestproject.utils.DatabaseCompanyData.TABLE_COMPANY_DATA
import com.example.wellnestproject.utils.DatabaseCompanyData.TOTAL_STUDENTS

@Entity(tableName = TABLE_COMPANY_DATA)
@Dao
interface CompanyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCompanyDetails(companyResponse: CompanyData)

    @Query("SELECT * FROM $TABLE_COMPANY_DATA")
    fun getCompanyList(): List<CompanyData>

    @Query("SELECT $ID FROM $TABLE_COMPANY_DATA ORDER BY $ID DESC LIMIT 1")
    fun getLastIndexId(): Int?

    @Query("SELECT $TOTAL_STUDENTS FROM $TABLE_COMPANY_DATA WHERE $ID =:companyId")
    fun getTotalStudentCount(companyId: Int): Int?

    @Query("Update $TABLE_COMPANY_DATA SET ${TOTAL_STUDENTS}= :totalStudents WHERE  $ID=:companyId")
    fun updateCompanyDetails(totalStudents: Int, companyId: Int)

}