package com.example.lektion_14_lazycolumn

import android.app.Application
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.lektion_14_lazycolumn.ui.theme.Lektion_14_LazyColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lektion_14_LazyColumnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   MyScreen()
                }
            }
        }
    }
}

@Composable
fun MyScreen() {

    val itemsArray = arrayListOf<String>()


    for (i in 1..1000) {
        itemsArray.add("Item $i")
    }

    val selectedItemIndexState = remember { mutableStateOf(0) }
    val localContext = LocalContext.current             // Context

    LazyColumn {
        items(itemsArray) { item ->
            Text(
                text = item,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        selectedItemIndexState.value = itemsArray.indexOf(item)
                        println("Item $selectedItemIndexState")
                        Toast
                            .makeText(localContext, " ${itemsArray[selectedItemIndexState.value]} ", Toast.LENGTH_LONG)
                            .show()
                    }
                    .padding(16.dp)
            )
        }
    }
}