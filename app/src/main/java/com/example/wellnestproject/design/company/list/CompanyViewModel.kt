package com.example.wellnestproject.design.company.list

import androidx.lifecycle.ViewModel
import com.example.wellnestproject.repository.company.CompanyRepository
import com.example.wellnestproject.response.company.CompanyData
import kotlinx.coroutines.runBlocking

class CompanyViewModel constructor(private val companyRepository: CompanyRepository) : ViewModel() {

    fun getCompanyList(): List<CompanyData> = runBlocking { companyRepository.getCompanyList() }

}