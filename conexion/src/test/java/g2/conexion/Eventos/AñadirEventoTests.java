package g2.conexion.Eventos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import g2.conexion.model.Evento;

/**
 * Testear: creacion de eventos con datos erroneos y conrrectos
 * Testear: estado final de la app tras añadir el evento ==> nº de participantes, el creador, ....
 */
public class AñadirEventoTests {
    private Evento eventoPrueba;
    @BeforeEach
    public void init(){
        eventoPrueba = new Evento();
    }

    @AfterEach
    public void terminate(){
        
    }
}
