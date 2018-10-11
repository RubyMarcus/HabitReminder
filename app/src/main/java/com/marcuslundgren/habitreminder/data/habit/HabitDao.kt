package com.marcuslundgren.habitreminder.data.habit

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.support.design.circularreveal.CircularRevealHelper


@Dao
interface HabitDao {
    @Insert
    fun insert(vararg habits: Habit)

    @Query("SELECT * FROM habits")
    fun get(): LiveData<List<Habit>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg habit: Habit)

    @Delete
    fun delete(vararg habits: Habit)
}