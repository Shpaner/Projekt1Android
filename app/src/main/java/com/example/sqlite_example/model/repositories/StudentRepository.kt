package com.example.sqlite_example.model.repositories

import androidx.lifecycle.LiveData
import com.example.sqlite_example.model.entities.Student
import com.example.sqlite_example.model.dao.StudentDao

class StudentRepository(private val studentDao: StudentDao) {
    val readAll:LiveData<List<Student>> = studentDao.getAllStudents()

    suspend fun add(student: Student) {
        studentDao.insert(student)
    }

    suspend fun update(student: Student) {
        studentDao.update(student)
    }

    suspend fun delete(student: Student) = studentDao.delete(student)

}