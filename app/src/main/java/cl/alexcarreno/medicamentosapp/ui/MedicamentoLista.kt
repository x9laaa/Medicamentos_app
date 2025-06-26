package cl.alexcarreno.medicamentosapp.ui


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.hilt.navigation.compose.hiltViewModel
import cl.alexcarreno.medicamentosapp.viewmodel.MedicamentoViewModel

@Composable
fun MedicamentoLista(
    navController: NavHostController,
    viewModel: MedicamentoViewModel = hiltViewModel()
) {

    val listaMedicamentos by viewModel.lista.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("formulario") }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar medicamento")
            }
        }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(listaMedicamentos) { med ->
                MedicamentoCard(med)
            }
        }
    }
}