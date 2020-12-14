package com.example.sqlite_example.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.sqlite_example.model.entities.Course
import com.example.sqlite_example.model.entities.Mark

@Dao
interface MarkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mark: Mark)

    @Update
    suspend fun update(mark: Mark)

    @Delete
    suspend fun delete(mark: Mark)

    @Query("SELECT * FROM mark_table")
    fun getAllMarks():LiveData<List<Mark>>
}