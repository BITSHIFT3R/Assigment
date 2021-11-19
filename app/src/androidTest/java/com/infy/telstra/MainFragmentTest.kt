package com.infy.telstra

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.*


@RunWith(AndroidJUnit4::class)
class MainFragmentTest {


    private lateinit var scenario: FragmentScenario<MainFragment>



    @Before
    fun setUp() {
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_Telstra)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testSwipeOnFragment(){
        onView(withId(R.id.rv_facts)).perform(ViewActions.swipeDown())
    }


}