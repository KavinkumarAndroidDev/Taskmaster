package com.kkdev.taskmaster.viemodel

import androidx.lifecycle.ViewModel
import com.kkdev.taskmaster.data.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoListViewmodel @Inject constructor(
    private val repository: TodoRepository
): ViewModel() {
}