@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package com.bguina.kinomovies.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.ThreePaneScaffoldNavigator
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListPane(navigator: ThreePaneScaffoldNavigator<Any>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp)) {
        items(100) {
            val title = "Movie $it"
            Text(
                title,
                modifier = modifier
                    .fillMaxWidth()
                    .clickable {
                        navigator.navigateTo(
                            pane = ListDetailPaneScaffoldRole.Detail,
                            content = title
                        )
                    }
                    .padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    ListPane(
        navigator = rememberListDetailPaneScaffoldNavigator<Any>(),
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
    )
}
