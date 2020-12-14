package com.example.sqlite_example.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.sqlite_example.model.entities.Course

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(course: Course)

    @Update
    suspend fun update(course: Course)

    @Delete
    suspend fun delete(course: Course)

    @Query("SELECT * FROM course_table")
    fun getAllCourses():LiveData<List<Course>>
}