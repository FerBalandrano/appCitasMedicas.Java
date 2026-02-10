public class Cita {
    private String idCita;
    private String fechaHora;
    private String motivo;
    private String idPaciente;
    private String idMedico;
    private String estado;

    public Cita(String idCita, String fechaHora, String motivo, String idPaciente, String idMedico, String estado) {
        this.idCita = idCita;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.estado = estado;
    }

    public String toCSV() {
        return idCita + "," +
                fechaHora + "," +
                motivo + "," +
                idPaciente + "," +
                idMedico + "," +
                estado;
    }
}
