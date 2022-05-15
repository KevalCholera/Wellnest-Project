package com.example.wellnestproject.design.company.add

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.wellnestproject.R
import com.example.wellnestproject.base.BaseActivity
import com.example.wellnestproject.databinding.ActivityCompanyAddBinding
import com.example.wellnestproject.repository.company.CompanyRepository
import com.example.wellnestproject.response.company.CompanyData

class CompanyAddActivity : BaseActivity(), View.OnClickListener {

    private val binding: ActivityCompanyAddBinding by binding(R.layout.activity_company_add)
    private lateinit var viewModel: CompanyAddViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(
            this,
            CompanyAddModelFactory(CompanyRepository(projectDatabase.companyDao()))
        ).get(CompanyAddViewModel::class.java)

        binding.ivCompanyAddHeaderBack.setOnClickListener(this)
        binding.tvCompanyAddHeaderSave.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.ivCompanyAddHeaderBack -> {
                onBackPressed()
            }
            binding.tvCompanyAddHeaderSave -> {
                val lastIndex = (viewModel.getLastIndexId() ?: 0) + 1

                if (binding.etCompanyAddCompanyName.text.toString().isNotEmpty()) {
                    viewModel.insertCompanyList(
                        CompanyData(
                            lastIndex,
                            binding.etCompanyAddCompanyName.text.toString(),
                            0
                        )
                    )
                    finish()
                }
                else
                    Toast.makeText(this, "Enter Company name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}