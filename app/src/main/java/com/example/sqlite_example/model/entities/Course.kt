package com.example.sqlite_example.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_table")
data class Course(
    @PrimaryKey val courseId: Int,
    val courseName:String
)