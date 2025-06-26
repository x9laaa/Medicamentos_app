package cl.alexcarreno.medicamentosapp.navigation


import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.alexcarreno.medicamentosapp.ui.MedicamentoLista
import cl.alexcarreno.medicamentosapp.ui.MedicamentoRegistro
import cl.alexcarreno.medicamentosapp.viewmodel.MedicamentoViewModel

@Composable
fun NavManager() {
    val navController = rememberNavController()
    val viewModel: MedicamentoViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = "lista") {
        composable("lista") { MedicamentoLista(navController, viewModel) }
        composable("formulario") { MedicamentoRegistro(navController, viewModel) }
    }
}
