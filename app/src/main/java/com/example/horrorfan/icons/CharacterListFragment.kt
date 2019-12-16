package com.example.horrorfan.icons


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
import com.example.horrorfan.database.Characters
import com.example.horrorfan.database.HorrorDatabase
import com.example.horrorfan.databinding.FragmentCharacterlistBinding
import com.example.horrorfan.movie.Top10FragmentDirections

/**
 * A simple [Fragment] subclass.
 */
class CharacterListFragment : Fragment() {

    private lateinit var viewModel:CharacterListViewModel
    private lateinit var names: MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCharacterlistBinding>(inflater,
            R.layout.fragment_characterlist,container,false)

        val application = requireNotNull(this.activity).application
        val dataSource = HorrorDatabase.getInstance(application).horrorDatabaseDao

        var viewModelFactory = CharacterListViewModelFactory(dataSource,application)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(CharacterListViewModel::class.java)
        binding.setLifecycleOwner(this)
        names = mutableListOf()

        viewModel.characters.observe(this, Observer {
            names.clear()
            it.forEach { names.add(it.name) }
            handleClick(binding.allCharacterList)
        })

        return binding.root
    }

    private fun handleClick(layout: LinearLayout){
        layout.visibility = View.VISIBLE
        names.forEach {name->
            val button = Button(this.context)
            button.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
            button.setBackgroundColor(Color.TRANSPARENT)
            button.text = name
            button.setTextColor(Color.RED)
            button.setOnClickListener({ this.findNavController().navigate(
               CharacterListFragmentDirections.actionCharacterListFragmentToCharacterFragment(name)
            )})
            layout.addView(button)
        }
    }

}
