package com.example.sqlite_example.view_model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlite_example.R
import com.example.sqlite_example.model.entities.Course
import kotlinx.android.synthetic.main.course_list_one_row.view.*

class CourseListAdapter(var courses: LiveData<List<Course>>, var clickListener: CourseListAdapter.OnCourseClickListener):
    RecyclerView.Adapter<CourseListAdapter.CourseHolder>() {

    inner class CourseHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.course_list_one_row,parent,false)

        return CourseHolder(view)
    }

    override fun onBindViewHolder(holder: CourseHolder, position: Int) {
        var textViewID= holder.itemView.findViewById<TextView>(R.id.textViewID)
        var textViewFirstName= holder.itemView.findViewById<TextView>(R.id.textViewFirstName)
        var deleteButton = holder.itemView.deleteButton

        textViewID.text= courses.value?.get(position)?.courseId.toString()

        textViewFirstName.text= courses.value?.get(position)?.courseName.toString()

        deleteButton.setOnClickListener{
            clickListener.onCourseClick(position,courses.value?.get(position))
        }

    }


    interface OnCourseClickListener{
        fun onCourseClick(position: Int,model: Course?)
    }

    override fun getItemCount(): Int {
        return courses.value?.size?:0
    }

}