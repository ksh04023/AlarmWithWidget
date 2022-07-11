package com.android.alarmwithwidget.dataclass

import java.util.*

data class User(
    val id: Int,
    val name: String,
    var gmail: String = "",
    var lastLoginDate: Date,
    var signInDate: Date,
    var quickAlarmList: List<Int> = listOf(5,10,15)

    )
