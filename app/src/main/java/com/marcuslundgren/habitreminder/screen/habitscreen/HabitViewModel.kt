package com.marcuslundgren.habitreminder.screen.habitscreen

import android.app.AlertDialog
import android.arch.lifecycle.ViewModel
import android.content.res.ColorStateList
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v4.widget.CompoundButtonCompat
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import com.marcuslundgren.habitreminder.R
import com.marcuslundgren.habitreminder.data.AppDatabase
import com.marcuslundgren.habitreminder.data.habit.Habit
import com.marcuslundgren.habitreminder.data.habit.HabitDao
import com.marcuslundgren.habitreminder.data.habit.HabitRepository
import com.marcuslundgren.habitreminder.utils.IO
import com.marcuslundgren.habitreminder.utils.SingleLiveEvent
import com.marcuslundgren.habitreminder.utils.UI
import kotlinx.android.synthetic.main.habit_activity.view.*
import kotlinx.android.synthetic.main.habit_row.view.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

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

    fun updateHabit (habit: Habit) {
        IO.execute {
            repo.update(habit)
        }
    }

    fun onCheckBoxClicked (view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            if(checked) {
                //finishActivity(view)
                CompoundButtonCompat.setButtonTintList(view.checkBox, ColorStateList.valueOf(ContextCompat.getColor(view.context, R.color.checkBoxGreen)))
            } else {
                CompoundButtonCompat.setButtonTintList(view.checkBox, ColorStateList.valueOf(ContextCompat.getColor(view.context, R.color.checkBoxOrange)))
            }
        }
    }

    /*
    fun finishActivity (view: View) {
        val builder = AlertDialog.Builder(view.context)

        builder.setCancelable(false)

        // Set the alert dialog title
        builder.setTitle("Finished activity")

        // Display a message on alert dialog
        builder.setMessage("Are you sure that you finished this activity?")

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton("YES"){dialog, which ->
            // Do something when user press the positive button
            view.checkBox.isEnabled = false

            println(view.checkBox.rootView.habit_row_name_textview.text)
            val name = view.checkBox.rootView.habit_row_name_textview.text.toString()
            val time = view.checkBox.rootView.habit_row_time_textview.text.toString()
            val streak = view.checkBox.rootView.habit_row_streak_count_textview.text.toString()

            val sdf = SimpleDateFormat("dd/M/yyyy")
            val currentDate = sdf.format(Date())
            System.out.println(" C DATE is  "+currentDate)

            updateHabit(Habit("Bajs",time,streak,true, currentDate))
        }

        // Display a negative button on alert dialog
        builder.setNegativeButton("No"){dialog,which ->
            view.checkBox.isChecked = false
            CompoundButtonCompat.setButtonTintList(view.checkBox, ColorStateList.valueOf(ContextCompat.getColor(view.context, R.color.checkBoxOrange)))
        }

        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()
    }
    */

    fun showCreateDialog () {
        showDialog.postValue(true)
    }

}