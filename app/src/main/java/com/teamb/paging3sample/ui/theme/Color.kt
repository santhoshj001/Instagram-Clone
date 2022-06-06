package com.teamb.paging3sample.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Colors.toAppBarContentColor : Color
    get() = if (isLight) Color.White else Color.LightGray

val Colors.toAppBarBackgroundColor : Color
    get() = if (isLight) Purple500 else Color.Black
