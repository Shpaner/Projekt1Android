package com.example.sqlite_example.model.entities.relations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import com.example.sqlite_example.model.entities.Course
import com.example.sqlite_example.model.entities.Mark
import com.example.sqlite_example.model.entities.Student

//data class CourseStudentMark(
//    @Embedded
//    var course: Course,
//
//    @Relation(
//        parentColumn = "courseName",
//        entityColumn = "courseName",
//    )
//    val student: Student
//)


data class CourseStudent(
    @Embedded val course: Course,

    @Relation(
        parentColumn = "courseId",
        entityColumn = "studentId",
        associateBy = Junction(CourseStudentCrossRef::class)
    )
    val students: List<Student>
)

data class StudentMark(
    @Embedded val student: Student,

    @Relation(
        parentColumn = "studentId",
        entityColumn = "markId",
        associateBy = Junction(StudentMarkCrossRef::class)
    )
    val marks: List<Mark>
)