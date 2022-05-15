package com.example.wellnestproject.design.company.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wellnestproject.repository.company.CompanyRepository

class CompanyAddModelFactory constructor(
    private val repository: CompanyRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CompanyAddViewModel::class.java)) {
            CompanyAddViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}