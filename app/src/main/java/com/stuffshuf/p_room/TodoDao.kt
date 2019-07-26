package com.stuffshuf.p_room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao{

    @Insert
    fun insertRow(todo: Todo)

    @Insert
    fun insertAll(todoList:ArrayList<Todo>)

    @Query("Select * FROM todo")
    fun getAllTodo():List<Todo>

    @Query("Select * FROM todo") // :task is a varible of Todo data class if we want to use any variable in parameter then use :
    fun getAllTodoWithDone():LiveData<Todo> //task:String is :task , String match :task from task in table


@Delete
fun delete(todo: Todo)
}