package com.example.newsapp.app.ui

/**
 *  This News App covers an Introduction into Retrofit, Room, Glide, Coroutines and
 *  Android Navigation and MVVM.
 */

import NewsViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityNewsBinding
import com.example.newsapp.app.db.ArticleDataBase
import com.example.newsapp.app.repository.NewsRepository
import com.example.newsapp.app.viewmodels.NewsViewModelProviderFactory


class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //newsRepository
        val newsRepository = NewsRepository(ArticleDataBase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory)[NewsViewModel::class.java]

        //nav Host to handle fragments
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHost) as NavHostFragment
        val navController = navHostFragment.findNavController()

        binding.bottomNavView.setupWithNavController(navController)

    }
}