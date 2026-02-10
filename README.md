## App de citas médicas construida en Java 🚀

### Acerca de
Este proyecto tiene el objetivo de crear una app en Java para agendar citas médicas.
La app tiene la capacidad de registrar pacientes y doctores, así como agendar citas para los pacientes con base en la especialidad médica que requieran.

<img width="1248" height="938" alt="image" src="https://github.com/user-attachments/assets/4057c308-9962-4664-bb6e-254ff27b5b6e" />


### Uso del programa

El programa cuenta con un inicio de sesión, para el cual se utiliza el usuario "admin", seguido de eso hay un menú que ofrece 3 opciones: 
1. Registrar persona: Los pacientes y médicos comparten ciertos campos de registro como nombre, fecha de nacimiento y contacto, mientras que los médicos tienen datos adicionales como cédula y especialidad, para lo cual se valida en el registro si la persona es médico o no, lo que determina los siguientes pasos de registro.
2. Agendar cita: Se le solicita al usuario, en este caso el admin, ingresar el id del paciente (este Id se genera de manera automática al registrar a un paciente (el id se imprime en pantalla), luego se solicitan especialidad médica requerida y motivo de consulta. Al final se imprime en pantalla un mensaje de éxito confirmando la fecha y hora de la cita. (Idealmente, el sistema ofrecería opciones de cita de acuerdo con la especialidad, sin embargo, es una funcionalidad que se agregará más adelante).
3. Salir del programa: Cerrar la sesión.


<img width="471" height="881" alt="image" src="https://github.com/user-attachments/assets/aeb5280c-70d9-4da2-b7bd-3251eb287db2" />
