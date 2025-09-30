package com.example.a501hw3_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.a501hw3_4.ui.theme._501hw3_4Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _501hw3_4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScaffoldScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldScreen() {
    // State for the Snackbar and a CoroutineScope to launch !!! -_-.
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    // State to track the selected item in the bottom navigation bar. important!
    var selectedItem by remember { mutableStateOf("Home") }

    Scaffold(
        // adds the SnackbarHost to the Scaffold.
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },

        // 4. topBar slot for the app title.
        topBar = {
            TopAppBar(
                title = { Text("Mounts") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },

        // the bottomBar slot for the navigation items.
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedItem == "Home",
                    onClick = { selectedItem = "Home" }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
                    label = { Text("Settings") },
                    selected = selectedItem == "Settings",
                    onClick = { selectedItem = "Settings" }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = selectedItem == "Profile",
                    onClick = { selectedItem = "Profile" }
                )
            }
        },

        //  floatingActionButton slot for the FAB.
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // shows the  snackbar
                    scope.launch {
                        snackbarHostState.showSnackbar("FAB Clicked!")
                    }
                }
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->

        ScreenContent(
            modifier = Modifier.padding(innerPadding),
            selectedScreen = selectedItem
        )
    }
}

/**
 * The main content of the screen.
 * It receives a modifier with the correct padding from the Scaffold.
 */
@Composable
fun ScreenContent(modifier: Modifier = Modifier, selectedScreen: String) {
    Column(

        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "You are on the $selectedScreen screen",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    _501hw3_4Theme {
        ScaffoldScreen()
    }
}