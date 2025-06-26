package cl.alexcarreno.medicamentosapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cl.alexcarreno.medicamentosapp.R
import cl.alexcarreno.medicamentosapp.data.Medicamento


@Composable
fun MedicamentoCard(medicamento: Medicamento) {
    val iconResId = when (medicamento.tipo.uppercase()) {
        stringResource(R.string.tipo_topico) -> R.drawable.botella
        stringResource(R.string.tipo_oral) -> R.drawable.pastilla
        stringResource(R.string.tipo_inhalado) -> R.drawable.inhalador
        else -> R.drawable.pastilla
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = iconResId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .padding(end = 8.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = medicamento.nombre,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Text(text = medicamento.horario, style = MaterialTheme.typography.bodyMedium)
            Text(text = medicamento.cantidad, style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "${stringResource(R.string.cada)} ${medicamento.periodicidad}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}