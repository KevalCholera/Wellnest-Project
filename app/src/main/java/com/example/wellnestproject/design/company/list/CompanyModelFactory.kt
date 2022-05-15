package com.example.wellnestproject.design.company.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wellnestproject.repository.company.CompanyRepository


class CompanyModelFactory constructor(private val repository: CompanyRepository
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CompanyViewModel::class.java)) {
            CompanyViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}