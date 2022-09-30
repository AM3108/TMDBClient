package com.atul.tmdbclient.presentation.tv

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.atul.tmdbclient.R
import com.atul.tmdbclient.databinding.FragmentTvBinding
import com.atul.tmdbclient.presentation.artist.ArtistAdapter
import com.atul.tmdbclient.presentation.artist.ArtistViewModel
import com.atul.tmdbclient.presentation.di.Injector
import com.atul.tmdbclient.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class TvFragment : Fragment() {
    @Inject
    lateinit var factory: TvViewModelFactory
    private lateinit var tvViewModel: TvViewModel
    private lateinit var binding: FragmentTvBinding
    private lateinit var adapter: TvAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tv, container, false)

        (requireActivity().application as Injector).createTvShowSubComponent().inject(this)
        tvViewModel = ViewModelProvider(this, factory)[TvViewModel::class.java]
        initRecyclerView()
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun initRecyclerView(){
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = TvAdapter()
        binding.tvShowRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvViewModel.getTvShows()
        responseLiveData.observe(requireActivity(), Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }else{
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(requireActivity().applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //  val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateTvShow()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateTvShow(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val response = tvViewModel.updateTvShows()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }else{
                binding.tvShowProgressBar.visibility = View.GONE
            }
        })
    }

}