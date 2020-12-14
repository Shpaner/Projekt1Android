package com.example.sqlite_example.model.repositories

import androidx.lifecycle.LiveData
import com.example.sqlite_example.model.dao.CourseDao
import com.example.sqlite_example.model.entities.Course

class CourseRepository(private val courseDao: CourseDao) {
    val readAll:LiveData<List<Course>> = courseDao.getAllCourses()

    suspend fun add(course: Course) {
        courseDao.insert(course)
    }

    suspend fun delete(course: Course) = courseDao.delete(course)

}