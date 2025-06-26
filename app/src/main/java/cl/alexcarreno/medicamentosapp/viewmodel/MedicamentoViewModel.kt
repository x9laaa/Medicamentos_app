package cl.alexcarreno.medicamentosapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.alexcarreno.medicamentosapp.data.Medicamento
import cl.alexcarreno.medicamentosapp.data.MedicamentoDao
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


@HiltViewModel
class MedicamentoViewModel @Inject constructor(
    private val dao: MedicamentoDao
) : ViewModel() {

    val lista: StateFlow<List<Medicamento>> = dao.obtenerTodos()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun agregarMedicamento(med: Medicamento) {
        viewModelScope.launch {
            dao.insertar(med)
        }
    }
}

