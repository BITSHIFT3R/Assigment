package com.infy.telstra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.infy.telstra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().apply {
            replace(binding.frame.id, MainFragment.newInstance())
            addToBackStack(null)
            commit()
        }
    }
    override fun onBackPressed() {
      super.onBackPressed()
        finish()
    }
}