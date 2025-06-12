package mascotapp.model.servicios;

import mascotapp.enums.EstadoServicios;
import mascotapp.util.Loggable;

/**
 * Clase LimpiezaOido que implementa la interfaz Servicios y Loggable.
 * Crea un servicio de limpieza de oídos para mascotas y calcula su precio.
 */
public class LimpiezaOido implements Servicios, Loggable {
  private double tamanioMascota;
  private EstadoServicios estados = EstadoServicios.PENDIENTE;

  /**
   * Constructor de la clase LimpiezaOido.
   *
   * @param tamanioMascota Tamaño de la mascota
   */
  public LimpiezaOido(double tamanioMascota) {
    this.tamanioMascota = tamanioMascota;
  }

  @Override
  public void aplicarServicio() {
    log().info("Limpiando oídos...");
    this.estados = EstadoServicios.APLICADO;
  }

  public EstadoServicios getEstados() {
    return estados;
  }

  @Override
  public double calcularPrecio() {
    return tamanioMascota > 25 ? 2000.0 : 1000.0; // Precio basado en tamaño
  }
}
