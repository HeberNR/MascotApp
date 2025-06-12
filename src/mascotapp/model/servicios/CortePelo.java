package mascotapp.model.servicios;


import mascotapp.enums.EstadoServicios;
import mascotapp.util.Loggable;

/**
 * Clase CortePelo que implementa la interfaz Servicios y Loggable.
 * Crea un servicio de corte de pelo para mascotas y calcula su precio.
 */
public class CortePelo implements Servicios, Loggable {
  private double pesoMascota;
  private EstadoServicios estados = EstadoServicios.PENDIENTE;

  /**
   * Constructor de la clase CortePelo.
   *
   * @param pesoMascota Peso de la mascota
   */
  public CortePelo(double pesoMascota) {
    this.pesoMascota = pesoMascota;
  }

  @Override
  public void aplicarServicio() {
    log().info("Cortando pelo...");
    this.estados = EstadoServicios.APLICADO;
  }

  public EstadoServicios getEstados() {
    return estados;
  }

  @Override
  public double calcularPrecio() {
    return pesoMascota > 10 ? 4000.0 : 3000.0;
  }
}
