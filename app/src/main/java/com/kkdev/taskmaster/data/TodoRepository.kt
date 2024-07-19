package com.kkdev.taskmaster.data

import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    suspend fun insertTask(todo: Todo)

    suspend fun deleteTask(todo: Todo)

    suspend fun getTaskById(id: Int): Todo?

    fun getTaskByStatus(): Flow<List<Todo>>

    fun getPinnedTasks(): Flow<List<Todo>>

    fun getTasks(): Flow<List<Todo>>
}