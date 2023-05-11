package com.kenkorcak.sstimerapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kenkorcak.sstimerapp.databinding.ActivityAboutAppBinding

class AboutApp : AppCompatActivity() {

    private lateinit var binding: ActivityAboutAppBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val aboutText = binding.aboutAppTitle
        aboutText.text = "This app is a companion app for Pavel Tsatsouline's book, 'Simple and Sinister'. As prescribed in the book you will do 100 swings, rest, and end with 10 Turkish get ups." +
                " This is app is a timer with varying lengths of rounds for different rest periods." +
                " There is also a testing timer in which you are to do 100 swings in 5 minutes," +
                " rest for 1 minute, and then do 10 Turkish get ups in 10 minutes."
        aboutText.textSize = 20F
    }
}