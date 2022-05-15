package com.example.wellnestproject.response.company

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.wellnestproject.utils.DatabaseCompanyData
import kotlinx.parcelize.Parcelize

@Keep
@Entity(tableName = DatabaseCompanyData.TABLE_COMPANY_DATA)
@Parcelize
data class CompanyData(
    @PrimaryKey
    @ColumnInfo(name = DatabaseCompanyData.ID)
    val id: Int,
    @ColumnInfo(name = DatabaseCompanyData.NAME)
    val name: String,
    @ColumnInfo(name = DatabaseCompanyData.TOTAL_STUDENTS)
    val totalStudents: Int
) : Parcelable