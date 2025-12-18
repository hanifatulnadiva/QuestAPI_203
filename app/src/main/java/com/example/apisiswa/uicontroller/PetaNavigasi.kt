package com.example.apisiswa.uicontroller

import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apisiswa.view.EntrySiswaScreen
import com.example.apisiswa.view.HomeScreen

@Composable
fun DataSiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    HostNavigasi(
        navController = navController,
        modifier = modifier
    )
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { /* id -> navController.navigate("${DestinasiDetail.route}/$id") */ }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                // Gunakan popBackStack agar kembali ke halaman sebelumnya dengan benar
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}