package cl.alexcarreno.medicamentosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cl.alexcarreno.medicamentosapp.navigation.NavManager
import cl.alexcarreno.medicamentosapp.ui.theme.MedicamentosAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MedicamentosAppTheme {
                NavManager()
            }
        }
    }
}