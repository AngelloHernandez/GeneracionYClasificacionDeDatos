import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
* Clase para generar archivos de prueba pseudoaleatorios para el proyecto.
* @author Angelo Hernández
*/
public class GenerateInfoFiles {
   private static final String[] FIRST_NAMES = {"Ana", "Carlos", "Diana", "Eduardo", "Fernanda"};
   private static final String[] LAST_NAMES = {"Gómez", "López", "Martínez", "Rodríguez", "Pérez"};
   private static final String[] PRODUCT_NAMES = {"Laptop", "Teléfono", "Tablet", "Monitor", "Teclado"};
   private static final Random random = new Random();

   public static void main(String[] args) {
       try {
           // Generar archivos de prueba
           createSalesManInfoFile(5);       // 5 vendedores
           createProductsFile(10);          // 10 productos
           createSalesMenFile(3, "Juan", 123456789); // 3 ventas para Juan
           
           System.out.println("Archivos generados exitosamente.");
       } catch (IOException e) {
           System.err.println("Error al generar archivos: " + e.getMessage());
       }
   }

   /**
    * Crea un archivo con información de vendedores.
    * @param salesmanCount Número de vendedores a generar.
    */
   public static void createSalesManInfoFile(int salesmanCount) throws IOException {
       try (FileWriter writer = new FileWriter("salesmen_info.txt")) {
           for (int i = 0; i < salesmanCount; i++) {
               String docType = (i % 2 == 0) ? "CC" : "CE";
               long docNumber = 1000000000L + i;
               String name = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
               String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
               writer.write(String.format("%s;%d;%s;%s\n", docType, docNumber, name, lastName));
           }
       }
   }

   /**
    * Crea un archivo con información de productos.
    * @param productsCount Número de productos a generar.
    */
   public static void createProductsFile(int productsCount) throws IOException {
       try (FileWriter writer = new FileWriter("products_info.txt")) {
           for (int i = 1; i <= productsCount; i++) {
               String productName = PRODUCT_NAMES[random.nextInt(PRODUCT_NAMES.length)] + " " + i;
               double price = 50 + random.nextInt(500); // Precios entre 50 y 550
               writer.write(String.format("P%d;%s;%.2f\n", i, productName, price));
           }
       }
   }

   /**
    * Crea un archivo de ventas para un vendedor específico.
    * @param randomSalesCount Número de ventas a generar.
    * @param name Nombre del vendedor.
    * @param id Número de documento del vendedor.
    */
   public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {
       String fileName = "sales_" + name + "_" + id + ".txt";
       try (FileWriter writer = new FileWriter(fileName)) {
           writer.write("CC;" + id + "\n"); // Cabecera con tipo y número de documento
           
           for (int i = 0; i < randomSalesCount; i++) {
               String productId = "P" + (1 + random.nextInt(10)); // IDs de P1 a P10
               int quantity = 1 + random.nextInt(10); // Cantidad entre 1 y 10
               writer.write(String.format("%s;%d;\n", productId, quantity));
           }
       }
   }
}

