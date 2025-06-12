package mascotapp.model;

import mascotapp.enums.Comportamiento;
import mascotapp.util.Loggable;

/**
 * Clase Perro que representa una mascota de tipo perro con un nombre, edad, raza y comportamiento.
 * Extiende la clase Mascota e implementa la interfaz Loggable para registrar información.
 */
public class Perro extends Mascota implements Loggable {
  /**
   * Constructor de la clase Perro.
   *
   * @param nombre         Nombre del perro.
   * @param edad           Edad del perro.
   * @param raza           Raza del perro.
   * @param comportamiento Comportamiento del perro.
   */
  public Perro(String nombre, int edad, String raza, Comportamiento comportamiento,
               String tipo, int tamanio, int peso) {
    super(nombre, edad, raza, comportamiento, tamanio, peso);
  }

  @Override
  public String tipoMascota() {
    return "Perro";
  }

  @Override
  public void mostrarFicha() {
    log().info("Tipo: " + tipoMascota()
        + ", Nombre: " + getNombre()
        + ", Edad: " + getEdad()
        + ", Raza: " + getRaza()
        + ", Comportamiento: " + getComportamiento()
        + ", Tamaño: " + getTamanio()
        + ", Peso: " + getPeso()
        + ", ID: " + getid());
  }
}
