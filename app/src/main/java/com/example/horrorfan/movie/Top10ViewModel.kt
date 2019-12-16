package com.example.horrorfan.movie

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.text.HtmlCompat
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.example.horrorfan.database.HorrorDao
import com.example.horrorfan.database.Movies
import kotlinx.coroutines.*
import timber.log.Timber

class Top10ViewModel(val database: HorrorDao, application: Application) : AndroidViewModel(application) {
    init{
        Timber.i("Top10ViewModel Created")
       // getAllMovie()
    }

    private var viewModelJob = Job()
    var movies: LiveData<List<Movies>> = database.getAllMovie()
    val movieString = Transformations.map(movies){
        formatMovies(it)
    }


    private fun formatMovies(movies:List<Movies>) : Spanned{
        val sb = StringBuilder()
        sb.apply{
            movies.forEach{
                append("<br>")
                append(it.title)
            }
            append("<br>")
        }

       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
       } else {
            return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
        }

    }

    /*private fun getAllMovie(){
      CoroutineScope(Dispatchers.Main + Job()).launch{
          movies.value = queryMovies()
      }

  }

  private suspend fun queryMovies():List<Movies>?{
      return withContext(Dispatchers.IO){
          database.getAllMovies()
      }
  }

  override fun onCleared() {
      super.onCleared()
      viewModelJob.cancel()
  }*/
}