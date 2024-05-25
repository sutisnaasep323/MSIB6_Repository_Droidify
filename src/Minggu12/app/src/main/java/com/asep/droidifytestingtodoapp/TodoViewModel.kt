package com.asep.droidifytestingtodoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    private val _todos = MutableLiveData<MutableList<String>>(mutableListOf())
    val todos: LiveData<MutableList<String>> = _todos

    fun addTodo(todo: String) {
        val currentList = _todos.value ?: mutableListOf()
        currentList.add(todo)
        _todos.value = currentList
    }
}