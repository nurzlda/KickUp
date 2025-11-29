package com.example.kick_up.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.kick_up.R
import com.example.kick_up.databinding.ActivityMainBinding
import com.example.kick_up.ui.fragments.EventsFragment
import com.example.kick_up.ui.fragments.HomeFragment
import com.example.kick_up.ui.fragments.MyEventsFragment
import com.example.kick_up.ui.fragments.profile.ProfileFragment
import com.example.kick_up.ui.fragments.registration.RegFragment
import com.example.kick_up.utils.Prefs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        openFragment(EventsFragment(), "Соревнования")
        binding.bottomNavView.menu.get(1).isEnabled = false

        setupBottomNavigation()

        val isLoggedIn = Prefs.isLoggedIn(this)
        Log.d("AuthCheck", "User logged in? $isLoggedIn")
        if (isLoggedIn) {
           openAfterReg()
        }else{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RegFragment())
                .commit()
        }
    }



    private fun setupBottomNavigation() {
        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_profile -> {
                    openFragment(ProfileFragment(), "Профиль")
                    true
                }

                R.id.nav_events -> {
                    openFragment(EventsFragment(), "Соревнования")
                    true
                }

                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment, title: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()

        binding.toolBarTitle.text = title
    }
    private fun openAfterReg(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()
    }

}