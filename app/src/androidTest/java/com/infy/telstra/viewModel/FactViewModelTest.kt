package com.infy.telstra.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.infy.telstra.model.FactItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FactViewModelTest {

    private lateinit var factViewModel: FactViewModel

    @get:Rule
    val instantTaskExecutorRule =  InstantTaskExecutorRule()

    @Before
     fun setUp() {
        factViewModel= FactViewModel()
    }

    @Test
    fun testFactViewModel(){
        factViewModel.factRepository.insertDataSingle(FactItem("Title","Description","Image"))
        factViewModel.getAllFacts()
       val result =   factViewModel.getAllFacts.getOrAwaitValue().find {
            it.title.equals("Title")
        }
        assert(result!=null)
    }
}