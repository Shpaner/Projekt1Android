package com.example.sqlite_example.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.sqlite_example.model.databases.MyDatabase
import com.example.sqlite_example.model.entities.Course
import com.example.sqlite_example.model.repositories.CourseRepository
import kotlinx.coroutines.launch

class CourseViewModel(application: Application): AndroidViewModel(application) {

    val courses: LiveData<List<Course>>
    private val courseRepository: CourseRepository

    init{
        courses = MyDatabase.getDatabase(application).courseDao().getAllCourses()
        courseRepository = CourseRepository(MyDatabase.getDatabase(application).courseDao())
    }

    fun addCourse(name: String)
    {
        //musi byc wykonane asynchronicznie
        viewModelScope.launch {
            courseRepository.add(Course(courseId = 0, courseName = name))
        }
    }

    fun deleteCourse(course: Course)
    {
        viewModelScope.launch {
            courseRepository.delete(course)
        }

    }


}