package com.example.kick_up

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(private val eventList: ArrayList<Event>) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textStartDate: TextView = itemView.findViewById(R.id.textDateStart)
        val textEndDate: TextView = itemView.findViewById(R.id.textDateEnd)
        val textMonth: TextView = itemView.findViewById(R.id.textMonth)
        val textNameEvent: TextView = itemView.findViewById(R.id.txtNameEvent)
        val textStatus: TextView = itemView.findViewById(R.id.txtStatus)
        val textTeamName: TextView = itemView.findViewById(R.id.txtTeamName)

        fun bind(event: Event) {

            // Название события
            textNameEvent.text = event.nameEvent
            textNameEvent.post {
                val lineCount = textNameEvent.lineCount
                val params = textNameEvent.layoutParams as ConstraintLayout.LayoutParams
                params.topMargin = if (lineCount > 1) dpToPx(8) else dpToPx(27)
                textNameEvent.layoutParams = params
            }

            // Даты
            textStartDate.text = event.startDate
            textMonth.text = event.month

            if (event.endDate.isNullOrBlank()) {
                textEndDate.visibility = View.GONE

                // Отступ сверху 15dp
                val paramsStart = textStartDate.layoutParams as ConstraintLayout.LayoutParams
                paramsStart.topMargin = dpToPx(15)
                textStartDate.layoutParams = paramsStart

                // Отступ снизу 15dp у месяца
                val paramsMonth = textMonth.layoutParams as ConstraintLayout.LayoutParams
                paramsMonth.bottomMargin = dpToPx(15)
                textMonth.layoutParams = paramsMonth

            } else {
                textEndDate.text = event.endDate
                textEndDate.visibility = View.VISIBLE

                // Отступ сверху 8dp
                val paramsStart = textStartDate.layoutParams as ConstraintLayout.LayoutParams
                paramsStart.topMargin = dpToPx(8)
                textStartDate.layoutParams = paramsStart

                // Отступ снизу 7dp у месяца
                val paramsMonth = textMonth.layoutParams as ConstraintLayout.LayoutParams
                paramsMonth.bottomMargin = dpToPx(7)
                textMonth.layoutParams = paramsMonth
            }

            // Цвет статуса
            textStatus.text = event.status
            val statusColor = if (event.status == "Предстоящие") {
                ContextCompat.getColor(itemView.context, R.color.green)
            } else {
                ContextCompat.getColor(itemView.context, R.color.red)
            }
            textStatus.setTextColor(statusColor)

            // Команда
            textTeamName.text = event.team


//            textStartDate.text = event.startDate
//            textEndDate.text = event.endDate
//            textMonth.text = event.month
//            textNameEvent.text = event.nameEvent
//            textStatus.text = event.status
//            textTeamName.text = event.team
        }

        private fun dpToPx(dp: Int): Int {
            val density = itemView.context.resources.displayMetrics.density
            return (dp * density).toInt()
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.my_events_item, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: EventViewHolder,
        position: Int
    ) {
        holder.bind(eventList[position])

    }

    override fun getItemCount(): Int {
        return eventList.size
    }


}