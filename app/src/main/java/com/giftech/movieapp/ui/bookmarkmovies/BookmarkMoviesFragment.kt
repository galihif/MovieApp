package com.giftech.movieapp.ui.bookmarkmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.giftech.movieapp.databinding.FragmentBookmarkMoviesBinding
import com.giftech.movieapp.viewmodel.ViewModelFactory

class BookmarkMoviesFragment : Fragment() {

    private lateinit var binding: FragmentBookmarkMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBookmarkMoviesBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            val factory = ViewModelFactory.getInstance(requireContext())
            val viewModel = ViewModelProvider(this, factory)[BookmarkMoviesViewModel::class.java]

            val bookmarkMoviesAdapter = BookmarkMoviesAdapter()

            viewModel.getBookmarkedMovies().observe(viewLifecycleOwner, {movieRes ->
                if(movieRes != null){
                    bookmarkMoviesAdapter.setList(movieRes)
                }
            })

            with(binding.rvBookmarkmovies){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = bookmarkMoviesAdapter
            }
        }
    }
}