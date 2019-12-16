package com.example.horrorfan.icons

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.horrorfan.database.HorrorDao

class CharacterViewModelFactory (private val dataSource: HorrorDao, private val application: Application, private val name:String) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterViewModel::class.java)) {
            return CharacterViewModel(dataSource, application,name) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}