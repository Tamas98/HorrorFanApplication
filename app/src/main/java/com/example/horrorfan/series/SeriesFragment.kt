package com.example.horrorfan.series


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.horrorfan.R
import com.example.horrorfan.database.HorrorDatabase
import com.example.horrorfan.database.Series
import com.example.horrorfan.databinding.FragmentSeriesBinding

/**
 * A simple [Fragment] subclass.
 */
class SeriesFragment : Fragment() {

    private lateinit var viewModel: SeriesViewModel
    private lateinit var titles:MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSeriesBinding>(inflater,
            R.layout.fragment_series,container,false)

        val application = requireNotNull(this.activity).application
        val dataSource = HorrorDatabase.getInstance(application).horrorDatabaseDao

        var viewModelFactory = SeriesViewModelFactory(dataSource,application)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(SeriesViewModel::class.java)

        titles = mutableListOf()

        binding.setLifecycleOwner(this)

        viewModel.series.observe(this, Observer {
            titles.clear()
            it.forEach { titles.add(it.title) }
            handleClick(binding.allSeriesList)
        })

        return binding.root
    }

    private fun handleClick(layout: LinearLayout){
        layout.visibility = View.VISIBLE
        titles.forEach {title->
            println(title)
            val button = Button(this.context)
            button.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
            button.setBackgroundColor(Color.TRANSPARENT)
            button.text = title
            button.setTextColor(Color.RED)
            button.setOnClickListener({ this.findNavController().navigate(
                SeriesFragmentDirections.actionSeriesFragmentToDetailsFragment(title)
            )})
            layout.addView(button)
        }
    }

}
