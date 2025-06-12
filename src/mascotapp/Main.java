package mascotapp;

import java.time.LocalDate;
import java.util.logging.Logger;
import mascotapp.enums.Comportamiento;
import mascotapp.model.Duenio;
import mascotapp.model.Gato;
import mascotapp.model.Mascota;
import mascotapp.model.Perro;
import mascotapp.model.Turno;
import mascotapp.model.servicios.Banio;
import mascotapp.model.servicios.ComboCompleto;
import mascotapp.model.servicios.CortePelo;
import mascotapp.model.servicios.LimpiezaOido;
import mascotapp.model.servicios.Servicios;

/**
 * Clase principal que inicia la aplicación MascotApp.
 * Esta clase contiene el método main que crea dueños, mascotas, asigna servicios y turnos,
 * y muestra detalles de los mismos.
 */
public class Main {
  public static final Logger LOG = Logger.getLogger(Main.class.getName());

  /**
   * Método principal que inicia la aplicación MascotApp.
   * Crea dueños, mascotas, asigna servicios y turnos, y muestra detalles de los mismos.
   *
   * @param args Argumentos de línea de comandos (no utilizados).
   */
  public static void main(String[] args) {
    LOG.info("===== INICIO DEL SISTEMA MascotApp =====");

    // === DUEÑOS ===
    Duenio d1 = new Duenio("Heber", "3482605057");
    Duenio d2 = new Duenio("Keila", "3482123456");

    // === MASCOTAS ===
    Mascota perro1 = new Perro("Roco", 4, "Labrador", Comportamiento.OBEDIENTE, 45, 22);
    Mascota gato1 = new Gato("Varian", 1, "Naranjoso", Comportamiento.MIMOSO, "Naranja", 20, 5);
    Mascota gato2 = new Gato("Timo", 1, "Naranjoso", Comportamiento.MIMOSO, "Naranja", 15, 4);

    // === ASIGNAR MASCOTAS A DUEÑOS ===
    d1.agregarMascota(perro1);
    d1.agregarMascota(gato1);
    d2.agregarMascota(gato2);

    // === SERVICIOS CON POLIMORFISMO ===
    Servicios banio = new Banio(gato1.getPeso());
    Servicios corte = new CortePelo(perro1.getTamanio());
    Servicios limpieza = new LimpiezaOido(gato2.getTamanio());
    Servicios banio1 = new Banio(gato2.getPeso());
    Servicios corte1 = new CortePelo(gato2.getTamanio());
    Servicios combo = new ComboCompleto(banio1, corte1, limpieza);

    // === APLICAR SERVICIOS ===
    combo.aplicarServicio();
    banio.aplicarServicio();
    corte.aplicarServicio();
    limpieza.aplicarServicio();

    // === TURNOS CON SOBRECARGA ===
    Turno turno1 = new Turno(LocalDate.of(2025, 6, 20), gato1, d1, banio);
    Turno turno2 = new Turno(LocalDate.of(2025, 6, 21), perro1, corte);
    Turno turno3 = new Turno(LocalDate.of(2025, 6, 21), gato2, d2, combo);

    turno1.confirmarTurno();
    turno2.confirmarTurno();
    turno3.confirmarTurno();

    // === DETALLES DE TURNOS ===
    LOG.info("\n========== DETALLES DE TURNOS ==========");
    turno1.mostrarDetalles();
    turno2.mostrarDetalles();
    turno3.mostrarDetalles();

    // === COSTOS DE SERVICIOS ===
    LOG.info("\n========== COSTOS DE SERVICIOS ==========");
    String costos = "Baño: $" + banio.calcularPrecio()
        + " Corte de Pelo: $" + corte.calcularPrecio()
        + " Limpieza de Oídos: $" + limpieza.calcularPrecio()
        + " Combo Completo: $" + combo.calcularPrecio();
    LOG.info(costos);

    // === FICHAS DE MASCOTAS (SOBRESCRITURA) ===
    LOG.info("\n========== FICHAS DE MASCOTAS ==========");
    gato1.mostrarFicha();
    perro1.mostrarFicha();
    gato2.mostrarFicha();

    // === USO DE FINAL (ID ÚNICO) ===
    LOG.info("\n========== ID DE MASCOTAS (FINAL) ==========");
    LOG.info(gato1.getDescripcionId());
    LOG.info(perro1.getDescripcionId());
    LOG.info(gato2.getDescripcionId());

    // === FICHAS DE MASCOTAS (SOBRESCRITURA) ===
    LOG.info("\n========== MASCOTAS ASIGNADAS A DUEÑOS ==========");
    d1.mostrarMascotas();
    d2.mostrarMascotas();

    LOG.info("===== FIN DEL SISTEMA MascotApp =====");

  }
}
