package com.marcuslundgren.habitreminder.screen.habitscreen

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.marcuslundgren.habitreminder.R
import com.marcuslundgren.habitreminder.data.habit.Habit
import com.marcuslundgren.habitreminder.databinding.HabitRowBinding

class HabitViewHolder (val binding : HabitRowBinding) :RecyclerView.ViewHolder(binding.root) {

    fun bind (habit : Habit) {
        binding.habit = habit
    }

    companion object {
        fun newInstance (parent : ViewGroup, viewModel: HabitViewModel) : HabitViewHolder {
            val binding : HabitRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                    R.layout.habit_row, parent, false)

            binding.viewModel = viewModel
            binding.executePendingBindings()

            return HabitViewHolder (
                    binding
            )
        }
    }
}