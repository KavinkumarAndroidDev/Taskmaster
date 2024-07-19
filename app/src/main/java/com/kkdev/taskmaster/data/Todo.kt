package com.kkdev.taskmaster.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "todo")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val description: String?,
    val isDone: Boolean = false,
    val isPinned: Boolean = false,
    val reminderTime: Long?
)