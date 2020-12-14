package com.example.sqlite_example.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.sqlite_example.model.entities.Student

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(student: Student)

    @Update
    suspend fun update(student: Student)

    @Delete
    suspend fun delete(student: Student)

    @Query("SELECT * FROM student_table")
    fun getAllStudents():LiveData<List<Student>>
}