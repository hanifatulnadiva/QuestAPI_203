package com.example.apisiswa.uicontroller

import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.apisiswa.view.EntrySiswaScreen
import com.example.apisiswa.view.HalamanDetailSiswa
import com.example.apisiswa.view.HalamanEditSiswa
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
                navigateToItemDetail = { id -> navController.navigate("${DestinasiDetail.route}/$id") }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                // Gunakan popBackStack agar kembali ke halaman sebelumnya dengan benar
                navigateBack = { navController.popBackStack() }
            )
        }
        composable (DestinasiDetail.routeWithArgs, arguments = listOf(navArgument(DestinasiDetail.itemIdArg){type=
            NavType.IntType})
        ){
            HalamanDetailSiswa(navigateToEditItem = {navController.navigate("${DestinasiEdit.route}/$it")},
                navigateBack = {navController.navigate(DestinasiHome.route)})
        }

    }
}