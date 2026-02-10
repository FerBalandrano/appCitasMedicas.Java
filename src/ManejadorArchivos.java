import java.io.*;
import java.util.*;

public class ManejadorArchivos {
    private static final String[] RUTAS = {
            "db/doctores.csv",
            "db/pacientes.csv",
            "db/citas.csv"
    };

    public static void inicializarBaseDeDatos() {
        File carpeta = new File("db");

        // Validación de si existe la carpeta, y si no, crearla
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        // Regenerar archivos faltantes
        for (String ruta : RUTAS) {
            File archivo = new File(ruta);
            if (!archivo.exists()) {
                try {
                    archivo.createNewFile();
                    System.out.println("Archivo regenerado: " + ruta);
                } catch (IOException e) {
                    System.err.println("Error al crear el archivo: " + ruta);
                }
            }
        }
    }


    // Limpia comas para evitar errores en el CSV
    public static String limpiar(String texto) {
        if (texto == null) return "";
        return texto.replace(",", "-");
    }

    public static void guardarEnCSV(String nombreArchivo, String linea) {
        try (FileWriter fw = new FileWriter(nombreArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(linea);
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }
    }

    public static boolean existeID(String archivo, String idBuscado) {
        File f = new File(archivo);
        if (!f.exists()) return false;
        try (Scanner lector = new Scanner(f)) {
            while (lector.hasNextLine()) {
                String[] columnas = lector.nextLine().split(",");
                if (columnas[0].equals(idBuscado)) return true;
            }
        } catch (FileNotFoundException e) {
            return false;
        }
        return false;
    }
}