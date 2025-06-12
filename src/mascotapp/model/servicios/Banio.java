package mascotapp.model.servicios;

import mascotapp.enums.EstadoServicios;
import mascotapp.util.Loggable;

/**
 * Clase Banio que implementa la interfaz Servicios y Loggable.
 * Crea un servicio de baño para mascotas y calcula su precio.
 */
public class Banio implements Servicios, Loggable {
  private double pesoMascota;
  private EstadoServicios estados = EstadoServicios.PENDIENTE;

  /**
   * Constructor de la clase Banio.
   *
   * @param pesoMascota Peso de la mascota
   */
  public Banio(double pesoMascota) {
    this.pesoMascota = pesoMascota;
  }

  @Override
  public void aplicarServicio() {
    log().info("Aplicando baño...");
    this.estados = EstadoServicios.APLICADO;
  }

  public EstadoServicios getEstado() {
    return estados;
  }

  @Override
  public double calcularPrecio() {
    return pesoMascota > 10 ? 6000.0 : 5000.0;
  }
}

