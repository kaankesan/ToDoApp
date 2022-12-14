package com.kaankesan.todoapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val low = Color(0xFF00C980)
val medium = Color(0xFFFFC114)
val high = Color(0xFFFF4646)
val none = Color(0xFFFFFFFF)

val LightGray = Color(0xFFFCFCFC)
val MediumGray = Color(0xFF9C9C9C)
val DarkGray = Color(0xFF141414)


val Colors.topAppBarContentColor: Color
@Composable
get() = if(isLight) Color.White else LightGray


val Colors.topAppBarBackGroundColor: Color
    @Composable
    get() = if(isLight) Purple500 else Color.Black



val Colors.fabBackGroundColor: Color
    @Composable
    get() = if(isLight) Teal200 else Purple700