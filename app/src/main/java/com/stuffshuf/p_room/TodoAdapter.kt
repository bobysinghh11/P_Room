package com.stuffshuf.p_room

import android.R
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TodoAdapter(var tasks:ArrayList<Todo>) :BaseAdapter() {

    var listItemClickListener:ListItemClickListener?=null

    fun updateTasks(newTasks: ArrayList<Todo>) {
        tasks.clear()
        tasks.addAll(newTasks)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val li=parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view=li.inflate(android.R.layout.simple_list_item_1, parent, false)

        view.findViewById<TextView>(android.R.id.text1).text=getItem(position).task

        if (getItem(position).status) {
            view.findViewById<TextView>(android.R.id.text1).setTextColor(Color.GRAY)
        }

        view.setOnClickListener {

            listItemClickListener?.lisitemClick(getItem(position), position)
        }
        return view
    }

    override fun getItem(position: Int): Todo {
        return tasks[position]
    }

    override fun getItemId(position: Int): Long {
     return 0
    }

    override fun getCount(): Int {
         return tasks.size
    }
}