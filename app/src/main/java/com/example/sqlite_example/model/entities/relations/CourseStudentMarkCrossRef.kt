package com.example.sqlite_example.model.entities.relations

import androidx.room.Entity

@Entity(primaryKeys = ["courseId", "studentId"])
data class CourseStudentCrossRef(
    val courseId: Int,
    val studentId: Int
)

@Entity(primaryKeys = ["studentId", "markId"])
data class StudentMarkCrossRef(
    val studentId: Int,
    val markId: Int
)

