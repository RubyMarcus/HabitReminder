package com.marcuslundgren.habitreminder.screen.mainscreen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.marcuslundgren.habitreminder.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.habit_row)

    }
}
