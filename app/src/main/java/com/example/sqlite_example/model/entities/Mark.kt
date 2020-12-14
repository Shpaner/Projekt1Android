package com.example.sqlite_example.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "mark_table")
data class Mark(
    @PrimaryKey val markId: Int,
    var mark: Double,
    var note: String
)