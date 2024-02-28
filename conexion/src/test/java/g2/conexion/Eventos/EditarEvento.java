package g2.conexion.Eventos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import g2.conexion.model.Evento;

/**
 * El nombre del evento es PK, tiene que estar relleno
 */
public class EditarEvento {
    private Evento eventoPrueba;
    @BeforeEach
    public void init(){
        eventoPrueba = new Evento();
    }

    @AfterEach
    public void terminate(){
        
    }
}
