package com.random.user.screens.navigation

sealed class NavigationRoute(val route: String) {
    data object UsersScreen : NavigationRoute("users_screen")
    data object ProfileScreen : NavigationRoute("profile_screen")
}