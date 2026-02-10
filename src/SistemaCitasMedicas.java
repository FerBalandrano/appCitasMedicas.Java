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

            if (op.equals("1")) {
                registrar();
            } else if (op.equals("2")) {
                agendarCita();
            } else if (op.equals("3")) {
                programaActivo = false;
                System.out.println("Cerrando sesión y saliendo del sistema...");
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public static void registrar() {
        System.out.print("Nombre: ");
        String nombre = ManejadorArchivos.limpiar(SistemaCitasMedicas.sc.nextLine());
        System.out.print("Fecha Nacimiento: ");
        String fecha = ManejadorArchivos.limpiar(sc.nextLine());
        System.out.print("Contacto: ");
        String contacto = ManejadorArchivos.limpiar(sc.nextLine());
        System.out.print("¿Es Médico? (S/N): ");
        String esDoc = sc.nextLine();

        String id = UUID.randomUUID().toString().substring(0, 5);

        if (esDoc.equalsIgnoreCase("S")) {
            System.out.print("Cédula: ");
            String cedula = ManejadorArchivos.limpiar(SistemaCitasMedicas.sc.nextLine());
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

    public static void agendarCita() {
        System.out.println("\n--- AGENDAR NUEVA CITA ---");

        // 1. Validar que el paciente existe antes de continuar
        System.out.print("Ingrese el ID del Paciente: ");
        String idPaciente = sc.nextLine();

        // Usamos el Manejador de Archivos para validar integridad de datos
        if (!ManejadorArchivos.existeID("pacientes.csv", idPaciente)) {
            System.out.println("Error: El ID de paciente no existe en los registros.");
            return; // Cortamos el flujo si no hay paciente válido
        }

        // 2. Solicitar Especialidad
        System.out.print("Ingrese la especialidad requerida: ");
        String especialidad = ManejadorArchivos.limpiar(sc.nextLine());

        // 3. Solicitar Motivo (Opcional pero recomendado para el registro)
        // Para evitar problemas de formato, lo limpiamos igual que los otros campos
        System.out.print("Motivo de la consulta: ");
        String motivo = ManejadorArchivos.limpiar(sc.nextLine());

        // 4. Generación automática de datos de la cita
        // Como asumimos disponibilidad, generamos un ID de cita y usamos una fecha fija o actual
        String idCita = UUID.randomUUID().toString().substring(0, 5);
        String fechaCita = "2026-02-15 10:00"; // Fecha simulada basada en disponibilidad total
        String idDoctorGenerico = "DOC-999"; // Doctor asignado por defecto para esta especialidad

        // 5. Crear objeto Cita y Guardar
        Cita nuevaCita = new Cita(idCita, fechaCita, motivo, idPaciente, idDoctorGenerico, "Ocupado");

        // Guardamos en el archivo de citas
        ManejadorArchivos.guardarEnCSV("citas.csv", nuevaCita.toCSV());

        System.out.println("\n¡ÉXITO!");
        System.out.println("La cita ha sido agendada.");
        System.out.println("ID Cita: " + idCita);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Fecha y Hora: " + fechaCita);
    }
}