package com.marcuslundgren.habitreminder.screen.splashscreen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.marcuslundgren.habitreminder.screen.habitscreen.HabitActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, HabitActivity::class.java)
        startActivity(intent)
    }
}
