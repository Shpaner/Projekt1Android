package com.example.sqlite_example.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.sqlite_example.model.databases.MyDatabase
import com.example.sqlite_example.model.entities.Student
import com.example.sqlite_example.model.repositories.StudentRepository
import kotlinx.coroutines.launch

class UsersViewModel(application: Application): AndroidViewModel(application) {

    val students:LiveData<List<Student>>
    private val studentRepository:StudentRepository

    init{
            students= MyDatabase.getDatabase(application).studentDao().getAllStudents()
            studentRepository= StudentRepository(MyDatabase.getDatabase(application).studentDao())
        }

    fun addStudent(firstName:String, lastName:String)
    {
        //musi byc wykonane asynchronicznie
        viewModelScope.launch {
            studentRepository.add(
                Student(
                    firstName = firstName,
                    lastName = lastName,
                    studentId = 0
                )
            )
        }
    }

    fun deleteStudent(student: Student)
    {
        viewModelScope.launch {
            studentRepository.delete(student)
        }

    }


}