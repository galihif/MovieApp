package com.giftech.movieapp.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.giftech.movieapp.databinding.FragmentTvShowBinding
import com.giftech.movieapp.viewmodel.ViewModelFactory

class TvShowFragment : Fragment() {

    private lateinit var binding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvShowBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity!=null){
            val tvShowAdapter = TvShowAdapter()

            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            viewModel.getTvShow().observe(viewLifecycleOwner, {listTvRes ->
                tvShowAdapter.setListTvShow(listTvRes)
            })

            with(binding.rvTvshow){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

}