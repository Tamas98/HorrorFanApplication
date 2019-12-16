package com.example.horrorfan.icons

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.horrorfan.database.Characters
import com.example.horrorfan.database.HorrorDao
import kotlinx.coroutines.*
import timber.log.Timber

class CharacterViewModel(val database: HorrorDao, application: Application, name:String) : AndroidViewModel(application) {

    init{
        Timber.i("CharacterViewModel constructed")
        getSelectedCharacter()
    }

    private var name = name
    private var viewModelJob = Job()
    private var _character = MutableLiveData<Characters?>()
    val character
        get() = _character

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
        Timber.i("CharacterViewModel cleared")
    }

    private fun getSelectedCharacter() {
        CoroutineScope(Job() + Dispatchers.Main).launch {
            character.value = getCharacterFromDatabase()
        }
    }

    private suspend fun getCharacterFromDatabase():Characters?{
        return withContext(Dispatchers.IO){
            var character = database.getCharacter(name)
            character
        }
    }


}