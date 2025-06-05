package model;

public class Perro extends Mascota {

  public Perro(String ID, Comportamiento comportamiento, String raza, int edad, String nombre) {
    super(ID, comportamiento, raza, edad, nombre);
  }


  @Override
  String tipoMascota() {
    return "";
  }
}
