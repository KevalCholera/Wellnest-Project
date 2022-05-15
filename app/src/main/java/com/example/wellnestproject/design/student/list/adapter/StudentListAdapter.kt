package com.example.wellnestproject.design.student.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wellnestproject.databinding.ElementStudentListBinding
import com.example.wellnestproject.response.student.StudentData

class StudentListAdapter(
    private val studentList: List<StudentData>
) : RecyclerView.Adapter<StudentListAdapter.StudentDataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentDataViewHolder {
        val binding = ElementStudentListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentDataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentDataViewHolder, position: Int) {
        val studentData = studentList[position]
        holder.bind(studentData)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }


    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    inner class StudentDataViewHolder(
        private val binding: ElementStudentListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(studentData: StudentData) {
            binding.tvElementStudentListName.text = studentData.name
        }
    }
}