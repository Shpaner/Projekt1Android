package com.example.sqlite_example.model.repositories

import androidx.lifecycle.LiveData
import com.example.sqlite_example.model.dao.MarkDao
import com.example.sqlite_example.model.entities.Mark

class MarkRepository(private val markDao: MarkDao) {
    val readAll: LiveData<List<Mark>> = markDao.getAllMarks()

    suspend fun add(mark: Mark) {
        markDao.insert(mark)
    }

    suspend fun delete(mark: Mark) = markDao.delete(mark)

}