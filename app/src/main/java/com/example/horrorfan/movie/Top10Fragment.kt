package com.example.horrorfan.movie


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.horrorfan.R
import com.example.horrorfan.database.HorrorDatabase
import com.example.horrorfan.databinding.FragmentTop10Binding
import com.example.horrorfan.recycle.MovieListener
import com.example.horrorfan.recycle.TextMovieAdapter

/**
 * A simple [Fragment] subclass.
 */
class Top10Fragment : Fragment() {

    private lateinit var viewModel: Top10ViewModel
    private lateinit var titles:MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTop10Binding>(inflater,
            R.layout.fragment_top10,container,false)

        val application = requireNotNull(this.activity).application
        val dataSource = HorrorDatabase.getInstance(application).horrorDatabaseDao

        var viewModelFactory = Top10ViewModelFactory(dataSource,application)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(Top10ViewModel::class.java)
        binding.setLifecycleOwner(this)
        titles = mutableListOf()
        binding.top10ViewModel = viewModel

        viewModel.movies.observe(this, Observer {
            titles.clear()
            it.forEach { titles.add(it.title) }
            handleClick(binding.allMoviesList)
        })

        return binding.root
    }

    private fun handleClick(layout: LinearLayout){
            layout.visibility = View.VISIBLE
            titles.forEach {title->
                println(title)
                val button = Button(this.context)
                button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
                button.setBackgroundColor(Color.TRANSPARENT)
                button.text = title
                button.setTextColor(Color.RED)
                button.setOnClickListener { this.findNavController().navigate(
                    Top10FragmentDirections.actionTop10FragmentToMovieFragment(title)
                )}
                layout.addView(button)
        }
    }
}
