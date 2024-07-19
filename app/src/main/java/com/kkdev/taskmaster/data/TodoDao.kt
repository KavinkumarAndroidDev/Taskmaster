package com.kkdev.taskmaster.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(todo: Todo)

    @Delete
    suspend fun deleteTask(todo: Todo)

    @Query("SELECT *FROM todo WHERE id = :id")
    suspend fun getTaskById(id: Int): Todo?

    @Query("SELECT * FROM todo WHERE isDone = 0")
    fun getTaskByStatus(): Flow<List<Todo>>

    @Query("SELECT * FROM todo WHERE isPinned = 1")
    fun getPinnedTasks(): Flow<List<Todo>>

    @Query("SELECT * FROM todo")
    fun getTasks(): Flow<List<Todo>>

}