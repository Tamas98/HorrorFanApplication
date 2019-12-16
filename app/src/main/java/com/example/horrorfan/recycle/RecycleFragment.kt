package com.example.horrorfan.recycle


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.horrorfan.R
import com.example.horrorfan.database.HorrorDatabase
import com.example.horrorfan.database.Movies
import com.example.horrorfan.databinding.FragmentRecycleBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass.
 */
class RecycleFragment : Fragment() {

    private lateinit var viewModel: RecycleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     val binding = DataBindingUtil.inflate<FragmentRecycleBinding>(inflater,R.layout.fragment_recycle,container,false)

        val application = requireNotNull(this.activity).application
        val dataSource = HorrorDatabase.getInstance(application).horrorDatabaseDao

        var viewModelFactory = RecycleViewModelFactory(dataSource,application)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(RecycleViewModel::class.java)

        binding.setLifecycleOwner(this)

        val adapter = TextMovieAdapter(MovieListener { movieId ->
            Toast.makeText(context, "${movieId}", Toast.LENGTH_LONG).show()
        })

        binding.movieData.adapter = adapter

        viewModel.movies.observe(this, Observer {
            it?.let {
                adapter.addHeaderAndSubmitList(it)
            }
        })

        return binding.root
    }

}
