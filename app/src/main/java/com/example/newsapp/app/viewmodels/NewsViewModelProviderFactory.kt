package com.example.newsapp.app.viewmodels

import NewsViewModel
import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import com.example.newsapp.app.repository.NewsRepository

class NewsViewModelProviderFactory(
    val app : Application,
    private val newsRepository: NewsRepository
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(app, newsRepository) as T
    }

}
