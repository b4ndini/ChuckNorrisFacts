package com.example.chucknorrisfacts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import com.example.chucknorrisfacts.R
import com.example.chucknorrisfacts.databinding.ActivitySearchBinding
import com.example.chucknorrisfacts.viewmodel.SearchViewModel

class SearchActivity : AppCompatActivity() {

    private lateinit var viewModel: SearchViewModel
    lateinit var searchView: SearchView
    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

                return true
            }
        })

    }
}