import java.util.*;

public class SistemaCitasMedicas {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean programaActivo = true;
        boolean autenticado = false;

        while (!autenticado) {
            System.out.println("=== SISTEMA MÉDICO LOGIN ===");
            System.out.print("Usuario: ");
            String user = sc.nextLine();
            System.out.print("Password: ");
            String pass = sc.nextLine();

            if (user.equals("admin") && pass.equals("1234")) {
                autenticado = true;
            } else {
                System.out.println("Error. Intente de nuevo.");
            }
        }

        while (programaActivo) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Registrar Persona\n2. Agendar Cita\n3. Salir");
            String op = sc.nextLine();

            if (op.equals("1")) registrar();
            else if (op.equals("3")) programaActivo = false;
        }
    }

    public static void registrar() {
        System.out.print("Nombre: ");
        String nombre = ManejadorArchivos.limpiar(sc.nextLine());
        System.out.print("Fecha Nacimiento: ");
        String fecha = ManejadorArchivos.limpiar(sc.nextLine());
        System.out.print("Contacto: ");
        String contacto = ManejadorArchivos.limpiar(sc.nextLine());
        System.out.print("¿Es Médico? (S/N): ");
        String esDoc = sc.nextLine();

        String id = UUID.randomUUID().toString().substring(0, 5);

        if (esDoc.equalsIgnoreCase("S")) {
            System.out.print("Cédula: ");
            String cedula = ManejadorArchivos.limpiar(sc.nextLine());
            System.out.print("Especialidad: ");
            String esp = ManejadorArchivos.limpiar(sc.nextLine());

            Medico m = new Medico(id, nombre, fecha, contacto, cedula, esp);
            ManejadorArchivos.guardarEnCSV("doctores.csv", m.toCSV());
        } else {
            Paciente p = new Paciente(id, nombre, fecha, contacto);
            ManejadorArchivos.guardarEnCSV("pacientes.csv", p.toCSV());
        }
        System.out.println("Guardado con ID: " + id);
    }
}