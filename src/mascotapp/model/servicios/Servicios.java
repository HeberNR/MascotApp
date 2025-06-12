package mascotapp.model.servicios;

/**
 * Interfaz Servicios que define los métodos necesarios para aplicar un servicio.
 */
public interface Servicios {
  /**
   * Aplica el servicio.
   */
  void aplicarServicio();

  /**
   * Calcula el precio del servicio.
   */
  double calcularPrecio();
}
