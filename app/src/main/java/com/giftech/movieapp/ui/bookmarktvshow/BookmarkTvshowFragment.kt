package com.giftech.movieapp.ui.bookmarktvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.giftech.movieapp.databinding.FragmentBookmarkTvshowBinding
import com.giftech.movieapp.viewmodel.ViewModelFactory

class BookmarkTvshowFragment : Fragment() {

    private lateinit var binding: FragmentBookmarkTvshowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBookmarkTvshowBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            val factory = ViewModelFactory.getInstance(requireContext())
            val viewModel = ViewModelProvider(this, factory)[BookmarkTvshowViewmodel::class.java]

            val bookmarkTvshowAdapter = BookmarkTvshowAdapter()

            viewModel.getBookmarkedTvshow().observe(viewLifecycleOwner, {tvRes ->
                if(tvRes!=null){
                    bookmarkTvshowAdapter.setList(tvRes)
                }
            })

            with(binding.rvBookmarktv){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = bookmarkTvshowAdapter
            }
        }
    }

}