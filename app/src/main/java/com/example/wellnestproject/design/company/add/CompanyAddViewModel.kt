package com.example.wellnestproject.design.company.add

import androidx.lifecycle.ViewModel
import com.example.wellnestproject.repository.company.CompanyRepository
import com.example.wellnestproject.response.company.CompanyData
import kotlinx.coroutines.runBlocking

class CompanyAddViewModel constructor(private val companyRepository: CompanyRepository) : ViewModel() {

    fun insertCompanyList(companyData: CompanyData) = runBlocking { companyRepository.insertCompanyDetails(companyData) }
    fun getLastIndexId() = runBlocking { companyRepository.getLastIndexId() }

}