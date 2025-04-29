# Proyecto de Generación y Procesamiento de Reportes de Ventas

Este proyecto permite la **generación automática** de archivos de ventas simuladas y el **procesamiento de dichos archivos** para producir reportes:

- **Archivo de vendedores** (`salesmen_info.csv`)
- **Archivo de productos** (`products_info.csv`)
- **Archivos de ventas individuales** para cada vendedor (`sales/`)
- **Reportes de ventas por vendedor** y **productos más vendidos** (`reportes/`)

---
## 🛠️ Estructura del Proyecto

| Carpeta / Archivo         | Descripción                                        |
|----------------------------|----------------------------------------------------|
| `GenerateInfoFiles.java`   | Clase que genera vendedores, productos y ventas.   |
| `Main.java`                | Clase que procesa ventas y genera reportes finales.|
| `sales/`                   | Carpeta con archivos de ventas generados.          |
| `reportes/`                | Carpeta donde se almacenan los reportes finales.   |
| `products_info.csv`        | Información de productos generados.                |
| `salesmen_info.csv`        | Información de vendedores generados.               |

---

## 📚 Clases y Funciones

### `GenerateInfoFiles`
Clase que genera los datos de vendedores, productos y ventas aleatorias.

| Método | Descripción |
|:------:|:------------|
| `main(String[] args)` | Ejecuta la generación completa de archivos de prueba. |
| `createSalesManInfoFile(int salesmanCount)` | Crea un archivo CSV de vendedores. |
| `createProductsFile(int productsCount)` | Crea un archivo CSV de productos. |
| `createSalesMenFile(int randomSalesCount, String name, long id)` | Crea archivos de ventas para un vendedor dado. |

---

### `Main`
Clase que procesa los archivos de ventas generados y crea los reportes.

| Método | Descripción |
|:------:|:------------|
| `main(String[] args)` | Procesa todos los archivos de ventas para generar reportes. |
| `loadProducts(String filename)` | Carga los productos desde el archivo CSV. |
| `Product` (clase interna) | Representa un producto (nombre y precio). |

---

## ⚙️ Requisitos

- **Java 8** o superior.
- No requiere dependencias externas.

---

## 🚀 Cómo Ejecutarlo

1. Compilar los archivos:

```bash
javac GenerateInfoFiles.java
javac Main.java
```
2. Ejecutar primero la generación de datos:

```bash
java GenerateInfoFiles
```
3. Luego procesar los datos para generar los reportes:
```bash
java Main
```
---

## 👥 Contribuidores

- [Angello Hernández](https://github.com/AngelloHernandez)
- [Jleand13](https://github.com/Jleand13)
- [Christian-Pemberty](https://github.com/Christian-Pemberty)

---

## 📄 Licencia
Este proyecto está licenciado bajo los términos de la GNU General Public License v3.0. <https://www.gnu.org/licenses/>.

---
