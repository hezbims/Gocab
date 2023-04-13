package com.example.gocab.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.gocab.screen.form_ojek_screen.FormOjekScreen
import com.example.gocab.screen.form_ojek_screen.FormOjekViewModel
import com.example.gocab.screen.main_screen.MainScreen

@Composable
fun GocabNavigationHost(navController : NavHostController){
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.mainNavRoute
    ){
        navigation(
            startDestination = NavigationRoute.homeRoute,
            route = NavigationRoute.mainNavRoute
        ) {
            composable(
                route = NavigationRoute.homeRoute
            ) {
                MainScreen(navController = navController)
            }

            composable(
                route = NavigationRoute.formOjekRoute
            ) {
                val rootBackStackEntry = remember(it) {
                    navController.getBackStackEntry(NavigationRoute.mainNavRoute)
                }

                val viewModel : FormOjekViewModel = hiltViewModel(rootBackStackEntry)

                FormOjekScreen(
                    viewModel = viewModel
                )
            }
        }
    }
}