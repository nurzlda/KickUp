package com.example.kick_up

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kick_up.databinding.MyEventsItemBinding


class EventAdapter(private val eventList: ArrayList<Event>) :
    ListAdapter<Event, EventAdapter.EventViewHolder>(EventDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    )= EventViewHolder (
        MyEventsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    )
    override fun onBindViewHolder(
        holder: EventViewHolder,
        position: Int
    ) {
        holder.bind(eventList[position])
    }


    inner class EventViewHolder(private val binding: MyEventsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(event: Event){
//             Название события

            binding.txtNameEvent.text = event.nameEvent
            binding.txtNameEvent.post {
                val lineCount = binding.txtNameEvent.lineCount
                val params = binding.txtNameEvent.layoutParams as ConstraintLayout.LayoutParams
                params.topMargin = if (lineCount > 1) dpToPx(8) else dpToPx(27)
                binding.txtNameEvent.layoutParams = params
            }

            // Даты
            binding.textDateStart.text = event.startDate
            binding.textMonth.text = event.month

            if (event.endDate.isNullOrBlank()) {
                binding.textDateEnd.visibility = View.GONE

                // Отступ сверху 15dp
                val paramsStart = binding.textDateStart.layoutParams as ConstraintLayout.LayoutParams
                paramsStart.topMargin = dpToPx(15)
                binding.textDateStart.layoutParams = paramsStart

                // Отступ снизу 15dp у месяца
                val paramsMonth = binding.textMonth.layoutParams as ConstraintLayout.LayoutParams
                paramsMonth.bottomMargin = dpToPx(15)
                binding.textMonth.layoutParams = paramsMonth

            } else {
                binding.textDateEnd.text = event.endDate
                binding.textDateEnd.visibility = View.VISIBLE

                // Отступ сверху 8dp
                val paramsStart = binding.textDateStart.layoutParams as ConstraintLayout.LayoutParams
                paramsStart.topMargin = dpToPx(8)
                binding.textDateStart.layoutParams = paramsStart

                // Отступ снизу 7dp у месяца
                val paramsMonth = binding.textMonth.layoutParams as ConstraintLayout.LayoutParams
                paramsMonth.bottomMargin = dpToPx(7)
                binding.textMonth.layoutParams = paramsMonth
            }

            // Цвет статуса
            binding.txtStatus.text = event.status
            val statusColor = if (event.status == "Предстоящие") {
                ContextCompat.getColor(itemView.context, R.color.green)
            } else {
                ContextCompat.getColor(itemView.context, R.color.red)
            }
            binding.txtStatus.setTextColor(statusColor)

            // Команда
            binding.txtTeamName.text = event.team

        }
        private fun dpToPx(dp: Int): Int {
            val density = itemView.context.resources.displayMetrics.density
            return (dp * density).toInt()
        }

    }
    class EventDiffCallback : DiffUtil.ItemCallback<Event>(){
        override fun areItemsTheSame(
            oldItem: Event,
            newItem: Event
        ): Boolean {
            return oldItem==newItem
            //Полсе подключение бека заменить на return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Event,
            newItem: Event
        ): Boolean {
            return oldItem==newItem
        }

    }


}


//class EventAdapter(private val eventList: ArrayList<Event>) :
//    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
//
//    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        val binding.textDateStart: TextView = itemView.findViewById(R.id.textDateStart)
//        val textEndDate: TextView = itemView.findViewById(R.id.textDateEnd)
//        val binding.textMonth: TextView = itemView.findViewById(R.id.textMonth)
//        val textNameEvent: TextView = itemView.findViewById(R.id.txtNameEvent)
//        val binding.txtStatus: TextView = itemView.findViewById(R.id.txtStatus)
//        val textTeamName: TextView = itemView.findViewById(R.id.txtTeamName)
//
//        fun bind(event: Event) {
//
//            // Название события
//            textNameEvent.text = event.nameEvent
//            textNameEvent.post {
//                val lineCount = textNameEvent.lineCount
//                val params = textNameEvent.layoutParams as ConstraintLayout.LayoutParams
//                params.topMargin = if (lineCount > 1) dpToPx(8) else dpToPx(27)
//                textNameEvent.layoutParams = params
//            }
//
//            // Даты
//            binding.textDateStart.text = event.startDate
//            textMonth.text = event.month
//
//            if (event.endDate.isNullOrBlank()) {
//                textEndDate.visibility = View.GONE
//
//                // Отступ сверху 15dp
//                val paramsStart = textStartDate.layoutParams as ConstraintLayout.LayoutParams
//                paramsStart.topMargin = dpToPx(15)
//                textStartDate.layoutParams = paramsStart
//
//                // Отступ снизу 15dp у месяца
//                val paramsMonth = textMonth.layoutParams as ConstraintLayout.LayoutParams
//                paramsMonth.bottomMargin = dpToPx(15)
//                textMonth.layoutParams = paramsMonth
//
//            } else {
//                textEndDate.text = event.endDate
//                textEndDate.visibility = View.VISIBLE
//
//                // Отступ сверху 8dp
//                val paramsStart = textStartDate.layoutParams as ConstraintLayout.LayoutParams
//                paramsStart.topMargin = dpToPx(8)
//                textStartDate.layoutParams = paramsStart
//
//                // Отступ снизу 7dp у месяца
//                val paramsMonth = textMonth.layoutParams as ConstraintLayout.LayoutParams
//                paramsMonth.bottomMargin = dpToPx(7)
//                textMonth.layoutParams = paramsMonth
//            }
//
//            // Цвет статуса
//            textStatus.text = event.status
//            val statusColor = if (event.status == "Предстоящие") {
//                ContextCompat.getColor(itemView.context, R.color.green)
//            } else {
//                ContextCompat.getColor(itemView.context, R.color.red)
//            }
//            textStatus.setTextColor(statusColor)
//
//            // Команда
//            textTeamName.text = event.team
//
//
////            textStartDate.text = event.startDate
////            textEndDate.text = event.endDate
////            textMonth.text = event.month
////            textNameEvent.text = event.nameEvent
////            textStatus.text = event.status
////            textTeamName.text = event.team
//        }
//
//        private fun dpToPx(dp: Int): Int {
//            val density = itemView.context.resources.displayMetrics.density
//            return (dp * density).toInt()
//        }
//    }
//
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): EventViewHolder {
//        val view =
//            LayoutInflater.from(parent.context).inflate(R.layout.my_events_item, parent, false)
//        return EventViewHolder(view)
//    }
//
//    override fun onBindViewHolder(
//        holder: EventViewHolder,
//        position: Int
//    ) {
//        holder.bind(eventList[position])
//
//    }
//
//    override fun getItemCount(): Int {
//        return eventList.size
//    }
//
//
//}