package model;

/**
 * Clase Turno que representa un dueño de mascotas.
 * Un dueño puede tener hasta 4 mascotas y se pueden agregar nuevas mascotas a su lista.
 */
public class Duenio implements Loggable {
  private final int id;
  private String nombre;
  private String telefono;
  private String direccion;
  Mascota[] mascotas = new Mascota[4];
  private static int contadorDuenios = 0;

  /**
   * Constructor de la clase Duenio.
   *
   * @param nombre    Nombre del dueño.
   * @param telefono  Teléfono del dueño.
   * @param direccion Dirección del dueño.
   * @param mascotas  Array de mascotas del dueño, con un máximo de 4.
   */
  public Duenio(String nombre, String telefono, String direccion, Mascota[] mascotas) {
    this.id = contadorDuenios++;
    this.nombre = nombre;
    this.telefono = telefono;
    this.direccion = direccion;
    this.mascotas = mascotas;
  }

  // setters
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }


  // getters
  public String getNombre() {
    return nombre;
  }

  public String getTelefono() {
    return telefono;
  }

  public String getDireccion() {
    return direccion;
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
        + " Dirección: " + direccion
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
   * @param mascotas Mascota a agregar al dueño.
   */
  public void agregarMascota(Mascota mascotas) {
    for (int i = 0; i < this.mascotas.length; i++) {
      if (this.mascotas[i] == null) {
        this.mascotas[i] = mascotas;
        log().info("Mascota agregada: " + mascotas.getNombre());
      } else {
        log().info("No se puede agregar más mascotas, el límite es 4.");
      }
    }
  }

  /**
   * Método para mostrar las mascotas del dueño.
   * Recorre el array de mascotas y muestra la ficha de cada una.
   */
  public void mostrarMascotas() {
    log().info("Mascotas del dueño:");
    for (Mascota mascota : mascotas) {
      if (mascota != null) {
        mascota.mostrarFicha();
      } else {
        log().info("No hay mascota en esta posición.");
      }
    }
  }
}
