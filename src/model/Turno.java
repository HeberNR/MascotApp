package model;

/**
 * Clase Turno que representa una cita o turno en un sistema de gestión de mascotas.
 * Esta clase implementa la interfaz Loggable para registrar eventos relacionados con los turnos.
 */
public class Turno implements Loggable {

  private final String id;
  private String fecha;
  private String hora;
  private static int contadorTurnos = 0;
  private Perro perro;
  private Gato gato;
  private Mascota mascota;
  private Duenio duenio;
  private Servicios servicio;

  /**
   * Constructor de la clase Turno.
   * Genera un ID único para cada turno basado en un contador estático.
   *
   * @param fecha Fecha del turno en formato "dd/MM/yyyy".
   * @param hora  Hora del turno en formato "HH:mm".
   */
  public Turno(String fecha, String hora) {
    this.id = "TURNO-" + contadorTurnos++;
    this.fecha = fecha;
    this.hora = hora;
  }

  /**
   * Método para obtener el ID del turno.
   *
   * @return ID del turno.
   */
  public String getid() {
    return id;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getHora() {
    return hora;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Turno turno = (Turno) obj;
    return id.equals(turno.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return "Turno {\n"
        + "    id   = '" + id + "'\n"
        + "    fecha = '" + fecha + "'\n"
        + "    hora  = '" + hora + "'\n"
        + "}";
  }

  public static void setContadorTurnos(int contadorTurnos) {
    Turno.contadorTurnos = contadorTurnos;
  }

  /**
   * Método para confirmar un turno.
   * Registra un mensaje de confirmación en el log.
   */
  public void confirmarTurno() {
    log().info("Turno confirmado para: "); // falta agregar detalles del turno
  }

  /**
   * Metodo para mostrar detalles de la mascota.
   */
  public void mostrarDetalles() {
    if (perro == null && gato == null) {
      log().info("No hay detalles de mascotas disponibles.");
      return;
    } else if (perro != null) {
      mascota = perro;
    } else {
      mascota = gato;
    }

    log().info("Detalles del Turno: "
        + "Fecha: " + fecha
        + " Hora: " + hora
        + " Mascota: " + mascota
        + " Dueño: " + duenio.getNombre()
        + " Servicio: "); // falta agregar detalles del servicio
  }
}
