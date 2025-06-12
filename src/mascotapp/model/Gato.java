package mascotapp.model;

import mascotapp.enums.Comportamiento;
import mascotapp.util.Loggable;

/**
 * Clase Gato que representa un gato como una mascota con un nombre,
 * edad, raza, comportamiento y color.
 * Extiende la clase Mascota e implementa la interfaz Loggable para registrar información.
 */
public class Gato extends Mascota implements Loggable {
  private String color;

  /**
   * Constructor de la clase Gato.
   *
   * @param nombre         Nombre del gato.
   * @param edad           Edad del gato.
   * @param raza           Raza del gato.
   * @param comportamiento Comportamiento del gato.
   * @param color          Color del gato.
   */
  public Gato(String nombre, int edad, String raza, Comportamiento comportamiento,
              String color, int tamanio, int peso) {
    super(nombre, edad, raza, comportamiento, tamanio, peso);
    this.color = color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  @Override
  public String tipoMascota() {
    return "Gato";
  }

  @Override
  public void mostrarFicha() {
    log().info("Tipo: " + tipoMascota()
        + ", Nombre: " + getNombre()
        + ", Edad: " + getEdad()
        + ", Raza: " + getRaza()
        + ", Color: " + getColor()
        + ", Comportamiento: " + getComportamiento()
        + ", Tamaño: " + getTamanio()
        + ", Peso: " + getPeso()
        + ", ID: " + getid());
  }

}
