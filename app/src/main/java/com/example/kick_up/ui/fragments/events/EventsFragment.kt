package com.example.kick_up.ui.fragments.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kick_up.Event
import com.example.kick_up.EventAdapter
import com.example.kick_up.databinding.FragmentEventsBinding
import com.example.kick_up.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventsFragment : BaseFragment<FragmentEventsBinding>() {

    private lateinit var eventList: ArrayList<Event>
    private lateinit var eventAdapter: EventAdapter

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEventsBinding {
        return FragmentEventsBinding.inflate(inflater, container, false)
    }


    override fun setupViews() {
        eventList = arrayListOf()
        setupRecycler()
        loadDummyEvents()
    }

    override fun setupObservers() {

    }

    private fun setupRecycler() {
        eventAdapter = EventAdapter(eventList)
        binding.rvEvents.layoutManager = LinearLayoutManager(requireContext())
        binding.rvEvents.adapter = eventAdapter
    }



    private fun loadDummyEvents() {
        val dummyEvents = listOf(
            Event(
                "23", null, "OCT", "Кубок посла кореи",
                "Предстоящие", "Shumkar"
            ),
            Event(
                "6", "9", "OCT",
                "Ош опен Чемпионат Кыргызской республикииииииииииииииииииииииииииииииииииииииииииииииииииииииии",
                "Прошедшие", "Jolbors"
            ),
            Event(
                "12",
                "15",
                "NOV",
                "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                "Предстоящие",
                "Nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            ),
            Event(
                "12",
                "15",
                "NOV",
                "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                "Прошедшие",
                "everest"
            ),
            Event("12", "15", "NOV", "The Peal of Kyrgyzstan", "Прошедшие", "everest"),
            Event(
                "12",
                null,
                "NOV",
                "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                "Прошедшие",
                "everest"
            ),
            Event(
                "12",
                null,
                "NOV",
                "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                "Прошедшие",
                "everest"
            ),
            Event(
                "12",
                null,
                "NOV",
                "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                "Прошедшие",
                "everest"
            ),
            Event(
                "12",
                null,
                "NOV",
                "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                "Прошедшие",
                "everest"
            ),
            Event(
                "12",
                null,
                "NOV",
                "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                "Прошедшие",
                "everest"
            ),
            Event(
                "12",
                null,
                "NOV",
                "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                "Прошедшие",
                "everest"
            ),
            Event(
                "12",
                null,
                "NOV",
                "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                "Прошедшие",
                "everest"
            ),
            Event(
                "12",
                null,
                "NOV",
                "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                "Прошедшие",
                "everest"
            ),
            Event(
                "12",
                null,
                "NOV",
                "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                "Прошедшие",
                "everest"
            ),
            Event(
                "12",
                null,
                "NOV",
                "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                "Прошедшие",
                "everest"
            ),
            Event(
                "12",
                null,
                "NOV",
                "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                "Прошедшие",
                "everest"
            ),
            Event(
                "12",
                null,
                "NOV",
                "The Peal of Kyrgyzstannnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                "Прошедшие",
                "everest"
            ),
        )
        eventList.clear()
        eventList.addAll(dummyEvents)
        eventAdapter.submitList(dummyEvents)
    }

}