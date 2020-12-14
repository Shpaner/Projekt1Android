package com.example.sqlite_example.view_model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlite_example.R
import com.example.sqlite_example.model.entities.Student

class StudentListAdapter(var students: LiveData<List<Student>>):RecyclerView.Adapter<StudentListAdapter.StudentHolder>() {

    inner class StudentHolder(view: View):RecyclerView.ViewHolder(view)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
         val view=LayoutInflater.from(parent.context)
                          .inflate(R.layout.student_list_one_row,parent,false)
        return StudentHolder(view)
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        var textViewID= holder.itemView.findViewById<TextView>(R.id.textViewID)
        var textViewFirstName= holder.itemView.findViewById<TextView>(R.id.textViewFirstName)
        var textViewLastName= holder.itemView.findViewById<TextView>(R.id.textViewLastName)

        textViewID.text= students.value?.get(position)?.studentId.toString()
        textViewFirstName.text=students.value?.get(position)?.firstName
        textViewLastName.text=students.value?.get(position)?.lastName
    }

    override fun getItemCount(): Int {
        return students.value?.size?:0
    }

}