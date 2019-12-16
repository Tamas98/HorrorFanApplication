package com.example.horrorfan.series


import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.horrorfan.R
import com.example.horrorfan.database.HorrorDatabase
import com.example.horrorfan.databinding.FragmentDetailsBinding

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment() {

    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentDetailsBinding>(inflater,
            R.layout.fragment_details,container,false)
        val application = requireNotNull(this.activity).application
        val dataSource = HorrorDatabase.getInstance(application).horrorDatabaseDao

        val args = DetailsFragmentArgs.fromBundle(arguments!!)

        val viewModelFactory = DetailsViewModelFactory(dataSource,application,args.title)
        detailsViewModel = ViewModelProviders.of(this,viewModelFactory).get(DetailsViewModel::class.java)
        binding.setLifecycleOwner(this)

        binding.detailsViewModel = detailsViewModel
        detailsViewModel.series.observe(this, Observer { new ->
            binding.seasons.text = new?.seasons.toString()
        })

        return binding.root
    }


}
