package com.marcuslundgren.habitreminder.data.habit

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "habits")
data class Habit (
        @ColumnInfo(name = "name") var name: String,
        @ColumnInfo(name = "time") var time: String,
        @ColumnInfo(name = "count") var count: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "habit_id") var habitId: Long = 0 // equal to zero?
}