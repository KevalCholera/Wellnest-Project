package com.example.wellnestproject.design.company.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wellnestproject.databinding.ElementCompanyListBinding
import com.example.wellnestproject.response.company.CompanyData

class CompanyListAdapter(
    private val companyList: List<CompanyData>,
    private val itemClickListener: (CompanyData, Int) -> Unit
) : RecyclerView.Adapter<CompanyListAdapter.CompanyDataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyDataViewHolder {
        val binding =
            ElementCompanyListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CompanyDataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompanyDataViewHolder, position: Int) {
        val companyData = companyList[position]
        holder.bind(companyData, position)
    }

    override fun getItemCount(): Int {
        return companyList.size
    }


    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    inner class CompanyDataViewHolder(
        private val binding: ElementCompanyListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(companyData: CompanyData, position: Int) {

            binding.tvElementCompanyListName.text = companyData.name
            binding.tvElementCompanyListStudentsCount.text = companyData.totalStudents.toString()

            binding.root.setOnClickListener {
                itemClickListener(companyData, position)
            }

        }
    }
}