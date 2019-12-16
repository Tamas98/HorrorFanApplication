package com.example.horrorfan.webservice


import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModelProviders
import com.example.horrorfan.R
import com.example.horrorfan.database.HorrorDatabase
import com.example.horrorfan.databinding.FragmentPostsBinding

/**
 * A simple [Fragment] subclass.
 */
class PostsFragment : Fragment() {

    private lateinit var viewModel: PostsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPostsBinding>(inflater,
            R.layout.fragment_posts,container,false)
        val application = requireNotNull(this.activity).application
        val dataSource = HorrorDatabase.getInstance(application).horrorDatabaseDao

        val viewModelFactory = PostsViewModelFactory(dataSource,application)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(PostsViewModel::class.java)
        binding.setLifecycleOwner(this)

        viewModel.response.observe(this, Observer {
            binding.response.text = formatPosts(it)
        })

        var data: String = Transformations.map(viewModel.response){
            formatPosts(it)
        }

        return binding.root
    }

    private fun formatPosts(posts:List<Post>) : Spanned {
        val sb = StringBuilder()
        sb.apply{
            posts.forEach{
                append("<br>")
                append(it.title)
            }
            append("<br>")
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
        } else {
            return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
        }

    }
}
