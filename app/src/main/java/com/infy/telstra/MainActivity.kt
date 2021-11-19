package com.infy.telstra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infy.telstra.adapter.FactAdapter
import com.infy.telstra.databinding.ActivityMainBinding
import com.infy.telstra.databinding.ActivityMainFragBinding
import com.infy.telstra.utlity.checkInternet
import com.infy.telstra.viewModel.FactViewModel

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

}