package com.kaankesan.todoapp.data.modells

import androidx.compose.ui.graphics.Color
import com.kaankesan.todoapp.ui.theme.high
import com.kaankesan.todoapp.ui.theme.low
import com.kaankesan.todoapp.ui.theme.medium
import com.kaankesan.todoapp.ui.theme.none

enum class Priority(val color: Color) {

    HIGH(high),
    MEDIUM(medium),
    LOW(low),
    NONE(none)



}