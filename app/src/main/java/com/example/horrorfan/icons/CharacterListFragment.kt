package com.example.horrorfan.icons


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.horrorfan.R
import com.example.horrorfan.databinding.FragmentCharacterlistBinding

/**
 * A simple [Fragment] subclass.
 */
class CharacterListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCharacterlistBinding>(inflater,
            R.layout.fragment_characterlist,container,false)
        return binding.root
    }


}
