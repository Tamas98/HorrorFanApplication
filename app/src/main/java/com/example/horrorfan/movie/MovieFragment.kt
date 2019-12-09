package com.example.horrorfan.movie


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.horrorfan.R
import com.example.horrorfan.databinding.FragmentMovieBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    private lateinit var movieViewModel: MovieViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMovieBinding>(inflater,
            R.layout.fragment_movie,container,false)
        Timber.i("MovieFragment called MovieViewModel.of")
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        val args = MovieFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context, "Searched movie name: ${args.movieName}", Toast.LENGTH_LONG).show()
        return binding.root
    }


}
