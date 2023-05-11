package com.kenkorcak.sstimerapp

import android.content.Intent
import android.content.pm.ActivityInfo
import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kenkorcak.sstimerapp.databinding.ActivityEmomBinding
import java.util.Locale

class EMOM : AppCompatActivity() {

    private lateinit var binding: ActivityEmomBinding
    private lateinit var countdownTextMovement: TextView
    private lateinit var countdownTextSeconds: TextView
    private lateinit var textToSpeech: TextToSpeech
    private var countdownTimer: CountDownTimer? = null
    private var isPaused = false
    private var pauseTimeRemaining: Long = 0
    private val tone = ToneGenerator(AudioManager.STREAM_ALARM, 100)
    private var isTextSpoken = false
    private val tickInterval = 1000L
    private val startTimerInterval = 5000L
    private val swingTimerInterval = 60000L
    private val restTimerInterval = 60000L
    private val tguTimerInterval = 60000L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        binding = ActivityEmomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        countdownTextMovement = binding.textviewMovement
        countdownTextSeconds = binding.textviewCountdownTimer

        textToSpeech = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech.language = Locale.getDefault()
            }
        }

        binding.startTimerButton.setOnClickListener {
            startCountdown()
            binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
        }

        binding.stopTimerButton.setOnClickListener {
            countdownTimer?.cancel()
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startCountdown() {

        countdownTimer = object : CountDownTimer(startTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.countdown_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Countdown",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundOne()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.countdown_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundOne()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundOne() {

        countdownTimer = object : CountDownTimer(swingTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.swing_10_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Swing 10",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundTwo()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.swing_10_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundTwo()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundTwo() {

        countdownTimer = object : CountDownTimer(swingTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.swing_10_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Swing 10",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundThree()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.swing_10_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundThree()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundThree() {

        countdownTimer = object : CountDownTimer(swingTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.swing_10_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Swing 10",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundFour()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.swing_10_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundFour()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundFour() {

        countdownTimer = object : CountDownTimer(swingTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.swing_10_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Swing 10",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundFive()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.swing_10_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundFive()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundFive() {

        countdownTimer = object : CountDownTimer(swingTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.swing_10_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Swing 10",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundSix()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.swing_10_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundSix()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundSix() {

        countdownTimer = object : CountDownTimer(swingTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.swing_10_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Swing 10",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundSeven()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.swing_10_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundSeven()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundSeven() {

        countdownTimer = object : CountDownTimer(swingTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.swing_10_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Swing 10",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundEight()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.swing_10_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundEight()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundEight() {

        countdownTimer = object : CountDownTimer(swingTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.swing_10_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Swing 10",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundNine()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.swing_10_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundNine()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundNine() {

        countdownTimer = object : CountDownTimer(swingTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.swing_10_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Swing 10",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundTen()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.swing_10_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundTen()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundTen() {

        countdownTimer = object : CountDownTimer(swingTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.swing_10_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Swing 10",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundRest()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.swing_10_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundRest()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundRest() {

        countdownTimer = object : CountDownTimer(restTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.rest_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Rest",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundEleven()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.rest_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundEleven()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundEleven() {

        countdownTimer = object : CountDownTimer(tguTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Turkish Get Up",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundTwelve()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundTwelve()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundTwelve() {

        countdownTimer = object : CountDownTimer(tguTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Turkish Get Up",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundThirteen()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundThirteen()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundThirteen() {

        countdownTimer = object : CountDownTimer(tguTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Turkish Get Up",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundFourteen()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundFourteen()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundFourteen() {

        countdownTimer = object : CountDownTimer(tguTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Turkish Get Up",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundFifteen()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundFifteen()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundFifteen() {

        countdownTimer = object : CountDownTimer(tguTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Turkish Get Up",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundSixteen()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundSixteen()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundSixteen() {

        countdownTimer = object : CountDownTimer(tguTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Turkish Get Up",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundSeventeen()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundSeventeen()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundSeventeen() {

        countdownTimer = object : CountDownTimer(tguTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Turkish Get Up",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundEighteen()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundEighteen()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundEighteen() {

        countdownTimer = object : CountDownTimer(tguTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Turkish Get Up",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundNineteen()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundNineteen()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundNineteen() {

        countdownTimer = object : CountDownTimer(tguTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Turkish Get Up",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                roundTwenty()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        roundTwenty()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun roundTwenty() {

        countdownTimer = object : CountDownTimer(tguTimerInterval, tickInterval) {

            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                    countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                    if (!isTextSpoken) {
                        isTextSpoken = true
                        textToSpeech.speak(
                            "Turkish Get Up",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                    if (millisUntilFinished < 3000) {
                        tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                    }
                }
                pauseTimeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                isTextSpoken = false
                callFinished()
            }
        }
        countdownTimer?.start()

        binding.startTimerButton.setOnClickListener {
            if (!isPaused) {
                countdownTimer?.cancel()
                binding.startTimerButton.setImageResource(R.drawable.ic_play_24)
                isPaused = true
            } else {
                countdownTimer = object : CountDownTimer(pauseTimeRemaining, tickInterval) {


                    override fun onTick(millisUntilFinished: Long) {
                        countdownTextMovement.text = getString(R.string.turkish_get_up_text)
                        countdownTextSeconds.text = (millisUntilFinished / 1000).toString()

                        if (millisUntilFinished < 3000) {
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                        }
                        pauseTimeRemaining = millisUntilFinished
                    }


                    override fun onFinish() {
                        isTextSpoken = false
                        callFinished()
                    }
                }
                countdownTimer?.start()
                binding.startTimerButton.setImageResource(R.drawable.ic_pause_24)
                isPaused = false
            }
        }
    }

    private fun callFinished() {
        countdownTextMovement.text = getString(R.string.complete_text)
        textToSpeech.speak(
            "Your timer is complete",
            TextToSpeech.QUEUE_FLUSH,
            null,
            null
        )
    }
}