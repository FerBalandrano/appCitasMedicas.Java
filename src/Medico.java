public class Medico extends Persona {
    private String especialidad;
    private String cedula;

    public Medico(String id, String nombre, String fechaNacimiento, String contacto, String especialidad, String cedula) {
        super(id, nombre, fechaNacimiento, contacto); //aquí estoy llamando al constructor de Persona porque Medico hereda todos los atributos de Persona.
        this.especialidad = especialidad;
        this.cedula = cedula;
    }

    public String getCedula() { return cedula; }
    public String getEspecialidad() { return especialidad; }

    public String toCSV() {
        return getId() + "," +
                getNombre() + "," +
                getFechaNacimiento() + "," +
                getContacto() + "," +
                getCedula() + "," +
                getEspecialidad();
    }

    // El objetivo de este metodo es guardar la información en un CSV que es donde guardaremos la información de los registros.
}