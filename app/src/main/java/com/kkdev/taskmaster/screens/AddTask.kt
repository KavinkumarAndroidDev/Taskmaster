package com.kkdev.taskmaster.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kkdev.taskmaster.R
import com.kkdev.taskmaster.composable.BorderlessTextField
import com.kkdev.taskmaster.ui.theme.AppTheme
import com.kkdev.taskmaster.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun AddTask(){
    Scaffold(
        containerColor = AppTheme.colorScheme.onPrimary,
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = AppTheme.colorScheme.onPrimary,
                    titleContentColor = AppTheme.colorScheme.onBackground,
                    actionIconContentColor = AppTheme.colorScheme.onBackground,
                    scrolledContainerColor = AppTheme.colorScheme.onBackground,
                    navigationIconContentColor = AppTheme.colorScheme.onBackground
                ),
                title = {
                    Text(
                    text = "Add Task",
                    fontFamily = poppinsFontFamily,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                    )},
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_left),
                            contentDescription = null,
                        )
                    }
                },
                actions = {}
            )
        },
        bottomBar = {
            BottomAppBar (
                containerColor = AppTheme.colorScheme.onPrimary
            ){
                ToggleButtonGroup()
                /*
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(text = "Choose a label",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontFamily = poppinsFontFamily
                    )

                }
                 */


            }
        }
    ) { it ->
        val focusRequester = remember { FocusRequester() }
        var inputText by remember { mutableStateOf("Add your title") }
        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .padding(it)) {
            BorderlessTextField(
                value = inputText,
                txtStyle = TextStyle(
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Medium,
                    color = AppTheme.colorScheme.onBackground,
                    fontFamily = poppinsFontFamily
                ),
                onValueChange = {
                    inputText = it
                },
                placeholder =  "Title"
            )
            BasicTextField(
                value = "title",
                onValueChange = {},
                textStyle = TextStyle(
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontFamily = poppinsFontFamily,
                    color = AppTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Medium
                ),
                singleLine = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .heightIn(min = 56.dp)
                    .focusRequester(focusRequester)
                    .verticalScroll(rememberScrollState())
            )
        }
    }

}



@Preview(showBackground = true)
@Composable
fun f1k(){
    AppTheme{
        AddTask()
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ToggleButtonGroup() {
    var selectedButton by remember { mutableStateOf(0) }

    val buttons = listOf("Personal", "Work", "Finance", "Other")

    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        buttons.forEachIndexed { index, buttonText ->
            ToggleButton(
                text = buttonText,
                isSelected = selectedButton == index,
                onClick = { selectedButton = index },
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun ToggleButton(text: String, isSelected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    val backgroundColor = if (isSelected) AppTheme.colorScheme.primary else AppTheme.colorScheme.surface
    val contentColor = if (isSelected) AppTheme.colorScheme.onPrimary else AppTheme.colorScheme.primary

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = text,
            fontFamily = poppinsFontFamily,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Medium
        )
    }
}