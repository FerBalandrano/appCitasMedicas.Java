import java.io.*;
import java.util.*;

public class ManejadorArchivos {

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