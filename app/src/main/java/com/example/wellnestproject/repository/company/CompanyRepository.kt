package com.example.wellnestproject.repository.company

import androidx.annotation.WorkerThread
import com.example.wellnestproject.dao.company.CompanyDao
import com.example.wellnestproject.response.company.CompanyData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CompanyRepository constructor(private val companyDao: CompanyDao) {

    @WorkerThread
    suspend fun insertCompanyDetails(companyData: CompanyData) = withContext(Dispatchers.IO) {
        companyDao.insertCompanyDetails(companyData)
    }

    @WorkerThread
    suspend fun getCompanyList() = withContext(Dispatchers.IO) {
        companyDao.getCompanyList()
    }

    @WorkerThread
    suspend fun getLastIndexId() = withContext(Dispatchers.IO) {
        companyDao.getLastIndexId()
    }
}