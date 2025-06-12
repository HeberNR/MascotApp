package mascotapp.model;

import mascotapp.util.Loggable;


/**
 * Clase Turno que representa un dueño de mascotas.
 * Un dueño puede tener hasta 4 mascotas y se pueden agregar nuevas mascotas a su lista.
 */
public class Duenio implements Loggable {
  private final int id;
  private String nombre;
  private String telefono;
  Mascota[] mascotas;
  static int contadorDuenios = 0;
  private int cantidadMascotas = 0;


  /**
   * Constructor de la clase Duenio.
   *
   * @param nombre   Nombre del dueño.
   * @param telefono Teléfono del dueño.
   * @param mascotas Array de mascotas del dueño, con un máximo de 4.
   */
  public Duenio(String nombre, String telefono) {
    this.id = contadorDuenios++;
    this.nombre = nombre;
    this.telefono = telefono;
    this.mascotas = new Mascota[4];
    this.cantidadMascotas = 0;
  }

  // setters
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  // getters
  public String getNombre() {
    return nombre;
  }

  public String getTelefono() {
    return telefono;
  }

  public int getId() {
    return id;
  }

  public Mascota[] getMascotas() {
    return mascotas;
  }

  @Override
  public String toString() {
    return ("Duenio: " + nombre
        + " Telefono: " + telefono
        + " ID: " + id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Duenio duenio = (Duenio) obj;
    return id == duenio.id;
  }

  @Override
  public int hashCode() {
    return Integer.hashCode(id);
  }

  /**
   * Método para agregar una mascota al dueño.
   * Si el dueño ya tiene 4 mascotas, no se puede agregar más.
   *
   * @param m Mascota a agregar al dueño.
   */
  public void agregarMascota(Mascota m) {
    if (cantidadMascotas < mascotas.length) {
      mascotas[cantidadMascotas++] = m;
    } else {
      log().info("Este dueño ya tiene el máximo de 4 mascotas.");
    }
  }

  /**
   * Método para mostrar las mascotas del dueño.
   * Recorre el array de mascotas y muestra la ficha de cada una.
   */
  public void mostrarMascotas() {
    log().info("Mascotas de " + nombre + ":");
    if (cantidadMascotas == 0) {
      log().info("  - No tiene mascotas registradas.");
    } else {
      for (int i = 0; i < cantidadMascotas; i++) {
        Mascota m = mascotas[i];
        if (m != null) {
          log().info("  - " + m.getNombre() + " (" + m.getClass().getSimpleName() + ")");
        }
      }
    }
  }
}

