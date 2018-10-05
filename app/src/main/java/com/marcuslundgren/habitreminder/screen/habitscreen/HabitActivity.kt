package com.marcuslundgren.habitreminder.screen.habitscreen

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.database.DatabaseUtils
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import com.marcuslundgren.habitreminder.R
import com.marcuslundgren.habitreminder.data.AppDatabase
import com.marcuslundgren.habitreminder.data.habit.Habit
import com.marcuslundgren.habitreminder.databinding.HabitActivityBinding
import com.marcuslundgren.habitreminder.utils.IO
import com.marcuslundgren.habitreminder.utils.UI
import kotlinx.android.synthetic.main.habit_activity.*

class HabitActivity : AppCompatActivity() {

    lateinit var viewModel : HabitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this, HabitViewModelFactory(
                this)
        ).get(HabitViewModel::class.java)

        viewModel.showDialog.observe(this, Observer { showDialog ->
            showDialog?.let {
                if(it) {
                    showAddDialog()
                }
            }
        })

        //databinding
        val binding: HabitActivityBinding = DataBindingUtil.setContentView(this, R.layout.habit_activity)
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)
        binding.executePendingBindings()

//        // Create and set the layout manager
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.VERTICAL

        // Set the adaptor
        val adapter = HabitAdapter(viewModel)
        recycler_view_habit.layoutManager = LinearLayoutManager(this)
        recycler_view_habit.adapter = adapter

        /*
        var checkBoxState = true

        checkBox.setOnClickListener {
            if(checkBoxState) {
                CompoundButtonCompat.setButtonTintList(checkBox, ColorStateList.valueOf(resources.getColor(R.color.checkBoxGreen)))
                checkBoxState = false
                return@setOnClickListener
            } else {
                CompoundButtonCompat.setButtonTintList(checkBox, ColorStateList.valueOf(resources.getColor(R.color.checkBoxOrange)))
                checkBoxState = true
                return@setOnClickListener
            }
        }
        */
    }

    private fun showAddDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add habit")

        val view = layoutInflater.inflate(R.layout.habit_create_dialog, null)
        builder.setView(view)

        val name = view.findViewById(R.id.name_dialog_textview) as TextView
        val time = view.findViewById(R.id.time_dialog_textview) as TextView

        builder.setPositiveButton(android.R.string.ok) {dialog, p ->
            viewModel.addHabit(Habit(name.text.toString(), time.text.toString(), "0"))
        }

        builder.show()
    }


}
