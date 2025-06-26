package cl.alexcarreno.medicamentosapp.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Medicamento::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun medicamentoDao(): MedicamentoDao
}