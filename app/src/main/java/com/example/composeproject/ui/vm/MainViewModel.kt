package com.example.composeproject.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeproject.data.Repository
import com.example.composeproject.model.Article
import com.example.composeproject.model.History
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var repository : Repository = Repository()

    private var _articles = MutableStateFlow(ArrayList<Article>())
    var articles = _articles.asStateFlow()

    private var _article = MutableStateFlow(Article())
    var article = _article.asStateFlow()

    private var _histories = MutableStateFlow(ArrayList<History>())
    var histories = _histories.asStateFlow()

    init {
        fetchHistories()
        loadNews()
    }

    private fun loadNews() {
        viewModelScope.launch {
            repository.loadNews()
                .collect { response ->
                    _articles.value =  (response.articles as ArrayList<Article>)
                }
        }
    }

    private fun fetchHistories() {
        viewModelScope.launch {
            repository.fetchHistories()
                .collect {
                    _histories.value = it as ArrayList<History>
                }
        }
    }

    fun setArticle(article: Article) {
        _article.value = article
    }

}