package com.giftech.movieapp.ui.tvshow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.giftech.movieapp.databinding.FragmentTvShowBinding
import com.giftech.movieapp.viewmodel.ViewModelFactory
import com.giftech.movieapp.vo.Status

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

            val factory = ViewModelFactory.getInstance(requireContext())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            viewModel.getTvShow().observe(viewLifecycleOwner, {listTvRes ->
                if(listTvRes != null){
                    when(listTvRes.status){
                        Status.SUCCESS -> {
//                            tvShowAdapter.setListTvShow(listTvRes.data!!)
                            tvShowAdapter.submitList(listTvRes.data)
                            val listData = listTvRes.data
                            for (i in listData!!){
                                Log.d("GALIH", i.title.toString())
                            }
                        }
                    }
                }
            })

            with(binding.rvTvshow){
                layoutManager = LinearLayoutManager(context)
                adapter = tvShowAdapter
            }
        }
    }

}