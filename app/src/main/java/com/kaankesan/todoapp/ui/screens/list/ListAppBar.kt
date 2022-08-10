package com.kaankesan.todoapp.ui.screens.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kaankesan.todoapp.R
import com.kaankesan.todoapp.data.modells.Priority
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import com.kaankesan.todoapp.components.PriorityItem
import com.kaankesan.todoapp.ui.theme.*
import com.kaankesan.todoapp.ui.theme.viewModel.SharedViewModel

@Composable
fun ListAppBar(

){
    SearchAppBar(
        text = "",
        onTextChange = {},
        onCloseClick = {},
        onSearchClick = {}
    )
}


@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
){
    TopAppBar(
        title = {
            Text(
                text = "Tasks",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        actions = {
                  ListAppBarActions(
                      onSearchClicked = onSearchClicked,
                      onSortClicked = onSortClicked,
                      onDeleteClicked = onDeleteClicked
                  )

        },
        backgroundColor = MaterialTheme.colors.topAppBarBackGroundColor
    )

}


@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
){
    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
    DeleteAllActions(onDeleteClicked = onDeleteClicked)


}


@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
){
    IconButton(
        onClick = {onSearchClicked}
    ) {
        Icon(imageVector = Icons.Filled.Search,
        contentDescription = stringResource(R.string.b),
        tint = MaterialTheme.colors.topAppBarContentColor)
    }
}


@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit
){
    var expended by remember { mutableStateOf(false)}
    IconButton(
        onClick = {
            expended = true
        }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.filter),
            contentDescription = stringResource(R.string.c),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expended,
            onDismissRequest = { expended = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expended = false
                    onSortClicked(Priority.LOW)
                }
            ) {
                PriorityItem(Priority = Priority.LOW)
            }

            DropdownMenuItem(
                onClick = {
                    expended = false
                    onSortClicked(Priority.HIGH)
                }
            ) {
                PriorityItem(Priority = Priority.HIGH)
            }

            DropdownMenuItem(
                onClick = {
                    expended = false
                    onSortClicked(Priority.NONE)
                }
            ) {
                PriorityItem(Priority = Priority.NONE)
            }
        }
    }
}



@Composable
fun DeleteAllActions(
    onDeleteClicked : () -> Unit
){
    var expended by remember { mutableStateOf(false)}
    IconButton(
        onClick = {
            expended = true
        }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
            contentDescription = stringResource(R.string.c),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expended,
            onDismissRequest = { expended = false }
        ){
            DropdownMenuItem(
                onClick = {
                    expended = false
                    onDeleteClicked()
                }
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = LARGE_PADDING),
                    text = stringResource(R.string.d),
                    style = Typography.subtitle2
                )
            }
        }
        }
}


@Composable
fun SearchAppBar(
    text:String,
    onTextChange: (String) -> Unit,
    onCloseClick: () -> Unit,
    onSearchClick: (String) -> Unit,

){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.topAppBarBackGroundColor

    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = {
                Text(
                    text = "Search",
                    color = Color.White,
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                )
            },
            textStyle = TextStyle(
                color = MaterialTheme.colors.topAppBarContentColor,
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    onClick = {

                    },
                    modifier = Modifier
                        .alpha(ContentAlpha.disabled)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search ,
                        contentDescription = "Search Icon",
                        tint = MaterialTheme.colors.topAppBarContentColor
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        onCloseClick()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close Icon",
                        tint = MaterialTheme.colors.topAppBarContentColor
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClick(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = MaterialTheme.colors.topAppBarContentColor,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent
            )

        )
    }
}




@Composable
@Preview
fun DefaultListAppBarPreview(){
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}


@Composable
@Preview
fun SearchBarPreview(){
    SearchAppBar(
        text = "Search",
        onTextChange = {},
        onCloseClick = { /*TODO*/ },
        onSearchClick = {}
    )
}