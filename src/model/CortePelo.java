package model;


/**
 * Clase CortePelo que implementa la interfaz Servicios y Loggable.
 * Crea un servicio de corte de pelo para mascotas y calcula su precio.
 */
public class CortePelo implements Servicios, Loggable {
  private double pesoMascota;

  @Override
  public void aplicarServicio() {
    log().info("Cortando pelo...");
  }

  @Override
  public double calcularPrecio() {
    return pesoMascota > 10 ? 4000.0 : 3000.0;
  }
}
