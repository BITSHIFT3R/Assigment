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
 /*   private lateinit var mainFragmentBinding: ActivityMainFragBinding
    private lateinit var factViewModel : FactViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDataBinding()
        initRecyclerView()
        loadData()

    }

    //Initializing data binding
    private fun initDataBinding(){
        mainFragmentBinding = DataBindingUtil.setContentView(this,R.layout.activity_main_frag)
        factViewModel = ViewModelProvider(this).get(FactViewModel::class.java)
        factViewModel.loadData()

    }

    //Initializing recyclerview
    private fun initRecyclerView(){
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        mainFragmentBinding.rvFacts.layoutManager = layoutManager


    }

    private fun loadData() {

        if (checkInternet(this)) {
           factViewModel.getData()?.observe(this,{
               if (it != null) {
                   val factList = it
                   factList.let {
                       mainFragmentBinding.rvFacts.apply {
                           adapter = FactAdapter(factList)
                       }
                   }
               } else {
                   Toast.makeText(this, getString(R.string.no_data),Toast.LENGTH_LONG).show()
               }
           })
       *//*     factViewModel.factList.observe(this, {
                if (it != null) {
                    val factList = it.rows
                    factList.let {
                        mainActivityBinding.rvFacts.apply {
                            adapter = FactAdapter(factList)
                        }
                    }
                } else {
                    Toast.makeText(this, getString(R.string.no_data),Toast.LENGTH_LONG).show()
                }
            })*//*

        } else {
            Toast.makeText(this, getString(R.string.no_internet),Toast.LENGTH_LONG).show()

        }

    }
*/
}