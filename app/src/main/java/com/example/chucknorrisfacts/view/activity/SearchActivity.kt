package com.example.chucknorrisfacts.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chucknorrisfacts.R
import com.example.chucknorrisfacts.databinding.ActivitySearchBinding
import com.example.chucknorrisfacts.model.Search
import com.example.chucknorrisfacts.view.adapter.SearchAdapter
import com.example.chucknorrisfacts.viewmodel.SearchViewModel

class SearchActivity : AppCompatActivity() {

    private lateinit var viewModel: SearchViewModel
    lateinit var searchView: SearchView
    private lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        viewModel.factLiveData.observe(this, {

            it?.let{
                updateUI(it)
        }})

        viewModel.errorMsgLiveData.observe(this, {
            it?.let{
                binding.tvErrorMsg.text = it
                binding.tvErrorMsg.visibility = View.VISIBLE
            }
        })
    }

    private fun updateUI(it: Search) {
        binding.tvErrorMsg.isVisible = false
        binding.rvChuckFacts.apply {
            layoutManager = LinearLayoutManager(this@SearchActivity)
            adapter = SearchAdapter(it.result)
            visibility = View.VISIBLE
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        searchView = menu?.findItem(R.id.searchView)?.actionView as SearchView
        setupSearch(searchView)
        return true
    }


    private fun setupSearch(searchView: SearchView) {

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean { return true }

            override fun onQueryTextChange(query: String?): Boolean {
                binding.tvErrorMsg.visibility = View.INVISIBLE
                binding.rvChuckFacts.visibility = View.INVISIBLE //talvez tirar
                query?.let{
                    if(it.length >= 3)
                    {viewModel.setQuery(query ?: "")}
                }


                    return true
            }
        })

    }

}