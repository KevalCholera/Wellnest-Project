package com.example.wellnestproject.base

import android.os.Bundle
import com.example.wellnestproject.database.ProjectDatabase

open class BaseActivity : DataBindingActivity() {
    protected lateinit var projectDatabase: ProjectDatabase
    protected val TAG = javaClass.simpleName.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        projectDatabase = ProjectDatabase.getDatabaseData(this)

    }
}