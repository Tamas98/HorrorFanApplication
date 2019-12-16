package com.example.horrorfan.icons


import android.os.Bundle
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
import com.example.horrorfan.databinding.FragmentCharacterBinding

/**
 * A simple [Fragment] subclass.
 */
class CharacterFragment : Fragment() {

    private lateinit var viewModel: CharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCharacterBinding>(inflater,
            R.layout.fragment_character,container,false)
        val application = requireNotNull(this.activity).application
        val dataSource = HorrorDatabase.getInstance(application).horrorDatabaseDao

        val args = CharacterFragmentArgs.fromBundle(arguments!!)

        val viewModelFactory = CharacterViewModelFactory(dataSource,application,args.name)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(CharacterViewModel::class.java)
        binding.setLifecycleOwner(this)

       // viewModel.character.observe(this, Observer { new ->
            //binding.movieTitle.text = movieViewModel.movie.value?.title
        //})

        binding.characterViewModel = viewModel
        return binding.root
    }


}
