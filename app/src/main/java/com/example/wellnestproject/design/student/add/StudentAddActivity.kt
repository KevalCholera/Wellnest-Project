package com.example.wellnestproject.design.student.add

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.wellnestproject.R
import com.example.wellnestproject.base.BaseActivity
import com.example.wellnestproject.databinding.ActivityStudentAddBinding
import com.example.wellnestproject.repository.student.StudentRepository
import com.example.wellnestproject.response.company.CompanyData
import com.example.wellnestproject.response.student.StudentData

class StudentAddActivity : BaseActivity(), View.OnClickListener {

    private val binding: ActivityStudentAddBinding by binding(R.layout.activity_student_add)
    private lateinit var viewModel: StudentAddViewModel
    private lateinit var companyData: CompanyData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(
            this,
            StudentAddModelFactory(StudentRepository(projectDatabase))
        ).get(StudentAddViewModel::class.java)

        binding.ivStudentAddHeaderBack.setOnClickListener(this)
        binding.tvStudentAddHeaderSave.setOnClickListener(this)
        companyData = intent.getParcelableExtra("companyData")!!
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.ivStudentAddHeaderBack -> {
                onBackPressed()
            }
            binding.tvStudentAddHeaderSave -> {
                val lastIndex = (viewModel.getLastIndexId() ?: 0) + 1

                if (binding.etStudentAddStudentName.text.toString().isNotEmpty()) {
                    viewModel.insertStudentList(
                        StudentData(
                            lastIndex,
                            binding.etStudentAddStudentName.text.toString(),
                            companyData.id
                        ),
                        companyData.id
                    )
                    finish()
                } else
                    Toast.makeText(this, "Enter Student name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}