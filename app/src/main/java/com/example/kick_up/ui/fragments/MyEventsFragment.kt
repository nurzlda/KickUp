package com.example.kick_up.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kick_up.Event
import com.example.kick_up.EventAdapter
import com.example.kick_up.R
import com.example.kick_up.databinding.FragmentMyEventsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyEventsFragment : Fragment(R.layout.fragment_my_events) {

    private lateinit var binding: FragmentMyEventsBinding
    private lateinit var eventList: ArrayList<Event>
    private lateinit var eventAdapter: EventAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMyEventsBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        eventList = arrayListOf()
        setupRecycler()
        loadDummyEvents()

    }

    private fun setupRecycler() {
        eventAdapter = EventAdapter(eventList)
        binding.rvEvents.layoutManager = LinearLayoutManager(requireContext())
        binding.rvEvents.adapter = eventAdapter
    }

    private fun loadDummyEvents() {
        val dummyEvents = listOf(
            Event("23", null, "OCT", "Кубок посла кореи",
                "Предстоящие", "Shumkar"),
            Event("6", "9", "OCT",
                "Ош опен Чемпионат Кыргызской республикииииииииииииииииииииииииииииииииииииииииииииииииииииииии",
                "Прошедшие", "Jolbors"),
            Event("12","15", "NOV", "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Предстоящие", "Nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"),
            Event("12","15", "NOV", "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Прошедшие", "everest"),
            Event("12","15", "NOV", "The Peal of Kyrgyzstan", "Прошедшие", "everest"),
            Event("12",null, "NOV", "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Прошедшие", "everest"),
            Event("12",null, "NOV", "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Прошедшие", "everest"),
            Event("12",null, "NOV", "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Прошедшие", "everest"),
            Event("12",null, "NOV", "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Прошедшие", "everest"),
            Event("12",null, "NOV", "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Прошедшие", "everest"),
            Event("12",null, "NOV", "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Прошедшие", "everest"),
            Event("12",null, "NOV", "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Прошедшие", "everest"),
            Event("12",null, "NOV", "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Прошедшие", "everest"),
            Event("12",null, "NOV", "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Прошедшие", "everest"),
            Event("12",null, "NOV", "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Прошедшие", "everest"),
            Event("12",null, "NOV", "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Прошедшие", "everest"),
            Event("12",null, "NOV", "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Прошедшие", "everest"),
        )
        eventList.clear()
        eventList.addAll(dummyEvents)
        eventAdapter.submitList(dummyEvents)
    }



}