package com.example.kronometre

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kronometre.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var pauseTime:Long = 0

        binding.btnStart.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime() + pauseTime
            binding.kronometre.start()
            binding.btnStart.visibility = View.GONE //starta basıldığında start butonu invisible olur
            binding.btnPause.visibility = View.VISIBLE // pause butonu visible olur
            binding.imageView2.setImageDrawable(getDrawable(R.drawable.pause)) // pausenin kırmızı resmini çağırdık
        }

        binding.btnPause.setOnClickListener {
            pauseTime = binding.kronometre.base-SystemClock.elapsedRealtime()
            binding.kronometre.stop() //koronometreyi durdurdurk
            binding.btnPause.visibility = View.GONE //pauseye basıldığında pause butonu invisible olur
            binding.btnStart.visibility = View.VISIBLE // start butonu visible olur
            binding.imageView2.setImageDrawable(getDrawable(R.drawable.start)) // startın turuncu resmini çağırdık
        }

        binding.btnReset.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime() // sistem saatini kronomotre içine aktarma
            binding.kronometre.stop() //koronometreyi durdurdurk
            pauseTime = 0
            binding.btnPause.visibility = View.GONE //pauseye basıldığında pause butonu invisible olur
            binding.btnStart.visibility = View.VISIBLE // start butonu visible olur
            binding.imageView2.setImageDrawable(getDrawable(R.drawable.start)) // startın turuncu resmini çağırdık
        }


    }
}