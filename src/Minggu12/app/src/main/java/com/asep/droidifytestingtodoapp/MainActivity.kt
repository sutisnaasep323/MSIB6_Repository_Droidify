package com.asep.droidifytestingtodoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.asep.droidifytestingtodoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var todoViewModel: TodoViewModel
    private lateinit var adapter: TodoAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        adapter = TodoAdapter()
        binding.todoRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.todoRecyclerView.adapter = adapter

        binding.addTodoButton.setOnClickListener {
            val todoText = binding.todoEditText.text.toString()
            if (todoText.isNotEmpty()) {
                todoViewModel.addTodo(todoText)
                binding.todoEditText.text.clear()
            }
        }

        todoViewModel.todos.observe(this) { todos ->
            adapter.submitList(todos)
        }
    }
}