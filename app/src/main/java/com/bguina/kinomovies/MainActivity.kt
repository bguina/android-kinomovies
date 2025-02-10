@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package com.bguina.kinomovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation.NavigableListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.ThreePaneScaffoldNavigator
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bguina.kinomovies.ui.details.DetailsPane
import com.bguina.kinomovies.ui.list.ListPane
import com.bguina.kinomovies.ui.theme.KinomoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KinomoviesTheme {
                KinoMoviesApp()
            }
        }
    }
}

@Composable
fun KinoMoviesApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val navigator: ThreePaneScaffoldNavigator<Any> = rememberListDetailPaneScaffoldNavigator<Any>()
        NavigableListDetailPaneScaffold(
            modifier = Modifier.padding(innerPadding),
            navigator = navigator,
            listPane = { ListPane(navigator) },
            detailPane = { DetailsPane(navigator) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    KinomoviesTheme {
        KinoMoviesApp()
    }
}
