package com.kkdev.taskmaster.data

import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(
    private val dao: TodoDao
): TodoRepository {
    override suspend fun insertTask(todo: Todo) {
        dao.insertTask(todo)
    }

    override suspend fun deleteTask(todo: Todo) {
        dao.deleteTask(todo)
    }

    override suspend fun getTaskById(id: Int): Todo? {
        return dao.getTaskById(id)
    }

    override fun getTaskByStatus(): Flow<List<Todo>> {
        return dao.getTaskByStatus()
    }

    override fun getPinnedTasks(): Flow<List<Todo>> {
        return dao.getPinnedTasks()
    }

    override fun getTasks(): Flow<List<Todo>> {
        return dao.getTasks()
    }

}