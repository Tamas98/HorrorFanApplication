package com.example.horrorfan.series


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.horrorfan.R
import com.example.horrorfan.databinding.FragmentSeriesBinding

/**
 * A simple [Fragment] subclass.
 */
class SeriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSeriesBinding>(inflater,
            R.layout.fragment_series,container,false)
        return binding.root
    }


}
