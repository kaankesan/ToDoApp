package com.kaankesan.todoapp.repositories

import com.kaankesan.todoapp.data.modells.ToDoDao
import com.kaankesan.todoapp.data.modells.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {

    val getAllTasks: Flow<List<ToDoTask>> =toDoDao.getAllTasks()
    val sortByLowPriority: Flow<List<ToDoTask>> = toDoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<ToDoTask>> = toDoDao.sortByHighPriority()

    fun getSelectedTasks(taskId:Int):Flow<ToDoTask>{
        return toDoDao.getSelectedTask(taskId = taskId)
    }

    suspend fun addTasks(toDoTask:ToDoTask){
        toDoDao.addTask(ToDoTask = toDoTask)
    }

    suspend fun updateTasks(toDoTask: ToDoTask){
        toDoDao.updateTask(ToDoTask = toDoTask)
    }

    suspend fun deleteTasks(toDoTask: ToDoTask){
        toDoDao.deleteTask(toDoTask = toDoTask)
    }

    suspend fun deleteAllTasks(toDoTask: ToDoTask){
        toDoDao.deleteAllTasks(toDoTask = toDoTask )
    }

    fun searchDatabase(searchQuery:String):Flow<List<ToDoTask>>{
        return toDoDao.searchDatabase(searchQuery = searchQuery)
    }

}