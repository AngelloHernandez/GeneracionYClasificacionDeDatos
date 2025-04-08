//Librerías utilizadas:
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

/**
* Clase para generar archivos de reportes para el proyecto.
* @author LUIS ANGELO HERNANDEZ BLANCO
* @author JEISSON LEANDRO GUERRERO MOLANO
* @author CHRISTIAN CAMILO PEMBERTY VILLEGAS
*/
public class Main {

     /**
     * Método principal que procesa los archivos de ventas y genera reportes.
     * 
     * Flujo de ejecución:
     * 1. Cargar productos desde products_info.csv
     * 2. Leer archivos de ventas en la carpeta "sales"
     * 3. Calcular ventas por vendedor y cantidad por producto
     * 4. Generar reportes en la carpeta "reportes"
     */
         
    public static void main(String[] args) {
        try {
            // Cargar precios y nombres de productos para poder enlazarlos al reporte:
            Map<String, Product> productMap = loadProducts("products_info.csv");

            // Mapas para acumular ventas
            Map<String, Double> vendedorVentas = new HashMap<>();
            Map<String, Integer> productoCantidad = new HashMap<>();

            //Revisamos si la carpeta "sales" ya está creada para leer los archivos internos
            File salesFolder = new File("sales");
            if (!salesFolder.exists()) {
                System.err.println("La carpeta 'sales' no existe.");
                return;
            }

            //Recorremos cada archivo y validamos que tenga nombre y que sea un archivo "CSV"
            for (File salesFile : salesFolder.listFiles()) {
                if (salesFile.isFile() && salesFile.getName().endsWith(".csv")) {
                    // Nombre del vendedor e ID del archivo
                    String fileName = salesFile.getName(); // ejemplo: sales_Juan_123456789_1.csv
                    //Obtenemos el nombre y el documento de cada archivo
                    String[] parts = fileName.replace("sales_", "").replace(".csv", "").split("_");
                    if (parts.length != 3) continue;
                    String name = parts[0];
                    String id = parts[1];
                    String indexFile = parts[2]; //no se usa
                    String keyVendedor = name + " " + id;

                    // Leer las líneas del archivo (saltando cabecera)
                    List<String> lines = Files.readAllLines(salesFile.toPath());
                    for (int i = 1; i < lines.size(); i++) {
                        String[] tokens = lines.get(i).split(";");
                        if (tokens.length != 2) continue;
                        String productId = tokens[0];
                        int quantity = Integer.parseInt(tokens[1]);

                        // Actualizar ventas por vendedor
                        Product p = productMap.get(productId);
                        if (p != null) {
                            double total = p.price * quantity;
                            vendedorVentas.put(keyVendedor, vendedorVentas.getOrDefault(keyVendedor, 0.0) + total);
                        }

                        // Actualizar cantidad vendida por producto
                        productoCantidad.put(productId, productoCantidad.getOrDefault(productId, 0) + quantity);
                    }
                }
            }

            // Crear carpeta 'reportes' si no existe
            File reportDir = new File("reportes");
            if (!reportDir.exists()) {
                if (reportDir.mkdirs()) {
                    System.out.println("Carpeta 'reportes' creada.");
                } else {
                    System.err.println("No se pudo crear la carpeta 'reportes'.");
                    return;
                }
            }

            // Crear archivo 1: reporte de ventas por vendedor
            try (FileWriter writer = new FileWriter("reportes/reporte_ventas_vendedores.csv")) {
                writer.write("Nombre;Total vendido\n");
                vendedorVentas.entrySet().stream()
                    .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                    .forEach(entry -> {
                        try {
                            writer.write(entry.getKey() + ";" + String.format("%.2f", entry.getValue()) + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
            }

            // Crear archivo 2: productos más vendidos
            try (FileWriter writer = new FileWriter("reportes/productos_mas_vendidos.csv")) {
                writer.write("Nombre;Precio;Cantidad\n");
                productoCantidad.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(entry -> {
                        Product p = productMap.get(entry.getKey());
                        if (p != null) {
                            try {
                                writer.write(p.name + ";" + String.format("%.2f", p.price) + ";" + entry.getValue() + "\n");
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
            }

            System.out.println("Archivos de reporte generados exitosamente en la carpeta 'reportes'.");

        } catch (Exception e) {
            System.err.println("Error procesando archivos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Clase interna que representa un producto con nombre y precio
    static class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    // Método para leer products_info.csv
    private static Map<String, Product> loadProducts(String filename) throws IOException {
        Map<String, Product> products = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get(filename));
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length == 3 && parts[0].startsWith("P")) {
                String id = parts[0];
                String name = parts[1];
                //Reemplazamos "," por "." para evitar conflictos
                double price = Double.parseDouble(parts[2].replace(",", "."));
                products.put(id, new Product(name, price));
            }
        }
        return products;
    }
}

