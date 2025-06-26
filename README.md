# ControlMedicamentosApp

Aplicación móvil Android desarrollada con **Kotlin** y **Jetpack Compose** que permite registrar y controlar tratamientos médicos mediante una interfaz amigable, almacenamiento local con Room y arquitectura moderna basada en ViewModel.

## Características

- Registro de medicamentos con campos como nombre, tipo, cantidad y periodicidad.
- Listado dinámico de tratamientos usando `LazyColumn`.
- Uso de íconos para tipos de medicamentos: oral, tópico e inhalado.
- Soporte multilenguaje: español e inglés.
- Almacenamiento persistente usando Room y SQLite.
- Navegación entre pantallas usando `NavController`.
- Implementación de `ViewModel` y `StateFlow` para la lógica de presentación.
- Soporte para temas personalizados (Color, Tipografía, etc.).

##  Tecnologías y herramientas

- **Lenguaje**: Kotlin
- **UI**: Jetpack Compose
- **Persistencia**: Room + SQLite
- **Arquitectura**: MVVM con ViewModel
- **DI**: Dagger Hilt
- **Multilenguaje**: `strings.xml` en `values-es/` y `values-en/`