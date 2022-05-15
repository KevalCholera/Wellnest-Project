package com.example.wellnestproject.design.student.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wellnestproject.R
import com.example.wellnestproject.base.BaseActivity
import com.example.wellnestproject.databinding.ActivityStudentBinding
import com.example.wellnestproject.design.student.add.StudentAddActivity
import com.example.wellnestproject.design.student.list.adapter.StudentListAdapter
import com.example.wellnestproject.repository.student.StudentRepository
import com.example.wellnestproject.response.company.CompanyData

class StudentActivity : BaseActivity(), View.OnClickListener {

    private val binding: ActivityStudentBinding by binding(R.layout.activity_student)
    private lateinit var viewModel: StudentViewModel
    lateinit var companyData: CompanyData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(
            this,
            StudentModelFactory(StudentRepository(projectDatabase))
        ).get(StudentViewModel::class.java)
        binding.tvStudentNoDataAddStudent.setOnClickListener(this)
        binding.tvStudentHeaderAddStudent.setOnClickListener(this)
        binding.ivStudentHeaderBack.setOnClickListener(this)
        companyData = intent.getParcelableExtra("companyData")!!

    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.tvStudentNoDataAddStudent -> {

                startActivity(
                    Intent(this, StudentAddActivity::class.java)
                        .putExtra("companyData", companyData)
                )
            }
            binding.tvStudentHeaderAddStudent -> {
                startActivity(
                    Intent(this, StudentAddActivity::class.java)
                        .putExtra("companyData", companyData)
                )
            }
            binding.ivStudentHeaderBack -> {
                onBackPressed()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.tvStudentHeaderCompanyName.text = companyData.name
        val studentList = viewModel.getStudentList(companyData.id)

        binding.rvStudentList.isVisible = studentList.isNotEmpty()
        binding.tvStudentNoDataAddStudent.isVisible = studentList.isEmpty()
        binding.tvStudentNoDataTitle.isVisible = studentList.isEmpty()

        val studentListAdapter = StudentListAdapter(studentList)
        binding.rvStudentList.apply {
            layoutManager = LinearLayoutManager(this@StudentActivity)
            adapter = studentListAdapter
        }
    }
}