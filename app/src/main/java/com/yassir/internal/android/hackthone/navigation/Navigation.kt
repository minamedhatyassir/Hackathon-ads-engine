//package com.mina.moviesapp.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.*
//import androidx.navigation.compose.composable
//
//sealed class Screen(val route: String) {
//    object List : Screen("list")
//    class CustomRoute(route: String) : Screen(route)
//}
//
//class NavActions(private val navigator: ScreenNavigator) {
//    fun goToList() = navigator.navigate(Screen.List)
//    fun goToDetails(id: Int) = navigator.navigate(Screen.CustomRoute("details/$id"))
//    fun pop() = navigator.pop()
//}
//
//class ScreenNavigator(private val navController: NavController) {
//    fun navigate(screen: Screen) = navController.navigate(screen.route)
//    fun pop() = navController.popBackStack()
//}
//
//fun NavGraphBuilder.addScreen(
//    screen: Screen,
//    args: List<NamedNavArgument> = emptyList(),
//    content: @Composable (NavBackStackEntry) -> Unit
//) =
//    composable(screen.route,args) {
//        content(it)
//    }
