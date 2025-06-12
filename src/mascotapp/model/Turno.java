package mascotapp.model;

import mascotapp.model.servicios.Servicios;
import mascotapp.util.Loggable;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.time.LocalDate;

/**
 * Clase Turno que representa una cita o turno en un sistema de gestión de mascotas.
 * Esta clase implementa la interfaz Loggable para registrar eventos relacionados con los turnos.
 */
public class Turno implements Loggable {

  private final String id;
  private LocalDate fecha;
  private static int contadorTurnos = 0;
  private Mascota mascota;
  private Duenio duenio;
  private Servicios servicio;

  /**
   * Constructor de la clase Turno.
   * Genera un ID único para cada turno basado en un contador estático.
   *
   * @param fecha Fecha del turno en formato "dd/MM/yyyy".
   */
  public Turno(LocalDate fecha, Mascota mascota, Duenio duenio, Servicios servicio) {
    this.id = "TURNO-" + contadorTurnos++;
    this.fecha = fecha;
    this.mascota = mascota;
    this.duenio = duenio;
    this.servicio = servicio;
  }

  // Constructor sobrecargado sin dueño
  public Turno(LocalDate fecha, Mascota mascota, Servicios servicio) {
    this(fecha, mascota, null, servicio);
  }


  /**
   * Método para obtener el ID del turno.
   *
   * @return ID del turno.
   */
  public String getid() {
    return id;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public static void setContadorTurnos(int contadorTurnos) {
    Turno.contadorTurnos = contadorTurnos;
  }

  /**
   * Método para confirmar un turno.
   * Registra un mensaje de confirmación en el log.
   */
  public void confirmarTurno() {
    log().info("Turno confirmado: " + this);
    log().info("Precio del servicio: $" + servicio.calcularPrecio());
  }

  /**
   * Metodo para mostrar detalles de la mascota.
   */
  public void mostrarDetalles() {
    log().info("Detalles del Turno: " +
        "Fecha: " + fecha +
        ", Mascota: " + (mascota != null ? mascota.getNombre() : "No especificada") +
        ", Dueño: " + (duenio != null ? duenio.getNombre() : "No especificado") +
        ", Servicio: " + (servicio != null ? servicio.getClass().getSimpleName() : "No especificado"));
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Turno turno = (Turno) obj;
    return id.equals(turno.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return "Turno {\n" +
        "    id = '" + id + "',\n" +
        "    fecha = '" + fecha + "'\n" +
        "}";
  }
}
