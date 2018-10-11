package com.marcuslundgren.habitreminder.data.habit

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import java.util.*
import javax.annotation.Nonnull

@Entity(tableName = "habits")
data class Habit (
        @ColumnInfo(name = "name") var name: String,
        @ColumnInfo(name = "time") var time: String,
        @ColumnInfo(name = "count") var count: String,
        @ColumnInfo(name = "isChecked") var isChecked : Boolean,
        @ColumnInfo(name = "dateLastChecked") var dateLastChecked : String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "habit_id") var habitId: Long = 0
}
