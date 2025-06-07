package model;

/**
 * Clase LimpiezaOido que implementa la interfaz Servicios y Loggable.
 * Crea un servicio de limpieza de oídos para mascotas y calcula su precio.
 */
public class LimpiezaOido implements Servicios, Loggable {
  private double tamanioMascota;

  @Override
  public void aplicarServicio() {
    log().info("Limpiando oídos...");
  }

  @Override
  public double calcularPrecio() {
    return tamanioMascota > 25 ? 2000.0 : 1000.0; // Precio basado en tamaño
  }
}
