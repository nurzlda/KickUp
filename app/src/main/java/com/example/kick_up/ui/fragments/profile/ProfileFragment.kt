package com.example.kick_up.ui.fragments.profile

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log.i
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kick_up.R
import com.example.kick_up.databinding.FragmentProfileBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding
    private var tabTitles = arrayListOf("Мои соревнования", "Мои ученики")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        setTabLayoutWithViewPager()
        return binding.root

    }

    private fun setTabLayoutWithViewPager() {
        binding.viewPager2.adapter = ProfilePagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        for (i in 0..1) {
            val textView = LayoutInflater.from(requireContext()).inflate(R.layout.tab_title, null)
                    as TextView
            binding.tabLayout.getTabAt(i)?.customView = textView
        }

        val firstTabText =
            binding.tabLayout.getTabAt(0)?.customView?.findViewById<TextView>(android.R.id.text1)
        firstTabText?.setTypeface(null, Typeface.BOLD)

        // Слушатель для жирного текста
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val textView = tab.customView?.findViewById<TextView>(android.R.id.text1)
                textView?.setTypeface(null, Typeface.BOLD)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val textView = tab.customView?.findViewById<TextView>(android.R.id.text1)
                textView?.setTypeface(null, Typeface.NORMAL)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }


}