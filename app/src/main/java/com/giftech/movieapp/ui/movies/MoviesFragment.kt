package com.giftech.movieapp.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.giftech.movieapp.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity!=null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MoviesViewModel::class.java]
            val listMovie = viewModel.getMovies()
            val moviesAdapter = MoviesAdapter()
            moviesAdapter.setListMovie(listMovie)

            with(binding.rvMovies){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = moviesAdapter
            }
        }
    }
}