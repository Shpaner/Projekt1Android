package com.example.sqlite_example.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.sqlite_example.model.entities.Course
import com.example.sqlite_example.model.entities.relations.CourseStudent
import com.example.sqlite_example.model.entities.relations.StudentMark


@Dao
interface CourseStudentDao {

    @Transaction
    @Query("SELECT * FROM course_table")
    fun getCoursesWithStudents(): List<CourseStudent>
}

@Dao
interface StudentMarkDao {

    @Transaction
    @Query("SELECT * FROM student_table")
    fun getStudentsWithMarks(): List<StudentMark>
}