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
import com.example.kick_up.utils.BaseFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    private var tabTitles = arrayListOf("Мои соревнования", "Мои ученики")

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater,container,false)
    }


    override fun setupViews() {
        setTabLayoutWithViewPager()

    }

    override fun setupObservers() {

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