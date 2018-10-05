package com.marcuslundgren.habitreminder.screen.habitscreen

import android.arch.lifecycle.ViewModel
import com.marcuslundgren.habitreminder.data.AppDatabase
import com.marcuslundgren.habitreminder.data.habit.Habit
import com.marcuslundgren.habitreminder.data.habit.HabitDao
import com.marcuslundgren.habitreminder.data.habit.HabitRepository
import com.marcuslundgren.habitreminder.utils.IO
import com.marcuslundgren.habitreminder.utils.SingleLiveEvent
import com.marcuslundgren.habitreminder.utils.UI

class HabitViewModel(val repo: HabitRepository) : ViewModel() {

    val habitsLiveData = repo.read()

    val showDialog = SingleLiveEvent<Boolean>()

    fun addHabit (habit: Habit) {
        IO.execute{
            repo.create(habit)
        }
    }

    fun deleteHabit (habit: Habit) {
        IO.execute{
            repo.delete(habit)
        }
    }

    fun showCreateDialog () {
        showDialog.postValue(true)
    }

}