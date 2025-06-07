package model;

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
  public Gato(String nombre, int edad, String raza, Comportamiento comportamiento, String color) {
    super(nombre, edad, raza, comportamiento);
    this.color = color;
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
        + ", Color: " + color
        + ", ID: " + getid());
  }
}
