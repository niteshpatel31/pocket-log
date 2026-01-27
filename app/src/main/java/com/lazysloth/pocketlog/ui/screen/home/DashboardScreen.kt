package com.lazysloth.pocketlog.ui.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lazysloth.pocketlog.R
import com.lazysloth.pocketlog.ui.ApplicationBottomNavigation
import com.lazysloth.pocketlog.ui.screen.contentscreen.DashboardScreenContent
import com.lazysloth.pocketlog.ui.theme.PocketLogTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = ApplicationBottomNavigation.HOME.name,
//                        modifier = Modifier.padding(20.dp)
                )
            }, actions = {
                IconButton(content = {
                    Icon(
                        painter = painterResource(R.drawable.settings_24px),
                        contentDescription = stringResource(R.string.settings),
                    )
                }, onClick = {}

                )
            })
        }) {
        DashboardScreenContent(Modifier.padding(it))
    }
}


@Preview(showSystemUi = true)
@Composable
fun DashboardPreview() {
    PocketLogTheme { DashboardScreen() }
}