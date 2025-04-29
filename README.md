# Generación y Clasificación de Datos

Aplicación en **Java** para la generación y clasificación automática de datos aleatorios, utilizando programación orientada a objetos y estructuras de datos.

---

## 📂 Contenido del Repositorio

- `src/`: Código fuente.
- `bin/`: Archivos compilados.
- `.classpath`, `.project`: Configuración para Eclipse IDE.
- `.settings/`: Preferencias del proyecto.

---

## ⚙️ Requisitos

- **Java JDK 8** o superior.
- **Eclipse IDE** (opcional, recomendado).
- **Sistema operativo**: Windows, Linux o macOS.

---

## 🚀 Instalación y Ejecución

### Clonar el repositorio

```bash
git clone https://github.com/AngelloHernandez/GeneracionYClasificacionDeDatos.git
```

### Importar en Eclipse

- `File > Import > Existing Projects into Workspace`
- Seleccionar la carpeta del proyecto.

### Compilar y ejecutar manualmente

```bash
javac -d bin src/**/*.java
java -cp bin Main
```
_(El punto de entrada del proyecto es la clase `Main`.)_

---

## 📋 Funcionamiento

- **Generación de datos** aleatorios simulando registros.
- **Clasificación** automática de los datos generados.
- **Visualización** de resultados en consola.

---

## 🧩 Estructura del Código

### Clases principales

| Clase | Descripción |
|:------|:------------|
| `GenerateInfoFiles` | Se encarga de generar archivos `.txt` que contienen datos de prueba aleatorios. Incluye métodos para crear nombres, correos, números de teléfono y cédulas aleatorias. |
| `Main` | Clase principal que orquesta la ejecución del programa. Llama a los métodos de `GenerateInfoFiles` para crear los datos y muestra mensajes de control en la consola. |

---

## 📚 Documentación de Clases

### `GenerateInfoFiles.java`

- **Propósito**: Automatiza la generación de múltiples archivos de texto con datos ficticios para pruebas o entrenamiento de modelos.
- **Funciones principales**:
  - `generateNames()`: Genera nombres aleatorios.
  - `generateEmails()`: Crea direcciones de correo simuladas.
  - `generatePhoneNumbers()`: Genera números de teléfono válidos.
  - `generateIDs()`: Crea números de identificación únicos.
  - `generateFiles()`: Función principal que combina los métodos anteriores para escribir los datos en archivos.

### `Main.java`

- **Propósito**: Funciona como el controlador del programa.
- **Responsabilidades**:
  - Llama al método `generateFiles()` de la clase `GenerateInfoFiles`.
  - Muestra mensajes en consola sobre el estado del proceso de generación.
  - Controla la ejecución general del flujo del programa.

---

## 👥 Contribuidores

- [Angello Hernández](https://github.com/AngelloHernandez)
- [Jleand13](https://github.com/Jleand13)
- [Christian-Pemberty](https://github.com/Christian-Pemberty)

---

## 📄 Licencia

Actualmente no se especifica una licencia para este proyecto.

---
