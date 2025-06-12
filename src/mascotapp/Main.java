package mascotapp;

import mascotapp.enums.Comportamiento;
import mascotapp.model.*;
import mascotapp.model.servicios.*;

import java.time.LocalDate;
import java.util.logging.Logger;

public class Main {

  public static final Logger LOG = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    // Dueños
    Duenio d1 = new Duenio("Heber", "3482605057");
    Duenio d2 = new Duenio("Keila", "3482123456");
    Duenio d3 = new Duenio("Marcos", "3482999888");
    Duenio d4 = new Duenio("Valeria", "3482555444");

    // Mascotas
    Mascota perro1 = new Perro("Roco", 4, "Labrador", Comportamiento.OBEDIENTE, "Perro", 45, 22);
    Mascota perro2 = new Perro("Kira", 6, "Caniche", Comportamiento.OBEDIENTE, "Perro", 20, 6);
    Mascota perro3 = new Perro("Firu", 2, "Bulldog", Comportamiento.AGRESIVO, "Perro", 30, 18);

    Mascota gato1 = new Gato("Varian", 1, "Naranjoso", Comportamiento.MIMOSO, "Naranja", 10, 4);
    Mascota gato2 = new Gato("Timo", 1, "Atigrado", Comportamiento.MIMOSO, "Naranja", 8, 3);
    Mascota gato3 = new Gato("Michi", 5, "Siames", Comportamiento.AGRESIVO, "Blanco", 12, 5);

    // Asignar mascotas
    d1.agregarMascota(perro1);
    d1.agregarMascota(gato1);
    d2.agregarMascota(perro2);
    d2.agregarMascota(gato2);
    d3.agregarMascota(perro3);
    d4.agregarMascota(gato3);

    // Servicios (polimorfismo con la interfaz Servicio)
    Servicios banio = new Banio(gato1.getPeso());
    Servicios corte = new CortePelo(perro2.getTamanio());
    Servicios limpieza = new LimpiezaOido(gato3.getTamanio());
    Servicios combo = new ComboCompleto(banio, corte, limpieza);

    // Turnos con sobrecarga
    Turno turno1 = new Turno(LocalDate.of(2025, 6, 20), gato1, d1, banio); // con dueño
    Turno turno2 = new Turno(LocalDate.of(2025, 6, 21), perro2, corte);   // sin dueño
    Turno turno3 = new Turno(LocalDate.of(2025, 6, 22), gato3, d4, limpieza);
    Turno turno4 = new Turno(LocalDate.of(2025, 6, 23), perro3, d3, combo);

    // Confirmar turnos
    turno1.confirmarTurno();
    turno2.confirmarTurno();
    turno3.confirmarTurno();
    turno4.confirmarTurno();

    // Mostrar detalles
    LOG.info("\n========== DETALLES DE TURNOS ==========");
    turno1.mostrarDetalles();
    turno2.mostrarDetalles();
    turno3.mostrarDetalles();
    turno4.mostrarDetalles();

    // Mostrar costos aplicando polimorfismo
    LOG.info("\n========== COSTOS DE SERVICIOS ==========");
    LOG.info("Banio: $" + banio.calcularPrecio());
    LOG.info("Corte Pelo: $" + corte.calcularPrecio());
    LOG.info("Limpieza de Oidos: $" + limpieza.calcularPrecio());
    LOG.info("Combo Completo: $" + combo.calcularPrecio());

    // Mostrar ficha sobrescrita de mascotas
    LOG.info("\n========== FICHA DE MASCOTAS ==========");
    gato1.mostrarFicha();
    perro2.mostrarFicha();
    gato3.mostrarFicha();
    perro3.mostrarFicha();

    // Mostrar uso de final con ID
    LOG.info("\n========== ID DE MASCOTAS (final) ==========");
    LOG.info("ID de " + gato1.getNombre() + ": " + gato1.getid());
    LOG.info("ID de " + perro3.getNombre() + ": " + perro3.getid());
  }
}
