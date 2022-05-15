package com.example.wellnestproject.design.company.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wellnestproject.R
import com.example.wellnestproject.base.BaseActivity
import com.example.wellnestproject.databinding.ActivityCompanyBinding
import com.example.wellnestproject.design.company.add.CompanyAddActivity
import com.example.wellnestproject.design.company.list.adapter.CompanyListAdapter
import com.example.wellnestproject.design.student.list.StudentActivity
import com.example.wellnestproject.repository.company.CompanyRepository
import com.example.wellnestproject.response.company.CompanyData

class CompanyActivity : BaseActivity(), View.OnClickListener {

    private val binding: ActivityCompanyBinding by binding(R.layout.activity_company)
    private lateinit var viewModel: CompanyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(
            this,
            CompanyModelFactory(CompanyRepository(projectDatabase.companyDao()))
        ).get(CompanyViewModel::class.java)
        binding.tvCompanyNoDataAddCompany.setOnClickListener(this)
        binding.tvCompanyHeaderAddCompany.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.tvCompanyNoDataAddCompany -> {
                startActivity(Intent(this, CompanyAddActivity::class.java))
            }
            binding.tvCompanyHeaderAddCompany -> {
                startActivity(Intent(this, CompanyAddActivity::class.java))
            }
        }
    }

    private val itemClickListener = fun(companyData: CompanyData, position: Int) {

        startActivity(
            Intent(this, StudentActivity::class.java)
                .putExtra("companyData", companyData)
        )
    }

    override fun onResume() {
        super.onResume()
        val companyList = viewModel.getCompanyList()

        binding.rvCompanyList.isVisible = companyList.isNotEmpty()
        binding.tvCompanyNoDataAddCompany.isVisible = companyList.isEmpty()
        binding.tvCompanyNoDataTitle.isVisible = companyList.isEmpty()

        val companyListAdapter = CompanyListAdapter(companyList, itemClickListener)
        binding.rvCompanyList.apply {
            layoutManager = LinearLayoutManager(this@CompanyActivity)
            adapter = companyListAdapter
        }
    }
}