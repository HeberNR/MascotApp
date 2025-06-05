package model;

public abstract class Mascota {

  private String nombre;
  private int edad;
  private String raza;
  private Comportamiento comportamiento;
  private final String ID;

  public Mascota(String ID, Comportamiento comportamiento, String raza, int edad, String nombre) {
    this.ID = ID;
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

  public String getID() {
    return ID;
  }

  public void mostrarFicha () {}

  abstract String tipoMascota();
}
