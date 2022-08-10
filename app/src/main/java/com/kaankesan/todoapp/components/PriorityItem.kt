package com.kaankesan.todoapp.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaankesan.todoapp.data.modells.Priority
import com.kaankesan.todoapp.ui.theme.LARGE_PADDING
import com.kaankesan.todoapp.ui.theme.PRIORITY_INDICATOR_SIZE
import com.kaankesan.todoapp.ui.theme.Typography

@Composable
fun PriorityItem(
    Priority: Priority
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(modifier = Modifier.size(PRIORITY_INDICATOR_SIZE)){
            drawCircle(color = Priority.color)
        }
        Text(
            modifier = Modifier
                .padding(start = LARGE_PADDING),
            text = Priority.name,
            style = Typography.subtitle1,
            color = MaterialTheme.colors.onSurface
        )
    }
}


@Preview
@Composable
fun PriorityItemPreview(){
    PriorityItem(Priority = Priority.HIGH)
}