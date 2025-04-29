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

- **Propósito**: Genera archivos de texto `.txt` que contienen datos aleatorios, simulando registros de personas.
- **Método principal**:
  - `public static void generateInfo(int cantidadRegistros)`:
    Genera un número especificado de registros (cantidad de líneas), cada uno compuesto por:
    - Un nombre aleatorio.
    - Una cédula aleatoria.
    - Un número de teléfono aleatorio.
    - Una dirección de correo aleatoria.
- **Detalles del funcionamiento**:
  - Usa arreglos predefinidos de nombres y apellidos para construir los nombres completos.
  - Usa funciones auxiliares internas (no métodos separados) para:
    - Generar números aleatorios para cédulas y teléfonos.
    - Construir correos electrónicos basados en los nombres.
  - Cada registro es escrito línea a línea en un archivo `info.txt`.

### `Main.java`

- **Propósito**: Clase principal que ejecuta la generación de datos.
- **Método principal**:
  - `public static void main(String[] args)`:
  - Llama a `GenerateInfoFiles.generateInfo(10)`, generando 10 registros aleatorios.
  - Muestra un mensaje de éxito una vez terminado el proceso.
---

## 👥 Contribuidores

- [Angello Hernández](https://github.com/AngelloHernandez)
- [Jleand13](https://github.com/Jleand13)
- [Christian-Pemberty](https://github.com/Christian-Pemberty)

---

## 📄 Licencia

GNU GENERAL PUBLIC LICENSE
Version 3, 29 June 2007

Copyright (C) 2025 Angello Hernández, Jleand13, Christian-Pemberty

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <https://www.gnu.org/licenses/>.

---
