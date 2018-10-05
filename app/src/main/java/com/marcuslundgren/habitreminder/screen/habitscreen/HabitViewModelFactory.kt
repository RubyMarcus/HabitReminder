package com.marcuslundgren.habitreminder.screen.habitscreen

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.marcuslundgren.habitreminder.data.AppDatabase
import com.marcuslundgren.habitreminder.data.habit.MovieRepositoryRoom

@Suppress("UNCHECKED_CAST")
class HabitViewModelFactory(val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HabitViewModel(MovieRepositoryRoom(AppDatabase.getInstance(context)?.habitDao!!)) as T
    }
}