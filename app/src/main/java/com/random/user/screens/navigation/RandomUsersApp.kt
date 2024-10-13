package com.random.user.screens.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.random.user.data.domain.UserProfile
import com.random.user.screens.profile.ProfileScreen
import com.random.user.screens.users.UsersScreen
import com.random.user.utils.ArgumentNavType
import timber.log.Timber

@Composable
fun RandomUserApp() {
    val navController = rememberNavController()
    val startDestination = NavigationRoute.UsersScreen.route
    var userProfile = remember {
        UserProfile()
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = startDestination) {
            UsersScreen(
                onUserClicked = {
                    userProfile = it
                    navController.navigate(NavigationRoute.ProfileScreen.route)
                }
            )
        }

        composable(
            route = NavigationRoute.ProfileScreen.route,
        ) {
            ProfileScreen(userProfile = userProfile)
        }
    }
}