package com.example.horrorfan.icons

import android.app.Application
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.horrorfan.database.Characters
import com.example.horrorfan.database.HorrorDao
import kotlinx.coroutines.Job
import timber.log.Timber

class CharacterListViewModel(val database: HorrorDao, application: Application) : AndroidViewModel(application)  {
    init{
        Timber.i("CharacterListViewModel Created")
    }

    var characters: LiveData<List<Characters>> = database.getAllCharacter()
    private var characterNameList = Transformations.map(characters) {
        formatCharacter(it)
    }

    private fun formatCharacter(characters:List<Characters>): Spanned {
        val sb = StringBuilder()
        sb.apply {
            characters.forEach {
                sb.append("<br>")
                sb.append(it.name)
            }
            sb.append("<br>")
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
        } else {
            return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }
}