package com.marcuslundgren.habitreminder.utils

import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.marcuslundgren.habitreminder.data.habit.Habit
import com.marcuslundgren.habitreminder.screen.habitscreen.HabitAdapter

@BindingAdapter("habits")
fun setHabitsAttr(recyclerView : RecyclerView, habits:List<Habit>?) {
    habits?.let { habitList  ->
        val adapter = recyclerView.adapter as HabitAdapter?
        adapter?.apply {
            setHabits(habitList)
        }
    }
}