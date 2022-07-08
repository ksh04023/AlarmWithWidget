package com.android.alarmwithwidget.alarmRecycler

import java.util.*

data class Alarm(
    var name: String,
    var time: Calendar,
    var repeat: String,
    var bell: String
)
