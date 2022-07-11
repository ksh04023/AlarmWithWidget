package com.android.alarmwithwidget.alarmRecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.alarmwithwidget.R
import com.android.alarmwithwidget.dataclass.Alarm

class AlarmReclcyerAdapter(private val context: Context):RecyclerView.Adapter<AlarmReclcyerAdapter.ViewHolder>() {

    var data = mutableListOf<Alarm>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.alarm_recycler_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlarmReclcyerAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val textTime = itemView.findViewById<TextView>(R.id.textTimeAlarmRecycler)
        val textName = itemView.findViewById<TextView>(R.id.textNameAlarmRecycler)

        fun bind(item: Alarm) {
            textTime.text = item.time.toString()
            textName.text = item.name
        }
    }
}