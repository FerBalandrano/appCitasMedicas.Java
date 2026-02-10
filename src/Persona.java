public class Persona {
    protected String id;
    protected String nombre;
    protected String fechaNacimiento;
    protected String contacto;

    public Persona(String id, String nombre,String fechaNacimiento, String contacto) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.contacto = contacto;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getFechaNacimiento() {return fechaNacimiento; }
    public String getContacto() {return contacto; }
}