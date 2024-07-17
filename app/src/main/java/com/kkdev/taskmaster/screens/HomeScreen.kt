package com.kkdev.taskmaster.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.kkdev.taskmaster.ui.theme.AppTheme
import com.kkdev.taskmaster.ui.theme.poppinsFontFamily

data class navitem(
    val title:String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    val items = listOf(
        navitem(
            "Home",
            selectedIcon = Icons.Filled.Home,
            unSelectedIcon = Icons.Outlined.Home
        ),
        navitem(
            title = "Categories",
            selectedIcon = Icons.Filled.List,
            unSelectedIcon = Icons.Outlined.List
        ),
        navitem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unSelectedIcon = Icons.Outlined.Settings
        )
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Taskmaster",
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                    )
                },
            )
        },
        bottomBar =  {
            NavigationBar{
                items.forEachIndexed{index,item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                        },
                        icon = {
                            BadgedBox(badge = {}) {
                                Icon(
                                    imageVector = if(index == selectedItemIndex){ item.selectedIcon }else item.unSelectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        },
                        colors = NavigationBarItemColors(
                            selectedIndicatorColor = Color.Unspecified,
                            selectedIconColor = AppTheme.colorScheme.primary,
                            unselectedIconColor = AppTheme.colorScheme.onBackground,
                            unselectedTextColor = AppTheme.colorScheme.onBackground,
                            disabledTextColor = AppTheme.colorScheme.onBackground,
                            selectedTextColor = AppTheme.colorScheme.onBackground,
                            disabledIconColor = AppTheme.colorScheme.primary
                        ),
                        label = {
                            Text(text=item.title,
                                fontFamily = poppinsFontFamily,
                                style = MaterialTheme.typography.titleSmall)
                        }
                    )
                }
            }
        }
    ) {it ->
        Column (modifier = Modifier
            .padding(it)
            .fillMaxSize()){

        }

    }
}


@Preview(showBackground = true)
@Composable
fun hsp(){
    AppTheme{
        HomeScreen()
    }
}