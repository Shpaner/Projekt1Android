package com.example.sqlite_example.model.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sqlite_example.model.dao.CourseDao
import com.example.sqlite_example.model.dao.MarkDao
import com.example.sqlite_example.model.dao.StudentDao
import com.example.sqlite_example.model.entities.Course
import com.example.sqlite_example.model.entities.Mark
import com.example.sqlite_example.model.entities.Student

@Database(entities = [Student::class, Course::class, Mark::class],version = 1,exportSchema = false)
abstract class MyDatabase:RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun courseDao(): CourseDao
    abstract fun markDao(): MarkDao

    companion object{
        @Volatile
        private var INSTANCE: MyDatabase?=null

        fun getDatabase(context: Context): MyDatabase {
            val tempInstance = INSTANCE

            if(tempInstance!=null)
                return tempInstance
            else
                synchronized(this)
                {
                    val instance= Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "my_database"
                    ).build()
                    INSTANCE = instance
                    return instance

                }


        }


    }
}