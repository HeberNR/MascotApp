package model;

/**
 * Representa una mascota (base para Perro y Gato) en el sistema MascotApp.
 * Contiene atributos comunes como nombre, edad, y comportamiento.
 */
public abstract class Mascota implements Loggable {

  private String nombre;
  private int edad;
  private String raza;
  private Comportamiento comportamiento;
  private final String id;
  private static int contadorMascotas = 0;

  /**
   * Constructor de la clase Mascota.
   *
   * @param nombre         Nombre de la mascota.
   * @param edad           Edad de la mascota.
   * @param raza           Raza de la mascota.
   * @param comportamiento Comportamiento de la mascota.
   */
  protected Mascota(String nombre, int edad, String raza, Comportamiento comportamiento) {
    this.id = "MASC-" + contadorMascotas++;
    this.comportamiento = comportamiento;
    this.raza = raza;
    this.edad = edad;
    this.nombre = nombre;
  }

  // setters
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public void setRaza(String raza) {
    this.raza = raza;
  }

  public void setComportamiento(Comportamiento comportamiento) {
    this.comportamiento = comportamiento;
  }

  // getters
  public String getNombre() {
    return nombre;
  }

  public int getEdad() {
    return edad;
  }

  public String getRaza() {
    return raza;
  }

  public Comportamiento getComportamiento() {
    return comportamiento;
  }

  /**
   * Obtiene el ID único de la mascota.
   *
   * @return ID de la mascota.
   */
  public String getid() {
    return id;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Mascota mascota = (Mascota) obj;
    return id.equals(mascota.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  /**
   * Método para mostrar la ficha de la mascota.
   * Imprime los detalles de la mascota en el log.
   */
  public void mostrarFicha() {
    log().info("Nombre: " + nombre + ", Edad: " + edad + ", Paciente: "
        + id + ", Raza: " + raza + ", Comportamiento: " + comportamiento);
  }

  /**
   * Método abstracto para obtener el tipo de mascota.
   * Debe ser implementado por las subclases.
   *
   * @return Tipo de mascota como String.
   */
  public abstract String tipoMascota();
}
