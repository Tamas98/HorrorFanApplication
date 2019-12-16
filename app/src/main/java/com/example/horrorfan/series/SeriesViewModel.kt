package com.example.horrorfan.series

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.horrorfan.database.HorrorDao

class SeriesViewModel(val database: HorrorDao, application: Application) : AndroidViewModel(application) {

    var series = database.getAllSeries()
}