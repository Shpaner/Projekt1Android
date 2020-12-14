package com.example.sqlite_example.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.RowId

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true) val studentId: Int,
    var firstName: String,
    var lastName: String
)