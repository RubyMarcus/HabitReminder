package com.marcuslundgren.habitreminder.data.habit

import android.arch.lifecycle.LiveData

interface HabitRepository {
    // Crud
    fun create(vararg habit: Habit)

    fun read(): LiveData<List<Habit>>

    fun update(vararg habit: Habit)

    fun delete(vararg habit: Habit)
}