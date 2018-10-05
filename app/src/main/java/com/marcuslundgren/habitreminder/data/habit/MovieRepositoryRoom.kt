package com.marcuslundgren.habitreminder.data.habit

import android.arch.lifecycle.LiveData

class MovieRepositoryRoom(val habitDao: HabitDao) : HabitRepository {

    override fun create(vararg habit: Habit) = habitDao.insert(*habit)

    override fun read(): LiveData<List<Habit>> = habitDao.get()

    override fun update(vararg habit: Habit) = habitDao.update(*habit)

    override fun delete(vararg habit: Habit) = habitDao.delete(*habit)
}