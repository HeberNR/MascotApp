package model;

import java.util.logging.Logger;

/**
 * Interfaz Loggable que proporciona un método para obtener un logger.
 */
public interface Loggable {
  /**
   * Obtiene un logger para la clase que implementa esta interfaz.
   *
   * @return Logger para las clases que implementan esta interfaz.
   */
  default Logger log() {
    return Logger.getLogger(this.getClass().getName());
  }
}
