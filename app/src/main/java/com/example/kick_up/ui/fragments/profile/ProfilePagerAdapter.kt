package com.example.kick_up.ui.fragments.profile

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kick_up.ui.fragments.MyEventsFragment
import com.example.kick_up.ui.fragments.MyStudentsFragment

class ProfilePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MyEventsFragment()
            else -> MyStudentsFragment()
        }
    }
}