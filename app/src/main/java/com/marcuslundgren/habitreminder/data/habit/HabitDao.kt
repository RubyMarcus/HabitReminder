package com.marcuslundgren.habitreminder.data.habit

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*


@Dao
interface HabitDao {
    @Insert
    fun insert(vararg habits: Habit)

    @Query("SELECT * FROM habits")
    fun get(): LiveData<List<Habit>>

    @Update
    fun update(vararg habits: Habit)

    @Delete
    fun delete(vararg habits: Habit)
}