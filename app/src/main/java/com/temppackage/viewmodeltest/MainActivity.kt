package com.temppackage.viewmodeltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.temppackage.viewmodeltest.ui.theme.ViewModelTestTheme

class MainActivity : ComponentActivity() {
    val viewModel = NumbersViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.startCollecting()
        setContent {
            ViewModelTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Numbers(viewModel)
                }
            }
        }
    }
}

@Composable
fun Numbers(viewModel: NumbersViewModel) {
    val num = viewModel.numbers.observeAsState()
    Text(text = num.value.contentToString())
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ViewModelTestTheme {
//        Greeting("Android")
    }
}