package mascotapp.model.servicios;

import mascotapp.enums.EstadoServicios;
import mascotapp.util.Loggable;

/**
 * Clase ComboCompleto que implementa la interfaz Servicios y Loggable.
 * Crea un combo de servicios para mascotas que incluye baño, corte de pelo y limpieza de oídos.
 */
public class ComboCompleto implements Servicios, Loggable {

  private Servicios banio;
  private Servicios cortePelo;
  private Servicios limpiezaOidos;
  private EstadoServicios estados = EstadoServicios.PENDIENTE;

  /**
   * Constructor de la clase ComboCompleto.
   *
   * @param banio         Banio
   * @param cortePelo     CortePelo
   * @param limpiezaOidos LimpiezaOidos
   */
  public ComboCompleto(Servicios banio, Servicios cortePelo, Servicios limpiezaOidos) {
    this.banio = banio;
    this.cortePelo = cortePelo;
    this.limpiezaOidos = limpiezaOidos;
  }

  @Override
  public void aplicarServicio() {
    banio.aplicarServicio();
    cortePelo.aplicarServicio();
    limpiezaOidos.aplicarServicio();
  }

  @Override
  public double calcularPrecio() {
    return banio.calcularPrecio()
        + cortePelo.calcularPrecio()
        + limpiezaOidos.calcularPrecio();
  }
}
