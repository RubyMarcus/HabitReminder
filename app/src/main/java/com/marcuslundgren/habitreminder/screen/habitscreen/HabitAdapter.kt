package com.marcuslundgren.habitreminder.screen.habitscreen

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.marcuslundgren.habitreminder.data.habit.Habit
import java.util.ArrayList

class HabitAdapter(val viewModel :HabitViewModel) : RecyclerView.Adapter<HabitViewHolder>() {

    private var habits: List<Habit> = ArrayList()

    fun setHabits(habits:List<Habit>) {
        this.habits = habits
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder = HabitViewHolder.newInstance(parent, viewModel)

    override fun getItemCount(): Int = habits.size

    override fun onBindViewHolder(holder : HabitViewHolder, position : Int) = holder.bind(habits[position])

}