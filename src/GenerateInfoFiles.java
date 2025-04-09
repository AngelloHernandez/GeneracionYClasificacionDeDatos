import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
* Clase para generar archivos de reportes para el proyecto.
* Esta clase procesa los archivos de ventas, calcula las ventas por vendedor y las cantidades vendidas de productos,
* luego genera los reportes correspondientes.
* 
* El flujo de ejecución de este proceso es el siguiente:
* 1. Cargar los productos desde el archivo 'products_info.csv'.
* 2. Leer los archivos de ventas desde la carpeta "sales".
* 3. Calcular las ventas por vendedor y las cantidades por producto.
* 4. Generar reportes con la información procesada.
* 
* El reporte generado contiene dos archivos:
* reporte_ventas_vendedores.csv: Listado de ventas por vendedor.
* productos_mas_vendidos.csv: Listado de productos más vendidos.
* @author LUIS ANGELO HERNANDEZ BLANCO
* @author JEISSON LEANDRO GUERRERO MOLANO
* @author CHRISTIAN CAMILO PEMBERTY VILLEGAS
*/
public class GenerateInfoFiles {
	//Lista de nombres para generar los archivos
   private static final String[] FIRST_NAMES = {"Ana", "Carlos", "Diana", "Eduardo", "Fernanda", "Luis", "Marcela", "Hector", "Maria", "Camila", "Santiago", "Nicole", "Pedro", "Laura", "Ricardo", "Marcelo"};
   //Lista de apellidos para generar los archivos
   private static final String[] LAST_NAMES = {"Gómez", "López", "Martínez", "Rodríguez", "Pérez", "Hernández", "Fierro", "Orjuela", "Díaz", "Durán", "Leal", "Blanco", "Duarte"};
   //Lista de productos para generar los archivos
   private static final String[] PRODUCT_NAMES = {"Laptop", "Teléfono", "Tablet", "Monitor", "Teclado", "Mouse", "UPS", "Impresora", "SSD", "Dron"};
   //Inicializamos la clase Random
   private static final Random random = new Random();
/**
    * Método principal que genera los archivos de información necesarios para el proyecto.
    * 
    * Este método genera los archivos de vendedores y productos, además de crear los archivos
    * de ventas aleatorias para cada vendedor.
    * 
    * @param args Argumentos de la línea de comandos (no utilizados en esta implementación).
    */

   public static void main(String[] args) {
       try {
           // Aqui se generan los archivos de alimentación
           createSalesManInfoFile(5);       // 5 vendedores
           createProductsFile(10);          // 10 productos
           
           //En esta parte comprobamos si el archivo de vendedores se creó con exito
           File file = new File("salesmen_info.csv");
           if (!file.exists()) {
               System.out.println("El archivo 'salesmen_info.csv' no existe.");
               return;
           }
           
           //Procedemos a leer el archivo y pasamos por cada vendedor
           try (BufferedReader br = new BufferedReader(new FileReader(file))) {
               String linea;
               
               // saltamos la primera linea
               boolean esPrimeraLinea = true;

               while ((linea = br.readLine()) != null) {
                   if (esPrimeraLinea) {
                       esPrimeraLinea = false; // Saltar encabezado
                       continue;
                   }
                   // En esta parte separamos los datos para obtener los valores
                   String[] partes = linea.split(";");
                   if (partes.length < 4) continue;
                   
                   //con este obtenemos el nombre y el documento para pasar el parámentro a la función
                   String nombre = partes[2].trim();
                   long documento = Long.parseLong(partes[1].trim());

                   // Generamos entre 1 y 3 archivos de ventas por vendedor.
                   int cantidadArchivos = 1 + new Random().nextInt(3);
                   for (int i = 0; i < cantidadArchivos; i++) {
                       // Número aleatorio de ventas por archivo: entre 2 y 6
                       int ventas = 2 + new Random().nextInt(5);
                       createSalesMenFile(ventas, nombre, documento);
                   }
               }

               System.out.println("Ventas generadas exitosamente desde 'salesmen_info.csv'.");
           } catch (IOException e) {
               System.out.println("Error leyendo el archivo de vendedores.");
               e.printStackTrace();
           }
           
           // Llamada al método de la forma anterior para pruebas
           //createSalesMenFile(3, "Juan", 123456789); // 3 ventas para Juan
           
           System.out.println("Archivos generados exitosamente.");
       } catch (IOException e) {
           System.err.println("Error al generar archivos: " + e.getMessage());
       }
   }

   /**
    * Aqui el codigo crea un archivo con información de vendedores.
    * @param salesmanCount Número de vendedores a generar.
    */
   public static void createSalesManInfoFile(int salesmanCount) throws IOException {
       try (FileWriter writer = new FileWriter("salesmen_info.csv")) {
    	   // Crear encabezados
           writer.write("Tipo Documento;Numero Documento;Nombres;Apellidos\n");
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
       try (FileWriter writer = new FileWriter("products_info.csv")) {
    	   //Crear Encabezados
           writer.write("ID;Nombre;Precio");
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
	    File fdir = new File("sales");

	    // Crear carpeta "sales" si no existe
	    if (!fdir.exists()) {
	        if (fdir.mkdirs()) {
	            System.out.println("Carpeta 'sales' creada");
	        } else {
	            System.out.println("Falló la creación de la carpeta 'sales'");
	            return;
	        }
	    }

	    // Contar cuántos archivos existen para ese vendedor (que empiecen con el nombre y el id y terminen en .csv)
	    String baseName = "sales_" + name + "_" + id;
	    File[] existingFiles = fdir.listFiles((dir, filename) -> filename.startsWith(baseName) && filename.endsWith(".csv"));
	    int index = (existingFiles != null) ? existingFiles.length : 0;

	    // Crear el nuevo archivo con el índice correspondiente
	    String fileName = "sales/" + baseName + "_" + index + ".csv";
	    try (FileWriter writer = new FileWriter(fileName)) {
	        writer.write("ID;Cantidad vendida\n");
	        for (int i = 0; i < randomSalesCount; i++) {
	            String productId = "P" + (1 + random.nextInt(10)); // P1 a P10
	            int quantity = 1 + random.nextInt(10); // 1 a 10 unidades
	            writer.write(String.format("%s;%d\n", productId, quantity));
	        }
	        System.out.println("Archivo creado: " + fileName);
	    } catch (IOException e) {
	        System.out.println("Error escribiendo archivo: " + fileName);
	        e.printStackTrace();
	    }
	}

}



