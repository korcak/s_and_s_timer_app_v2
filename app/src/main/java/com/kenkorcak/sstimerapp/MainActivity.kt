package com.kenkorcak.sstimerapp

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.kenkorcak.sstimerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val oneToOneButton = binding.oneToOneButton
        oneToOneButton.setOnClickListener {
            oneToOneRatio()
        }

        val emomButton = binding.emomButton
        emomButton.setOnClickListener {
            emomScreen()
        }

        val oneToTwoButton = binding.oneToTwoButton
        oneToTwoButton.setOnClickListener {
            oneToTwoRatio()
        }

        val randomTimerButton = binding.randomTimerButton
        randomTimerButton.setOnClickListener {
            randomTimer()
        }

        val testTimerButton = binding.testTimerButton
        testTimerButton.setOnClickListener {
            testTimer()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.about_app -> {
            val intent = Intent(this, AboutApp::class.java)
            startActivity(intent)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun oneToOneRatio() {
        val intent = Intent(this, OneToOneRatio::class.java)
        startActivity(intent)
    }

    private fun emomScreen() {
        val intent = Intent(this, EMOM::class.java)
        startActivity(intent)
    }

    private fun oneToTwoRatio() {
        val intent = Intent(this, OneToTwoRatio::class.java)
        startActivity(intent)
    }

    private fun randomTimer() {
        val randomTimer = (1..3).random()
        if (randomTimer == 1) {
            oneToOneRatio()
        } else if (randomTimer == 2) {
            emomScreen()
        } else {
            oneToTwoRatio()
        }
    }

    private fun testTimer() {
        val intent = Intent(this, Test::class.java)
        startActivity(intent)
    }

}