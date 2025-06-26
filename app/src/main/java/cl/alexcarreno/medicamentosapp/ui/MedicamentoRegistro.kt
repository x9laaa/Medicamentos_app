package cl.alexcarreno.medicamentosapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cl.alexcarreno.medicamentosapp.R
import cl.alexcarreno.medicamentosapp.data.Medicamento
import cl.alexcarreno.medicamentosapp.viewmodel.MedicamentoViewModel


@Composable
fun MedicamentoRegistro(navController: NavHostController? = null, viewModel: MedicamentoViewModel) {

    var nombre by remember { mutableStateOf("") }
    var dosis by remember { mutableStateOf("") }

    val tipos = listOf(stringResource(R.string.tipo_topico), stringResource(R.string.tipo_oral), stringResource(R.string.tipo_inhalado))
    var tipoSeleccionado by remember { mutableStateOf(tipos[0]) }

    val unidades = listOf(stringResource(R.string.mg), stringResource(R.string.pastillas), stringResource(R.string.ml))
    var unidadSeleccionada by remember { mutableStateOf(unidades[0]) }

    val periodicidad = listOf("c/8hrs", "c/12hrs", "c/24hrs")
    var periodicidadSeleccionada by remember { mutableStateOf(periodicidad[0]) }

    var horaSeleccionada by remember { mutableStateOf("") }
    var mostrarSelectorHora by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.registro_medicamento),
            style = MaterialTheme.typography.headlineSmall
        )

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text(stringResource(R.string.medicamento)) },
            modifier = Modifier.fillMaxWidth()
        )

        SegmentoSeleccion(tipos, tipoSeleccionado) { tipoSeleccionado = it }

        OutlinedTextField(
            value = dosis,
            onValueChange = { dosis = it },
            label = { Text(stringResource(R.string.dosis)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        SegmentoSeleccion(unidades, unidadSeleccionada) { unidadSeleccionada = it }

        Button(
            onClick = { mostrarSelectorHora = true },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Text(
                if (horaSeleccionada.isNotEmpty()) horaSeleccionada else stringResource(R.string.seleccionar_hora),
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        SegmentoSeleccion(periodicidad, periodicidadSeleccionada) { periodicidadSeleccionada = it }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val nuevo = Medicamento(
                nombre = nombre.trim(),
                tipo = tipoSeleccionado,
                cantidad = "$dosis $unidadSeleccionada",
                horario = horaSeleccionada,
                periodicidad = when (periodicidadSeleccionada) {
                    "c/8hrs" -> "8h"
                    "c/12hrs" -> "12h"
                    "c/24hrs" -> "24h"
                    else -> periodicidadSeleccionada
                }
            )
            viewModel.agregarMedicamento(nuevo)
            navController?.popBackStack()
        }) {
            Text(stringResource(R.string.guardar))
        }
    }

    if (mostrarSelectorHora) {
        SelectorHoraDialog(
            onDismiss = { mostrarSelectorHora = false },
            onConfirm = {
                horaSeleccionada = it
                mostrarSelectorHora = false
            }
        )
    }
}