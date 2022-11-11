//package com.mina.moviesapp.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.navArgument
//import com.mina.moviedetails.compose.MoviesDetailsScreen
//import com.mina.movieslist.compose.MoviesListScreen
//
//@Composable
//fun NavigationRoot() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = Screen.List.route) {
//        val navActions = NavActions(ScreenNavigator(navController))
//        addScreen(Screen.CustomRoute("details/{id}"), detailsArguments) {
//            val id = it.arguments?.getInt("id")!!
//            MoviesDetailsScreen(navActions::pop, id)
//        }
//        addScreen(Screen.List) {
//            MoviesListScreen(navActions::goToDetails)
//        }
//    }
//}
//
//val detailsArguments = listOf(
//    navArgument("id") {
//        type = NavType.IntType
//    })