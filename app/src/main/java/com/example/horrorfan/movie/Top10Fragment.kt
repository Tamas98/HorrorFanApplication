package com.example.horrorfan.movie


import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.horrorfan.R
import com.example.horrorfan.movie.Top10FragmentDirections
import com.example.horrorfan.databinding.FragmentTop10Binding

/**
 * A simple [Fragment] subclass.
 */
class Top10Fragment : Fragment() {

    private val best_of_2019 = arrayOf("Pet Semetary","IT:Chapter 2",
    "Countdown",
    "Brightburn",
    "The Perfection",
    "Child\'s Play",
    "The Curse of La Llorona",
    "Us",
    "Ready or Not",
    "The Prodigy")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTop10Binding>(inflater,
            R.layout.fragment_top10,container,false)
        binding.top2019.setOnClickListener( {handleClick(binding.tops2019)} )
       // binding.top2018.setOnClickListener({handleClick(binding.tops2018)})
        //binding.top2017.setOnClickListener({handleClick(binding.tops2017)})
        return binding.root
    }

    private fun handleClick(layout: LinearLayout){
        best_of_2019.forEach {title->
            val button = Button(this.context)
            button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT)
            button.setBackgroundColor(Color.TRANSPARENT)
            button.text = title
            button.setTextColor(Color.RED)
            button.setOnClickListener({ this.findNavController().navigate(
                Top10FragmentDirections.actionTop10FragmentToMovieFragment(title)
            )})
            layout.addView(button)
        }

        if(layout.visibility == 0){
            layout.visibility = View.GONE
        }else{
           layout.visibility = View.VISIBLE
        }
    }
}
