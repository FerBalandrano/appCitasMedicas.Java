public class Paciente extends Persona {

    public Paciente(String id, String nombre, String fechaNacimiento, String contacto) {
        super(id, nombre, fechaNacimiento, contacto);
    }

    public String toCSV() {
        return getId() + "," +
                getNombre() + "," +
                getFechaNacimiento() + "," +
                getContacto();
    }
}
