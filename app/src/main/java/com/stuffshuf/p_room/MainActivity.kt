package com.stuffshuf.p_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var list= arrayListOf<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db =
            Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "todo.db"
            ).allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()



        list= db.todoDao().getAllTodo() as ArrayList<Todo>

        val adapter = TodoAdapter(list)
        lvTodolist.adapter=adapter

adapter.listItemClickListener=object:ListItemClickListener{
    override fun lisitemClick(task: Todo, position: Int) {
        db.todoDao().delete(task)
    }

}
        lvTodolist.adapter=adapter


        btnAdd.setOnClickListener {

            db.todoDao().insertRow(
                Todo(
                    task = etNewItem.text.toString(),
                    status = false
                )
            )

            list = db.todoDao().getAllTodo() as ArrayList<Todo>
            adapter.updateTasks(list)


        }


    }
}



