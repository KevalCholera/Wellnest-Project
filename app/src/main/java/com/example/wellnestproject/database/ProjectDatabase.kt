package com.example.wellnestproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.wellnestproject.dao.company.CompanyDao
import com.example.wellnestproject.dao.student.StudentDao
import com.example.wellnestproject.response.company.CompanyData
import com.example.wellnestproject.response.student.StudentData
import com.example.wellnestproject.utils.DATABASE_NAME

@Database(
    entities = [CompanyData::class,StudentData::class],
    version = 1,
    exportSchema = true
)
abstract class ProjectDatabase : RoomDatabase() {

    abstract fun companyDao(): CompanyDao
    abstract fun studentDao(): StudentDao

    companion object {

        @Volatile
        private var INSTANCE: ProjectDatabase? = null

        fun getDatabaseData(context: Context): ProjectDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProjectDatabase::class.java,
                    DATABASE_NAME
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}