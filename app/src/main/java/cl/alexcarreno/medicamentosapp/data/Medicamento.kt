package cl.alexcarreno.medicamentosapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicamentos")
data class Medicamento(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val tipo: String,
    val cantidad: String,
    val horario: String,
    val periodicidad: String
)