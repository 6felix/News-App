package com.example.newsapp.app.viewmodels.models

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)