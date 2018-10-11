package com.marcuslundgren.habitreminder.screen.habitscreen

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.database.DatabaseUtils
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.widget.TextView
import android.widget.Toast
import com.marcuslundgren.habitreminder.R
import com.marcuslundgren.habitreminder.data.AppDatabase
import com.marcuslundgren.habitreminder.data.habit.Habit
import com.marcuslundgren.habitreminder.databinding.HabitActivityBinding
import com.marcuslundgren.habitreminder.utils.IO
import com.marcuslundgren.habitreminder.utils.UI
import kotlinx.android.synthetic.main.habit_activity.*
import java.util.*

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

        //Databinding
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
    }

    private fun showAddDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add habit")

        val view = layoutInflater.inflate(R.layout.habit_create_dialog, null)
        builder.setView(view)

        val name = view.findViewById(R.id.name_dialog_textview) as TextView
        val time = view.findViewById(R.id.time_dialog_textview) as TextView

        builder.setPositiveButton(android.R.string.ok) {dialog, p ->
            if(name.text.toString() == "" || time.text.toString() == "") {
                Toast.makeText(applicationContext, "Fields can't be empty!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            } else {
                viewModel.addHabit(Habit(name.text.toString(), time.text.toString(), "0", false, ""))
            }
        }

        builder.show()
    }

    
}

