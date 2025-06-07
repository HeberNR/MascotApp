package model;

/**
 * Clase Banio que implementa la interfaz Servicios y Loggable.
 * Crea un servicio de baño para mascotas y calcula su precio.
 */
public class Banio implements Servicios, Loggable {
  private double pesoMascota;

  @Override
  public void aplicarServicio() {
    log().info("Aplicando baño...");
  }

  @Override
  public double calcularPrecio() {
    return pesoMascota > 10 ? 6000.0 : 5000.0;
  }
}

