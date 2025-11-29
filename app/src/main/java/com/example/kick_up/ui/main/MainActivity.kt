package com.example.kick_up.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.kick_up.R
import com.example.kick_up.databinding.ActivityMainBinding
import com.example.kick_up.ui.fragments.events.EventsFragment
import com.example.kick_up.ui.fragments.MyEventsFragment
import com.example.kick_up.ui.fragments.profile.ProfileFragment
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
        binding.bottomNavView.menu[1].isEnabled = false

        setupBottomNavigation()
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

}